import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { AdminService } from 'src/app/service/admin.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})

export class UserComponent implements OnInit{

  constructor(private service: AdminService)
  {}

  all_users?: User[];

  ngOnInit(): void {
    this.service.getUsers().subscribe(
      (users) => 
    {
      //View a list of users:
      this.all_users = users;
      console.log(this.all_users)
    } 
    )
  }

}
