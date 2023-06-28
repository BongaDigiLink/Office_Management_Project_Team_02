import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { AdminService } from 'src/app/service/admin.service';
import {MatDialog, MAT_DIALOG_DATA, MatDialogModule} from '@angular/material/dialog';
import { DialogComponent } from '../dialog/dialog.component';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})

export class UserComponent implements OnInit{

  constructor(private service: AdminService, private dialog: MatDialog)
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

  openDialog() {
    this.dialog.open(DialogComponent, {
      width: '50%',
      height: '',
      position: {
        top: '-40vh',
        left: '30vw'
    }
    });
  }

  OpenModal(): void {
    const overlay = document.getElementById('popup1')!
    overlay.style.display = 'block'
    const modal = document.getElementById('modal')!
    modal.style.display = 'block'
  }

  CloseModal(): void {
    const overlay = document.getElementById('popup1')!
    overlay.style.display = 'none'
    const modal = document.getElementById('modal')!
    modal.style.display = 'none'
  }

}
