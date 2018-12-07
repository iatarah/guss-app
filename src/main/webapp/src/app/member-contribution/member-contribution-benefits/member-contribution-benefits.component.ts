import { BenefitsResponse } from './../../gen/model/benefitsResponse';
import { BaseResponse } from './../../gen/model/baseResponse';
import { RefundBenefits } from './../../gen/model/refundBenefits';
import { BenefitsType } from './../../gen/model/benefitsType';
import { BaseRequest } from './../../gen/model/baseRequest';
import { BenefitsRequest } from './../../gen/model/benefitsRequest';
import { MemberContributionService } from './../../gen/api/memberContribution.service';
import { Component, OnInit, Input } from '@angular/core';
import { PensionBenefits } from 'src/app/gen';

@Component({
  selector: 'app-member-contribution-benefits',
  templateUrl: './member-contribution-benefits.component.html',
  styleUrls: ['./member-contribution-benefits.component.css']
})
export class MemberContributionBenefitsComponent implements OnInit {
  @Input() memberId: string;
  benefitsResponse: BenefitsResponse;
  constructor(private contributionService: MemberContributionService) { }

  ngOnInit() {
    if(this.memberId) {
      this.contributionService.retrieveBenefits(this.buildBenefitsRequest(this.memberId, "", "")).subscribe(data => {
        this.benefitsResponse = data;
      });
    }
  }

  public buildBenefitsRequest(memberId: string, userId: String, benefitType: string): BenefitsRequest {
    let benefitsRequest: BenefitsRequest = {
      baseRequest: null,
      memberId: null,
      benefitsType: null
    };
    let baseRequest: BaseRequest = {
      userId: null,
      memberId: null
    };

    let benType: BenefitsType = "PENSION";

    baseRequest.memberId = memberId;
    benefitsRequest.baseRequest = baseRequest;
    benefitsRequest.memberId = memberId;
    benefitsRequest.benefitsType = benType;
    return benefitsRequest;
  }
}
