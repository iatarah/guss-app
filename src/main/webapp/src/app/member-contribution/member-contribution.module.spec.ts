import { MemberContributionModule } from './member-contribution.module';

describe('MemberContributionModule', () => {
  let memberContributionModule: MemberContributionModule;

  beforeEach(() => {
    memberContributionModule = new MemberContributionModule();
  });

  it('should create an instance', () => {
    expect(memberContributionModule).toBeTruthy();
  });
});
