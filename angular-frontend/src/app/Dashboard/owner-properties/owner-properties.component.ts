import { Component, OnInit } from '@angular/core';
import {faBan, faCircleCheck, faCircleExclamation, faCoffee} from "@fortawesome/free-solid-svg-icons";

@Component({
  selector: 'app-owner-properties',
  templateUrl: './owner-properties.component.html',
  styleUrls: ['./owner-properties.component.css']
})
export class OwnerPropertiesComponent implements OnInit {
  check = faCircleCheck;
  reject = faBan;
  pending = faCircleExclamation;

  constructor() { }

  ngOnInit(): void {
  }

}
