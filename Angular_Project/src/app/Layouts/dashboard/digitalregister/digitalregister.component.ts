import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { RegisterRecord } from 'src/app/models/register';
import { AdminService } from 'src/app/service/admin.service';
import { AuthService } from 'src/app/service/auth.service';
import { UserService } from 'src/app/service/user.service';
import { RoomBookingInputComponent } from '../dialog/update-user/update-user';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-digitalregister',
  templateUrl: './digitalregister.component.html',
  styleUrls: ['./digitalregister.component.css']
})
export class DigitalregisterComponent implements OnInit{

  constructor(
    private adminService: AdminService,
    private userService: UserService,
    private authService: AuthService){}

    //Current user event record
    myEvents!: RegisterRecord[]

    //All sign-in or out event
    allEvents!: RegisterRecord[]

    eventForm = new FormGroup({
      event_type: new FormControl('', [Validators.required]),
      signInTime: new FormControl(Date.now()),
      signOutTime: new FormControl(Date.now()),
      event_message: new FormControl('')
    })

  ngOnInit(): void 
  {
    this.authService.userType$.subscribe( (value) => 
    {
      if( value ===1 )
      {
        //this.adminService.
      }
      else if( value == 2)
      {
        this.userService.myRegister(this.authService.getEmail()).subscribe(
           (my_record) => {
          this.myEvents = my_record
        } )
      }
    })
  }

  signIn()
  {
    this.eventForm.value.signInTime = Date.now();
    console.log("Register inputs")
    console.log(this.eventForm.value)

    this.userService.createEvent(this.eventForm.value).subscribe( 
      {
        next: () => {
          Swal.fire(
            {
            position: 'center',
            icon: 'success',
            title: 'Signed In',
            showConfirmButton: false,
            timer: 1600
            }
          )
        },
        error: () => {
          Swal.fire(
            {
            position: 'center',
            icon: 'error',
            title: 'Not Signed-In',
            showConfirmButton: false,
            timer: 1600
            }
          )
        }
       })
  }

  signOut()
  {

    this.userService.createEvent(this.eventForm.value).subscribe( 
      {
        next: () => {
          Swal.fire(
            {
            position: 'center',
            icon: 'success',
            title: 'Signed-Out',
            showConfirmButton: false,
            timer: 1600
            }
          )
        },
        error: () => {
          Swal.fire({
            position: 'center',
            icon: 'error',
            title: 'Not Signed-Out',
            showConfirmButton: false,
            timer: 1600
          })

        }
       })
  }


}
