import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { User } from 'src/app/models/user';
import { AdminService } from 'src/app/service/admin.service';
import {MatDialog, MAT_DIALOG_DATA, MatDialogModule} from '@angular/material/dialog';
import { DialogComponent } from '../dialog/dialog.component';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})

export class UserComponent implements OnInit{

  constructor(private service: AdminService, private dialog: MatDialog)
  {}

  all_users?: User[];

  //Captures update user details from the Pop up form.
  //details are parsed to the update.service on the updateUser method
  updateUserForm = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    firstName: new FormControl('', [Validators.required]),
    lastName: new FormControl('', [Validators.required]),
    department: new FormControl('', [Validators.required])

  })

  ngOnInit(): void {
    this.service.getUsers().subscribe(
      (users) => 
    {
      //View a list of users:
      this.all_users = users;
      console.log(this.all_users)
    } )
  }

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
    modal.style.display = 'none'}
  updateUser(): void
  {
    if(this.updateUserForm.invalid)
    {
      return;
    }

    this.service.updateUser(this.updateUserForm.controls['email'].value, this.updateUserForm.value).subscribe(
       () => {
        Swal.fire({
          position: 'center',
            icon: 'success',
            title: 'User Updated!',
            showConfirmButton: false,
            timer: 1400
        })
    })
  }

}
