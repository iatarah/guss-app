package org.ugguss.service.serviceImpl.provider;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.ugguss.generated.model.BaseResponse;
import org.ugguss.generated.model.Contribution;
import org.ugguss.generated.model.ContributionHistoryResponse;
import org.ugguss.generated.model.ContributionRequest;
import org.ugguss.generated.model.ContributionResponse;
import org.ugguss.generated.model.UserProfileResponse;
import org.ugguss.model.GussMember;
import org.ugguss.model.GussMemberContribution;
import org.ugguss.model.User;
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

}
