import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MemberContributionBenefitsComponent } from './member-contribution-benefits.component';

describe('MemberContributionBenefitsComponent', () => {
  let component: MemberContributionBenefitsComponent;
  let fixture: ComponentFixture<MemberContributionBenefitsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MemberContributionBenefitsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MemberContributionBenefitsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
