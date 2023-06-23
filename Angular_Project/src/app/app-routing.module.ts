import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ResetComponent } from './Layouts/reset/reset.component';
import { CloginComponent } from './Layouts/login/clogin.component';
import { MeetingsComponent } from './Layouts/dashboard/meetings/meetings.component';
import { DigitalregisterComponent } from './Layouts/dashboard/digitalregister/digitalregister.component';
import { UserassetsComponent } from './Layouts/dashboard/userassets/userassets.component';

const routes: Routes = 
[
  {
    path:"reset", component:ResetComponent
  },
  {
    path:'login', component: CloginComponent
  },
  {
    path:'meetings', component: MeetingsComponent
  },
  {
    path: 'digitalregister', component: DigitalregisterComponent
  },
  {
    path: 'userasset', component: UserassetsComponent
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
