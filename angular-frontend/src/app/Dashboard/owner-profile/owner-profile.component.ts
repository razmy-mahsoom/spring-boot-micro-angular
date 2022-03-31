import { Component, OnInit } from '@angular/core';
import {OwnerProfileService} from "../Service/owner-profile.service";
import {Owner} from "../Models/owner";
import {catchError, Observable, Subscription, throwError} from "rxjs";

@Component({
  selector: 'app-owner-profile',
  templateUrl: './owner-profile.component.html',
  styleUrls: ['./owner-profile.component.css']
})
export class OwnerProfileComponent implements OnInit {
  owner$:Observable<Owner> = new Observable<Owner>();
  constructor(private profileService:OwnerProfileService) {}

  ngOnInit(): void {

      this.owner$ = this.profileService.fetchOwnerByAuthentication()
  }

}
