import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ResetComponent } from './Layouts/user/reset/reset.component';
import { CloginComponent } from './Layouts/user/login/clogin.component';

const routes: Routes = 
[
  {
    path:"reset", component:ResetComponent
  },
  {
    path:'login', component: CloginComponent
  },
  {
    path:'home',
    loadChildren: () => import('./Layouts/home/home.module').then(m => m.HomeModule)
  },
  {
    path:'users',
    loadChildren: () => 
    import('./Layouts/users/users.module').then(m => m.UsersModule)
  },
  {
    path:'meetings',
    loadChildren:() => 
    import('./Layouts/bookings/bookings.module').then(m => m.BookingsModule)
  },
  {
    path:'inventory',
    loadChildren: () => 
    import('./Layouts/inventory/inventory.module').then(m => m.InventoryModule)
  },
  {
    path:'assets',
    loadChildren: () => 
    import('./Layouts/assets/assets.module').then(m => m.AssetsModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
