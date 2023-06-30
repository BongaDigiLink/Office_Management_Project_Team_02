import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Booking } from 'src/app/models/booking';
import { AdminService } from 'src/app/service/admin.service';
import { AuthService } from 'src/app/service/auth.service';
import { UserService } from 'src/app/service/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-meetings',
  templateUrl: './meetings.component.html',
  styleUrls: ['./meetings.component.css']
})
export class MeetingsComponent implements OnInit{

  constructor(
    private userService: UserService,
    private adminService: AdminService,
    private authService: AuthService){}

    //the current logged user meetings.
    //for my meetings display
  userMeetingBookings?: Booking[];

  //Bookings of all users for admin display
  allUserBookings?: Booking[];

  ngOnInit(): void {

    this.adminService.getBookings().subscribe(
       (userBookings_) => {
        this.allUserBookings = userBookings_
       })

       //current loggedIn user email is stored in an obj store in the auth service
    this.userService.getMyBookings(this.authService.getEmail()).subscribe(
       (myBookings) => {
      this.userMeetingBookings = myBookings;
    })

  }

  //Form to capture new meeting room booking
  createMeetingForm = new FormGroup(
    {
      date:new FormControl('', [Validators.required]),
      venue:new FormControl('', [Validators.required]),
      start_time: new FormControl('', [Validators.required]),
      end_time: new FormControl('', Validators.required)
    }
  )

  //parse createMeetingForm details to this method
  createAMeeting()
  {

    if(this.createMeetingForm.invalid){return;}

    this.userService.newBooking(this.createMeetingForm.value).subscribe( 
      {
        next: ()=> {
          Swal.fire({
          title: 'Venue booking recieved',
          icon:'success',
          text: 'Your asset log will be processed soon.',
          timer: 1500
        })
      },
        error: () => {
          Swal.fire({
            title: 'Venue booking was unsuccessful',
            icon:'error',
            timer: 1500
          })
        }
      }
    )
  }

  //-----------------------Admin Methods

  //When user clicks submit button on the Update pop form.
  updateExistingMeeting()
  {
    console.log("Update Form Data")
    console.log(this.createMeetingForm.value)
  }

  //Admin form for editing an existing booking.
  editMeetingForm = new FormGroup(
    {
      date: new FormControl('', [Validators.required]),
      venue: new FormControl('', [Validators.required]),
      time: new FormControl('', [Validators.required])
    }
  )

  //admin update/edits/cancels booking meeting
  editExistingMeeting()
  {

  }

}
