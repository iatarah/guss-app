import { Member } from './../gen/dist/model/member.d';
import { Injectable } from '@angular/core';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';
@Injectable({
  providedIn: 'root'
})
export class CurrentUserService {
  
  constructor() { }
  private memberState = new BehaviorSubject<Member>(null);
  currentMemberState = this.memberState.asObservable();

  changeMemberState(member: Member) {
    this.memberState.next(member);
  }
}
