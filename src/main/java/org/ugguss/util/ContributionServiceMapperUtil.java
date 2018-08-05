package org.ugguss.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.ugguss.generated.model.Contribution;
import org.ugguss.model.GussMember;
import org.ugguss.model.GussMemberContribution;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ContributionServiceMapperUtil {
	
	@Mappings({
		@Mapping(target = "docId", source = "documentId"),
		@Mapping(target = "fiscalMonth", source = "fiscalMonth", dateFormat = "dd-MM-yyyy"),
		@Mapping(target = "fiscalYear", source = "fiscalYear", dateFormat = "dd-MM-yyyy"),
		@Mapping(target = "contributionCategory", source = "contributionCategory"),
		//@Mapping(target = "paymentDate", source = "paymentDate", dateFormat = "dd-MM-yyyy HH:mm:ss"),
		@Mapping(target = "comments", source = "comments"),
		@Mapping(target = "amount", source = "amount"),
		//@Mapping(target = "lastUpdated", source = ""),
	})
	GussMemberContribution contributionDTOtoDbContribution(Contribution contribution);
	
	@Mappings({
		@Mapping(target = "documentId", source = "docId"),
		@Mapping(target = "fiscalMonth", source = "fiscalMonth", dateFormat = "MMM"),
		@Mapping(target = "fiscalYear", source = "fiscalYear", dateFormat = "yyyy"),
		@Mapping(target = "contributionCategory", source = "contributionCategory"),
		@Mapping(target = "paymentDate", source = "dateCreated", dateFormat = "dd-MM-yyyy"),
		@Mapping(target = "comments", source = "comments"),
		@Mapping(target = "memberId", source = "gussMember"),
		@Mapping(target = "dateCreated", source = "dateCreated", dateFormat = "dd-MM-yyyy"),
		@Mapping(target = "amount", source = "amount"),
	})
	Contribution dbContributionToDTOcontribution(GussMemberContribution gussMemberContribution);
	
	default String memberId(GussMember member) {
		String ssn = null;
		if(member != null){
			ssn = member.getMemberSsn();
		}
		return ssn;
	}

}
