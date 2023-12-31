import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Asset } from 'src/app/models/asset';
import { Booking } from 'src/app/models/booking';
import { RegisterRecord } from 'src/app/models/register';
import { AdminService } from 'src/app/service/admin.service';
import { AuthService } from 'src/app/service/auth.service';
import { UserService } from 'src/app/service/user.service';
import { LogAsset } from 'src/app/models/LogAsset';
import { DashBoardData } from 'src/app/models/DashBoardData';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {

  constructor(
    private service: AuthService, 
    private adminService: AdminService,
    private userService: UserService,
    private router: Router){}

  admin_interface : boolean = false;
  user_interface : boolean = false;

  //Admin and User arrays
  userBookings!: Booking[];
  userAssetLogs!: Asset[];
  availRooms!: Booking[]; //Query select only unbooked
  userRegister!: RegisterRecord[];

  meetingsCount?: number; //for adming and user
  registerCount?: number; //for admin and user
  usersCount?: number; //for admin
  
  dashBoardData !: DashBoardData;

  // User asset arrays
  allAssets!: Asset[]
  allUserBookings?: Booking[];
  log_requests?: LogAsset[];

  ngOnInit(): void 
  {
    this.service.userType$.subscribe( (value) => 
    {
      this.setInterfaces(value)
    })

    // ============================================
    this.adminService.getAllAssetLogs().subscribe( (assets) => {
      this.log_requests = assets;
    })

    //Get users log records
    this.userService.getMyEvents(this.service.getEmail()).subscribe( 
    {
      next: (records) => {
        this.log_requests = records;
      },
      error: () => {
        console.log("an error occured.")
      }
    } )
  }

  /**
   * @param value 
   */
  setInterfaces(value: number)
  {
    if(value === 1)
    {
      this.admin_interface = true;
      //Get a few records ( bookings, assets logs, user register etc. ) for admin Overview display.
      //- this.adminService.

      this.getAdminDashBoardData();
    }
    else if(value === 2)
    {
      this.user_interface = true;

      //Get minimal records ( bookings, register etc. )  about this user for Overview display.
      //- this.userService.
      this.getUserDashBoardData();
    }
    else
    {
      //do nothing.
      this.router.navigateByUrl('login');
    }
  }

  getUserDashBoardData()
  {
    this.userService.getDashBoardData(this.service.getEmail()).subscribe( 
      (data) => {
        this.dashBoardData = data;
        this.meetingsCount = data.meetingsCount;
        this.registerCount = data.registerCount;
      })
  }

  getAdminDashBoardData()
  {
    this.adminService.getDashBoardData().subscribe( 
      (data) => {
        this.dashBoardData = data;
        this.meetingsCount = data.meetingsCount;
        this.registerCount = data.registerCount;
        this.usersCount = data.userCount;
      } )
  }

}
