import { AppSecurityModule } from './app-security.module';

describe('AppSecurityModule', () => {
  let appSecurityModule: AppSecurityModule;

  beforeEach(() => {
    appSecurityModule = new AppSecurityModule();
  });

  it('should create an instance', () => {
    expect(appSecurityModule).toBeTruthy();
  });
});
