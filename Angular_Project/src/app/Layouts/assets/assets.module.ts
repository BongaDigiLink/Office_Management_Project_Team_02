import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AssetsRoutingModule } from './assets-routing.module';
import { AssetComponent } from './asset/asset.component';


@NgModule({
  declarations: [
    AssetComponent
  ],
  imports: [
    CommonModule,
    AssetsRoutingModule
  ]
})
export class AssetsModule { }
