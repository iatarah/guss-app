package org.ugguss.service.serviceImpl.provider;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static java.lang.Math.toIntExact;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.ugguss.controllerimpl.ProfilesApiController;
import org.ugguss.generated.model.AppUser;
import org.ugguss.generated.model.BaseResponse;
import org.ugguss.generated.model.BenefitsRequest;
import org.ugguss.generated.model.BenefitsResponse;
import org.ugguss.generated.model.Contribution;
import org.ugguss.generated.model.ContributionHistoryResponse;
import org.ugguss.generated.model.ContributionRequest;
import org.ugguss.generated.model.ContributionResponse;
import org.ugguss.generated.model.Member;
import org.ugguss.generated.model.PensionBenefits;
import org.ugguss.generated.model.UserProfileResponse;
import org.ugguss.model.AppParameter;
import org.ugguss.model.GussMember;
import org.ugguss.model.GussMemberContribution;
import org.ugguss.model.User;
import org.ugguss.repository.IAppParameterRepository;
import org.ugguss.repository.IGussMemberContributionRepository;
import org.ugguss.repository.IGussMemberRepository;
import org.ugguss.repository.IUserRepository;
import org.ugguss.service.IGussMemberService;
import org.ugguss.service.IGussMemberServiceProvider;
import org.ugguss.util.ContributionServiceMapperUtil;
import org.ugguss.util.UserServiceMapperUtil;
import org.ugguss.util.constants.AppConstants;

@Component
@Qualifier(value="GussMemberServiceImplProvider")
public class GussMemberServiceImplProvider implements IGussMemberServiceProvider{
	private static final Logger LOG = LogManager.getLogger(GussMemberServiceImplProvider.class);
	@Autowired
	private IGussMemberRepository iGussMemberRepository;
	@Autowired
	private IGussMemberService iGussMemberService;
	@Autowired
	private ContributionServiceMapperUtil contributionServiceMapperUtil;
	@Autowired
	private IGussMemberContributionRepository  iGussMemberContributionRepository;
    @Autowired
    private IUserRepository iUserRepository;
    @Autowired
    private UserServiceMapperUtil userServiceMapperUtil;
    @Autowired
    private IAppParameterRepository iAppParameterRepository;
    
	@Override
	public GussMember getGussMemberByMemberId(String memberId) {
		return iGussMemberRepository.findGussMemberByMemberId(memberId);
	}

	@Override
	public GussMember getGussMemberByUserId(int userId) {
		return iGussMemberRepository.findGussMemberByUserId(userId);
	}

	@Override
	public ContributionResponse createContribution(ContributionRequest contributionRequest) {
		
		ContributionResponse response = new ContributionResponse();
		response.setBaseResponse(new BaseResponse());
		
		if(contributionRequest == null
				|| contributionRequest.getContribution() == null) {
			response.getBaseResponse().setReturnCode(AppConstants.ERROR_CODE);
			return response;
		}
		
		GussMember gussMember = iGussMemberService.getGussMemberByMemberId(
				contributionRequest.getContribution().getMemberId());
		GussMemberContribution dbContribution = contributionServiceMapperUtil
				.contributionDTOtoDbContribution(contributionRequest.getContribution());
		dbContribution.setGussMember(gussMember);
		dbContribution.setDateCreated(new Date());
		dbContribution.setPaymentDate(new Date());
		GussMemberContribution savedContribution = iGussMemberContributionRepository.save(dbContribution);
		response.setContribution(
					contributionServiceMapperUtil.dbContributionToDTOcontribution(savedContribution));
		response.getBaseResponse().setReturnCode(AppConstants.SUCCESS_CODE);
		return response;
			 
	}

	@Override
	public ContributionHistoryResponse getContribution(String memberId, String startDate, String endDate) {
		ContributionHistoryResponse response = new ContributionHistoryResponse();
		response.setBaseResponse(new BaseResponse());
		
		if(memberId == null){
			response.getBaseResponse().setReturnCode(AppConstants.ERROR_CODE);
			return response;
		}
		
		List<GussMemberContribution> gussMemberContributionList = null;
		List<Contribution> contributionHistory = new ArrayList<>();
		
		// TODO: add logic here to fetch by startDate and endDate
		Date queryStartDate = null;
		Date queryEndDate = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			queryStartDate = sdf.parse(startDate);
			queryEndDate = sdf.parse(endDate);
		} catch (Exception e) {
			// TODO: handle exception
			response.getBaseResponse().setReturnCode(AppConstants.ERROR_CODE);
			return response;
		}
		
		gussMemberContributionList = iGussMemberContributionRepository.findContributionByMemberIdAndDate(memberId, queryStartDate, queryEndDate);
		for(GussMemberContribution gc : gussMemberContributionList) {
			contributionHistory.add(
					contributionServiceMapperUtil.dbContributionToDTOcontribution(gc));
		}
		
		response.setContributionHistory(contributionHistory);
		response.getBaseResponse().setReturnCode(AppConstants.SUCCESS_CODE);
		return response;
	}

	@Override
	public UserProfileResponse getUserByGussMemberId(String memberId) throws Exception {
		UserProfileResponse response = new UserProfileResponse();
		response.setBaseResponse(new BaseResponse());

		User user = null;

		GussMember gussMember = iGussMemberService.getGussMemberByMemberId(memberId);
		
		if(gussMember != null) {
			user = gussMember.getUser();
		}
		
		if(gussMember == null || user == null) {
			LOG.debug("No such Member in database with memberId: {}", memberId);
			response.getBaseResponse().returnCode(AppConstants.ERROR_CODE);
			return response;
		}
		
		AppUser appUser = userServiceMapperUtil.dbUserToAppUser(user);
		Member member = userServiceMapperUtil.gussMemberTodtoMember(gussMember);
		
		response.setAppUser(appUser);
		response.setGussMember(member);
		response.getBaseResponse().setReturnCode(AppConstants.SUCCESS_CODE);
		return response;
	}

	@Override
	public BenefitsResponse retrieveBenefits(BenefitsRequest benefitsRequest) throws Exception {
		BenefitsResponse response = new BenefitsResponse();
		response.baseResponse(new BaseResponse());
		
		if(benefitsRequest == null
				|| benefitsRequest.getMemberId() ==  null
				|| benefitsRequest.getBenefitsType() == null) {
			LOG.debug("Input for benefits retrieval not valid, request: {}", benefitsRequest);
			response.getBaseResponse().setReturnCode(AppConstants.ERROR_CODE);
			return response;
			
		}
		
		GussMember member = getGussMemberByMemberId(benefitsRequest.getMemberId());
		if(member == null
				|| member.getCurrentSalary() == null) {
			LOG.debug("No current salary for such member with memberId : {}", benefitsRequest.getMemberId());
			response.getBaseResponse().setReturnCode(AppConstants.ERROR_CODE);
			return response;
		}
		
		// TODO: logic here to compute other kinds of benefits (unExpired and refund)
		int monthsServed = toIntExact(iGussMemberContributionRepository.getTotalContributionMonths(benefitsRequest.getMemberId()));
		
		List<AppParameter> appParams = iAppParameterRepository.findAll();
		Double FACTOR_ENH = null;
		Double FACTOR_G = null;
		Double FACTOR_M = null;
		Integer TOTAL_MONTHS = null;
		Double enhSal = null;
		for(AppParameter param : appParams) {
			if(AppConstants.FACTOR_ENH.equalsIgnoreCase(param.getParamName())) {
				FACTOR_ENH = Double.parseDouble(param.getParamValue());
			} else if(AppConstants.FACTOR_G.equalsIgnoreCase(param.getParamName())) {
				FACTOR_G = Double.parseDouble(param.getParamValue());
			} else if(AppConstants.FACTOR_M.equalsIgnoreCase(param.getParamName())) {
				FACTOR_M = Double.parseDouble(param.getParamValue());
			} else if(AppConstants.TOTAL_MONTHS.equalsIgnoreCase(param.getParamName())) {
				TOTAL_MONTHS = Integer.parseInt(param.getParamValue());
			}
		}
		enhSal = FACTOR_ENH * member.getCurrentSalary()*12;
		PensionBenefits pensionBenefits = computePensionBenefits(monthsServed, member.getCurrentSalary(), 
				enhSal, FACTOR_G, FACTOR_M, TOTAL_MONTHS);
		response.setPensionBenefits(pensionBenefits);
		response.getBaseResponse().setReturnCode(AppConstants.SUCCESS_CODE);
		return response;
	}
	
	public PensionBenefits computePensionBenefits(int monthsServed, double currentSalary,
			double enhSal,
			double factorG,
			double factorM,
			int totalMonths) {
		PensionBenefits pensionBenefits = new PensionBenefits();
		
		double fullPension = (monthsServed * currentSalary)/totalMonths;
		pensionBenefits.setFullPension(BigDecimal.valueOf(fullPension));
		pensionBenefits.setTerminalSalary(BigDecimal.valueOf(currentSalary * 12));
		pensionBenefits.monthsEntitled(BigDecimal.valueOf(monthsServed));
		pensionBenefits.setGratuity(BigDecimal.valueOf(
				computeGratuity(enhSal, factorG, monthsServed, totalMonths)));
		pensionBenefits.setMonthlyPension(BigDecimal.valueOf(
				computeMonthlyPension(enhSal, factorM, monthsServed, totalMonths)));
		return pensionBenefits;
		
	}
	
	public double computeMonthlyPension(double enhSal, double factorM, int monthsServed, int totalMonths) {
		double monthlyPen = ((enhSal * monthsServed) * factorM)/totalMonths;
		return monthlyPen;
	}
	
	public double computeGratuity(double enhSal, double factorG, int monthsServed, int totalMonths) {
		double monthlyPen = ((enhSal * monthsServed) * factorG)/totalMonths;
		return monthlyPen;
	}
}
