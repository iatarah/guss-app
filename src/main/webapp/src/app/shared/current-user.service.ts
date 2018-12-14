import { Member } from './../gen/model/member';
import { Injectable } from '@angular/core';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';
import { AppUser } from '../gen';
@Injectable({
  providedIn: 'root'
})
export class CurrentUserService {
  
  constructor() { }
  memberState = new BehaviorSubject<Member>(null);
  userState = new BehaviorSubject<AppUser>(null);
  currentMemberState = this.memberState.asObservable();

  changeMemberState(member: Member) {
    this.memberState.next(member);
  }

  changeUserState(appUser : AppUser) {
    this.userState.next(appUser);
  }
}
