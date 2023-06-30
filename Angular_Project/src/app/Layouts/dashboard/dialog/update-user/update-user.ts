import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { UserService } from 'src/app/service/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-room-booking-input',
  templateUrl: './update-user.html',
  styleUrls: ['./update-user.css']
})
export class RoomBookingInputComponent {

  constructor(private userService: UserService,
    private formBuilder: FormBuilder){}

    roomBookingForm = this.formBuilder.group({
      room_name : this.formBuilder.control('', [Validators.required]),
      date_ : this.formBuilder.control('', [Validators.required]),
      start_time : this.formBuilder.control('', [Validators.required]),
      end_time : this.formBuilder.control('', [Validators.required]),
    })


    createRoomBooking(): any
    {
      this.userService.newBooking(this.roomBookingForm.value).subscribe(
      {
        next: () => 
        {
        Swal.fire({
          title: 'Auto close alert!',
          text: 'Meeting room booked',
          timer: 1500
        })
      },
      error: () => 
      {
        Swal.fire({
          position: 'center',
          icon: 'error',
          title: 'Couldnot reserve a booking for you!',
          showConfirmButton: false,
          timer: 1600
        })
      }
      })
    }

}
