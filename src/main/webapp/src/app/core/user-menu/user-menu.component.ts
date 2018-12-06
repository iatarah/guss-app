import { OnInit, Component, Input } from "@angular/core";
import { AuthService } from "../../shared/_services/auth.service";
import { Router } from "@angular/router";
import { AppConfig } from "../../config/app.config";

@Component({
    selector: 'app-user-menu',
    templateUrl: './user-menu.component.html',
    styleUrls: ['./user-menu.component.css']
})
export class UserMenuComponent implements OnInit {
    isOpen: boolean = false;
    @Input() currentUser = null;

    constructor(private authService : AuthService, private router: Router) {}

    ngOnInit() {}

    private onLogout() {
        this.authService.logout();
        this.router.navigate([AppConfig.routes.login])
      }
}