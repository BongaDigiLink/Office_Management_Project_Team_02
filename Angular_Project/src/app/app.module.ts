import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CfooterComponent } from './Layouts/cfooter/cfooter.component';
import { CheaderComponent } from './Layouts/cheader/cheader.component';
import { UsersModule } from './Layouts/users/users.module';
import { ResetComponent } from './Layouts/user/reset/reset.component';
import { CloginComponent } from './Layouts/user/login/clogin.component';
import { UserDashboardComponent } from './Layouts/user/user-dashboard/user-dashboard.component';

@NgModule({
  declarations: [
    AppComponent,
    CfooterComponent,
    CheaderComponent,
    ResetComponent,
    UserDashboardComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    UsersModule,
    RouterModule.forRoot([
      {path:'login', component:CloginComponent}
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
