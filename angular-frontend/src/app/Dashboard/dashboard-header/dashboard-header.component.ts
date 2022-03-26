import { Component, OnInit } from '@angular/core';
import {faBell, faCoffee} from "@fortawesome/free-solid-svg-icons";

@Component({
  selector: 'app-dashboard-header',
  templateUrl: './dashboard-header.component.html',
  styleUrls: ['./dashboard-header.component.css']
})
export class DashboardHeaderComponent implements OnInit {
  notification = faBell;
  constructor() { }

  ngOnInit(): void {
  }

}
