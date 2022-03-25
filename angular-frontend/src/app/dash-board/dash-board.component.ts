import { Component, OnInit } from '@angular/core';
import {OAuthService} from "angular-oauth2-oidc";
import {faBan, faCircleCheck, faCircleExclamation, faCoffee} from "@fortawesome/free-solid-svg-icons";

@Component({
  selector: 'app-dash-board',
  templateUrl: './dash-board.component.html',
  styleUrls: ['./dash-board.component.css']
})
export class DashBoardComponent implements OnInit {
  check = faCircleCheck;
  reject = faBan;
  pending = faCircleExclamation;
  constructor(private oAuthService:OAuthService) { }

  ngOnInit(): void {
  }

  logout(){
    this.oAuthService.logOut();
  }

}
