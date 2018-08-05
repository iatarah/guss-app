import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MemberContributionEntryComponent } from './member-contribution-entry.component';

describe('MemberContributionEntryComponent', () => {
  let component: MemberContributionEntryComponent;
  let fixture: ComponentFixture<MemberContributionEntryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MemberContributionEntryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MemberContributionEntryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
