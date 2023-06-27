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

  all_users!: User[];

  ngOnInit(): void {
    this.service.getUsers().subscribe((all_users) => 
    {
      //View a list of users:
      console.log("All users")
      console.log(all_users);
      all_users = all_users;
    } )
  }

}
