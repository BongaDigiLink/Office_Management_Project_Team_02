import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
// import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CfooterComponent } from './Layouts/cfooter/cfooter.component';
import { CheaderComponent } from './Layouts/cheader/cheader.component';
import { ResetComponent } from './Layouts/user/reset/reset.component';
import { UserDashboardComponent } from './Layouts/user/user-dashboard/user-dashboard.component';
import { MainComponent } from './Layouts/main/main.component';
import { CloginComponent } from './Layouts/user/login/clogin.component';

@NgModule({
  declarations: [
    AppComponent,
    CfooterComponent,
    CheaderComponent,
    ResetComponent,
    UserDashboardComponent,
    MainComponent,
    CloginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
