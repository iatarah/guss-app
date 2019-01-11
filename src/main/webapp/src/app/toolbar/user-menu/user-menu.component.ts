import { OnInit, Component, Input } from "@angular/core";
import { AuthService } from "../../shared/_services/auth.service";
import { Router } from "@angular/router";
import { AppConfig } from "../../config/app.config";
import { CurrentUserService } from "../../shared/current-user.service";
import { AppUser } from "../../gen";

@Component({
    selector: 'app-user-menu',
    templateUrl: './user-menu.component.html',
    styleUrls: ['./user-menu.component.css']
})
export class UserMenuComponent implements OnInit {
    isOpen: boolean = false;
    @Input() currentUser = null;
    appUser : AppUser;
    userName : string;

    constructor(private authService : AuthService, private router: Router, 
        private currentUserService: CurrentUserService) {
            this.userName = null;
        }

    ngOnInit() {
        this.userName = sessionStorage.getItem("fName") + " " + sessionStorage.getItem("lName");
    }

    private onLogout() {
        this.authService.logout();
        this.router.navigate([AppConfig.routes.login])
      }
}