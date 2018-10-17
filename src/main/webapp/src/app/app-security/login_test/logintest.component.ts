import { Component, OnInit } from "@angular/core";
import { FormGroup, FormBuilder, FormControl, Validators } from "@angular/forms";
import { LoginRequest, AuthenticationService } from "../../gen";
import { AuthService } from "../../shared/_services/auth.service";

@Component({
    selector: 'app-logintest',
    templateUrl: './logintest.component.html'
})
export class LogintestComponent implements OnInit {
    loginForm : FormGroup;

    constructor(private formBuilder : FormBuilder,
                private authService : AuthenticationService,
                private authService2 : AuthService
                ) {}
                // 

    ngOnInit() {
        this.loginForm = this.formBuilder.group({
            email : new FormControl('', Validators.required),
            password : new FormControl('', Validators.required)
        })
    }

    onSubmit(user : any) {
        let loginRequest : LoginRequest = user;
        console.log(loginRequest.email);
        console.log(loginRequest.password);
        this.authService.authenticate(user, 'body', false).subscribe(
            (response) => {
                console.log('Response coming from authentication');
                console.log(response);
            }
        );

        // this.authService2.authenticateNew(loginRequest).subscribe(
        //     (response) => {
        //         console.log('Response Coming form authentication');
        //         console.log(response);
        //     }
        // );
    }
}