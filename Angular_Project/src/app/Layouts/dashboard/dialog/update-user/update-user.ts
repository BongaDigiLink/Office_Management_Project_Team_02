import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { AuthService } from 'src/app/service/auth.service';
import { UserService } from 'src/app/service/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-room-booking-input',
  templateUrl: './update-user.html',
  styleUrls: ['./update-user.css']
})
export class RoomBookingInputComponent {

  constructor(private userService: UserService,
    private authService: AuthService,
    private formBuilder: FormBuilder){}

    roomBookingForm = this.formBuilder.group({
      room_name : this.formBuilder.control('', [Validators.required]),
      date_ : this.formBuilder.control('', [Validators.required]),
      start_time : this.formBuilder.control('', [Validators.required]),
      end_time : this.formBuilder.control('', [Validators.required]),
    })


}
