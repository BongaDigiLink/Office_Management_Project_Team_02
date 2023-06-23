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
    path:'dashboard', loadChildren: () => 
    import('./Layouts/dashboard/dashboard.module').then( m => m.DashboardModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
