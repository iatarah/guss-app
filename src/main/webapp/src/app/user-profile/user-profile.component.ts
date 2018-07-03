import { Component, OnInit } from '@angular/core';
import { UserProfileService } from '../shared/user-profile/user-profile.service';
@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  userProfile: any;
  constructor(private userProfileService: UserProfileService) { }

  ngOnInit() {
    this.userProfileService.getAll().subscribe(data => {
      this.userProfile = data;
    })
  }

}
