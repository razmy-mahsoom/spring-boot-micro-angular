import {Component, OnInit} from '@angular/core';
import {AuthConfig, NullValidationHandler, OAuthService} from "angular-oauth2-oidc";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  constructor(private oAuthService:OAuthService,private http:HttpClient,private router:Router) {
    this.configure();
  }
  authCodeFlowConfig: AuthConfig = {
    // Url of the Identity Provider
    issuer: 'http://localhost:8080/auth/realms/spring-boot-angular',
    redirectUri: window.location.origin+'/dashboard',
    clientId: 'front-end',
    responseType: 'code',
    scope: 'openid profile email offline_access ',
    showDebugInformation: true,
  };

  configure():void{
    this.oAuthService.configure(this.authCodeFlowConfig);
    this.oAuthService.tokenValidationHandler = new NullValidationHandler();
    this.oAuthService.setupAutomaticSilentRefresh();
    this.oAuthService.loadDiscoveryDocument().then(()=>this.oAuthService.tryLogin());

  }
  ngOnInit() {

  }

  login():void{
    if(this.oAuthService.hasValidAccessToken()){
      console.log('Has Valid token')
    }else{
      this.oAuthService.initImplicitFlowInternal();
    }
  }
  logout():void{
    this.oAuthService.logOut();
  }

  getName(){
    return this.oAuthService.getAccessToken();

  }
}
