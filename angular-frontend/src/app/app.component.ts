import { Component } from '@angular/core';
import {AuthConfig, NullValidationHandler, OAuthService} from "angular-oauth2-oidc";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(private oAuthService:OAuthService) {
    this.configure();
  }
  authCodeFlowConfig: AuthConfig = {
    // Url of the Identity Provider
    issuer: 'http://localhost:8080/auth/realms/spring-boot-angular',
    redirectUri: window.location.origin,
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

  login():void{

    this.oAuthService.initImplicitFlowInternal();
  }
  logout():void{
    this.oAuthService.logOut();
  }

  getName(){
    //return this.oAuthService.getAccessToken();
    const token = this.oAuthService.getAccessToken();
    const payload = token.split('.')[1];
    const payloadDecodedJson = atob(payload);
    const payloadDecoded = JSON.parse(payloadDecodedJson);
    //return payloadDecoded.realm_access.roles;
    console.log(payloadDecoded.realm_access.roles)
    return payloadDecoded.given_name

  }
}
