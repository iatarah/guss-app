import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { UserProfileService } from './shared/user-profile/user-profile.service';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { HttpModule } from '@angular/http';

@NgModule({
  declarations: [
    AppComponent,
    UserProfileComponent
  ],
  imports: [
    BrowserModule, HttpClientModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
