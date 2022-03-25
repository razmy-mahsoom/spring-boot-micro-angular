import { Component, OnInit } from '@angular/core';
import {OAuthService} from "angular-oauth2-oidc";

@Component({
  selector: 'app-dash-board',
  templateUrl: './dash-board.component.html',
  styleUrls: ['./dash-board.component.css']
})
export class DashBoardComponent implements OnInit {

  constructor(private oAuthService:OAuthService) { }

  ngOnInit(): void {
  }

  logout(){
    this.oAuthService.logOut();
  }

}
