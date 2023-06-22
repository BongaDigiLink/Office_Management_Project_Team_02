import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
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
