import { UserService } from './../../gen/api/user.service';
import { AppUser } from './../../gen/dist/model/appUser.d';

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  memberProfile: AppUser;
  
  constructor(private userService: UserService) { }

  ngOnInit() {
    this.userService.getMember("johnDoe1@test.com").subscribe(data => {
      this.memberProfile = data.appUser;
    })
  }

}
