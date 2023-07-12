import { Component, OnInit } from '@angular/core';
import { DashBoardData } from 'src/app/models/DashBoardData';
import { AdminService } from 'src/app/service/admin.service';
import { AuthService } from 'src/app/service/auth.service';
import { UserService } from 'src/app/service/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit
{
  constructor(private service: AuthService,
    private userService: UserService,
    private adminService: AdminService){}

  admin_interface : boolean = false;
  user_interface : boolean = false;

  meetingsCount?: number;
  registerCount?: number;
  usersCount?: number;
  
  dashBoardData !: DashBoardData;

  userName!: string | undefined;

  ngOnInit(): void 
  {
    this.service.userType$.subscribe( (value) => 
    {
      this.setInterfaces(value)
    })

     this.userName = this.service.getName();
  }

  /**
   * @param value 
   */
  setInterfaces(value: number)
  {
    if(value === 1)
    {
      this.admin_interface = true;
    }
    else if(value === 2)
    {
      this.user_interface = true;
    }
    else
    {
      //do nothing.
      this.user_interface = true;
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
      } )
  }

}
