import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import {OAuthService} from "angular-oauth2-oidc";

@Injectable()
export class AccessTokenInterceptor implements HttpInterceptor {

  constructor(private oAuthService:OAuthService) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    if (request.url.startsWith('http://localhost:8080')){
      return next.handle(request);
    }else{
      if(this.oAuthService.hasValidAccessToken()){
        const req = request.clone({headers:request.headers.append(
            'Authorization','Bearer '+this.oAuthService.getAccessToken()
          ).append('Access-Control-Allow-Origin','*').append('Access-Control-Allow-Headers','Content-Type')});
        return next.handle(req);
      }else{
        return next.handle(request);
      }
    }

  }
}
