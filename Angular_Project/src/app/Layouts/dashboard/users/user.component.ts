import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { AdminService } from 'src/app/service/admin.service';
import {MatDialog, MAT_DIALOG_DATA, MatDialogModule} from '@angular/material/dialog';
import { DialogComponent } from '../dialog/dialog.component';
import { EdituserComponent } from '../dialog/edituser/edituser.component';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})

export class UserComponent implements OnInit{

  constructor(
    private service: AdminService,
     private dialog: MatDialog,
     private edit : MatDialog)
  {}

  all_users?: User[];


  ngOnInit(): void {
    this.service.getUsers().subscribe(
      (users) => 
    {
      //View a list of users:
      this.all_users = users;
      console.log(this.all_users)
    } )
  }
// open adding user
  openDialog() {
    this.dialog.open(DialogComponent, {
      width: '50%',
      height: '',
      position: {
        top: '30vh',
        left: '30vw'
    }
    });
  }
// edit user
editDialog(){
  this.edit.open(EdituserComponent,{
    width: '50%',
    height: '',
    position: {
      top: '30vh',
      left: '30vw'
    }
  })
}
//deactivation function

}
