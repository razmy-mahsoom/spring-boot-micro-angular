import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {DashBoardComponent} from "./Dashboard/dash-board/dash-board.component";
import {OwnerProfileComponent} from "./Dashboard/owner-profile/owner-profile.component";
import {OwnerPropertiesComponent} from "./Dashboard/owner-properties/owner-properties.component";

const routes: Routes = [
  {path:'',component:DashBoardComponent,children:[
      {path:'profile',component:OwnerProfileComponent},
      {path:'properties',component:OwnerPropertiesComponent}
    ]},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
