import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {OAuthModule} from "angular-oauth2-oidc";
import { DashBoardComponent } from './Dashboard/dash-board/dash-board.component';
import { DashboardHeaderComponent } from './Dashboard/dashboard-header/dashboard-header.component';
import {FontAwesomeModule} from "@fortawesome/angular-fontawesome";
import { OwnerProfileComponent } from './Dashboard/owner-profile/owner-profile.component';
import { OwnerPropertiesComponent } from './Dashboard/owner-properties/owner-properties.component';
import {AccessTokenInterceptor} from "./Utils/access-token.interceptor";

@NgModule({
  declarations: [
    AppComponent,
    DashBoardComponent,
    DashboardHeaderComponent,
    OwnerProfileComponent,
    OwnerPropertiesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FontAwesomeModule,
    HttpClientModule,
    OAuthModule.forRoot()
  ],
  providers: [
     {provide:HTTP_INTERCEPTORS,useClass:AccessTokenInterceptor,multi:true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
