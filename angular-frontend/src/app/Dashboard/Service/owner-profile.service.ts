import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Owner} from "../Models/owner";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class OwnerProfileService {

  baseUrl:string = "http://localhost:8083/api/v1/owner/";
  constructor(private http:HttpClient) { }

  fetchOwnerByAuthentication():Observable<Owner>{
    return this.http.get<Owner>(this.baseUrl+'authentication')
  }
}
