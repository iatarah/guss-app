import { Component, OnInit } from "@angular/core";
import { CurrentUserService } from "../../shared/current-user.service";
import { Member, AppUser } from "../../gen";

@Component({
    selector: 'app-toolbar',
    templateUrl: './toolbar.component.html',
    styleUrls: ['./toolbar.component.css']
})
export class ToolbarComponent implements OnInit {

    member : Member;
    appUser : AppUser;
    constructor() {
    }

    ngOnInit() {

    }
}