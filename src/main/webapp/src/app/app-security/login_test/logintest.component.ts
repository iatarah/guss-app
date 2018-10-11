import { Component, OnInit } from "@angular/core";
import { FormGroup, FormBuilder, FormControl, Validators } from "@angular/forms";
import { LoginRequest, AuthenticationService } from "../../gen";

@Component({
    selector: 'app-logintest',
    templateUrl: './logintest.component.html'
})
export class LogintestComponent implements OnInit {
    loginForm : FormGroup;

    constructor(private formBuilder : FormBuilder,
                private authService : AuthenticationService) {}

    ngOnInit() {
        this.loginForm = this.formBuilder.group({
            username : new FormControl('', Validators.required),
            password : new FormControl('', Validators.required)
        })
    }

    onSubmit(user : any) {
        let loginRequest : LoginRequest = user;
        this.authService.authenticate(loginRequest).subscribe(
            (response) => {
                console.log('Response coming from authentication');
                console.log(response);
            }
        )
    }
}