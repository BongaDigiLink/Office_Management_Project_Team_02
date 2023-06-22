import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CfooterComponent } from './Layouts/cfooter/cfooter.component';
import { CheaderComponent } from './Layouts/cheader/cheader.component';
import { UsersModule } from './Layouts/users/users.module';

@NgModule({
  declarations: [
    AppComponent,
    CfooterComponent,
    CheaderComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    UsersModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
