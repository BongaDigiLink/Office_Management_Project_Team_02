import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ResetComponent } from './Layouts/reset/reset.component';
import { CloginComponent } from './Layouts/login/clogin.component';

const routes: Routes = 
[
  {
    path:"reset", component:ResetComponent
  },
  {
    path:'login', component: CloginComponent
  },
  {
    path:'', component:CloginComponent
  },
  /**After logging in user is directed to dashboard path (dashboard module)
   * The Dashboard Module has the following paths
   * Admin:
    *   localhost:4200/dashboard/bookings
    *   localhost:4200/dashboard/assets
    *   localhost:4200/dashboard/users
    *   localhost:4200/dashboard/inventory
    *   localhost:4200/dashboard/meetings
    * 
    * User/Candidate: Not Completed Yet
    *   localhost:4200/dashboard        - default home, display summary of available functions (1,2,3)
    *   localhost:4200/dashboard/---
    *   localhost:4200/dashboard/---
    *   localhost:4200/dashboard/---
    *   localhost;4200/dashboard/profile
    * 
    *   To add other components and their routes
    *   add the components on : declarations  (file: dashboard.module.ts)
    *   Check the file: dashboard-routing.module.ts 
    *   and edit.
   * **/
  {
    path:'dashboard', loadChildren: () => 
    import('./Layouts/dashboard/dashboard.module').then( m => m.DashboardModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
