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
        console.log("User Bookings")
        console.log(userBookings_)
        this.allUserBookings = userBookings_
       })

       //Store user email in session storage or something
    this.userService.getMyBookings(this.authService.getEmail()).subscribe(
       (myBookings) => 
       {
      this.userMeetingBookings = myBookings;
    })

  }

  //Form to capture new meeting room booking
  createMeetingForm = new FormGroup(
    {
      date:new FormControl('', [Validators.required]),
      room_name:new FormControl('', [Validators.required]),
      start_time: new FormControl('', [Validators.required]),
      end_time: new FormControl('', Validators.required),
      status: new FormControl('pending'),
    }
  )

  //parse createMeetingForm details to this method
  createAMeeting()
  {
    this.userService.newBooking(this.authService.getEmail(), this.createMeetingForm.value).subscribe( 
      {
        next: (return_status) => 
        {
          if(return_status != null)
          {
              Swal.fire({
              title: 'Your booking was created',
              icon: 'success',
              timer: 1500
            })
          }
          else if(return_status === null)
          {
              Swal.fire({
              title: 'An error occured on the server.',
              icon: 'error',
              text: 'Please try again later',
              timer: 5000
            })
          }
          else if(return_status === "reserved")
          {
            Swal.fire({
              title: 'this slot has been taken',
              icon:'error',
              text: 'Please choose a different time slot.',
              timer: 5000
            })
          }
        },
        error: () => {
          Swal.fire({
            title: 'We could not take your booking',
            icon:'error',
            text: 'Please try again later.',
            timer: 5000
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
