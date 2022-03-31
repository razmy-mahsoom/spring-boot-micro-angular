import { Component, OnInit } from '@angular/core';
import {faBell, faCoffee} from "@fortawesome/free-solid-svg-icons";
import {OAuthService} from "angular-oauth2-oidc";

@Component({
  selector: 'app-dashboard-header',
  templateUrl: './dashboard-header.component.html',
  styleUrls: ['./dashboard-header.component.css']
})
export class DashboardHeaderComponent implements OnInit {
  notification = faBell;
  constructor(private oAuthService:OAuthService) { }

  ngOnInit(): void {
  }

  login() {
    this.oAuthService.initImplicitFlowInternal();
  }
  logout(){
    this.oAuthService.logOut();

  }
}
