import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {

  constructor(private service: AuthService){}

  admin_interface : boolean = false;
  user_interface : boolean = false;

  ngOnInit(): void 
  {
    this.service.userType$.subscribe( (value) => 
    {
      this.setInterfaces(value)
    })
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
