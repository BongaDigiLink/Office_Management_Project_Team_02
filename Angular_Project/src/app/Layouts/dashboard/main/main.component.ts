import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/service/auth.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit
{
  constructor(private service: AuthService){}

  admin_interface : boolean = false;
  user_interface : boolean = false;

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

}
