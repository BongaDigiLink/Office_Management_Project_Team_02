import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Booking } from 'src/app/models/booking';
import { AdminService } from 'src/app/service/admin.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-meetings',
  templateUrl: './meetings.component.html',
  styleUrls: ['./meetings.component.css']
})
export class MeetingsComponent implements OnInit{

  constructor(
    private userService: UserService,
    private adminService: AdminService){}

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

       //Store user email in session storage or something
    this.userService.getMyBookings("bonga@gmail.com").subscribe(
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
    console.log("Form INputs")
    console.log(this.createMeetingForm.value)
  }

  //When user clicks submit button on the Update pop form.
  updateExistingMeeting()
  {
    console.log("Form Data")
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
