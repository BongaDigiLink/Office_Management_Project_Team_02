import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { RegisterRecord } from 'src/app/models/register';
import { AdminService } from 'src/app/service/admin.service';
import { AuthService } from 'src/app/service/auth.service';
import { UserService } from 'src/app/service/user.service';
import { RoomBookingInputComponent } from '../dialog/room-booking-input/room-booking-input.component';
import { FormControl, FormGroup, Validators } from '@angular/forms';

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
      signInTime: new FormControl(''),
      signOutTime: new FormControl(''),
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
        this.userService.myRegister("email@mail.com").subscribe(
           (my_record) => {
          this.myEvents = my_record
        } )
      }
    })
  }

  signRegister()
  {
    console.log("Register inputs")
    console.log(this.eventForm.value)
  }


}
