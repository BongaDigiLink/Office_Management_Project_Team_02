import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/service/admin.service';

@Component({
  selector: 'app-stock',
  templateUrl: './stock.component.html',
  styleUrls: ['./stock.component.css']
})
export class StockComponent implements OnInit {

  constructor(private adminService: AdminService){}

  totalNoodles!: number;
  totalOats!: number;

  ngOnInit(): void {
    //Get total count of all Noodles and Oats.

    
    //
    // this.totalNoodles = ret_1
    // this.totalOats = ret_2
  }
}
