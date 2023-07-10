import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { AuthService } from 'src/app/service/auth.service';
import { UserService } from 'src/app/service/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-updateuser',
  templateUrl: './updateuser.component.html',
  styleUrls: ['./updateuser.component.css']
})
export class UpdateuserComponent {
  constructor(private userService: UserService,
    private authService: AuthService,
    private formBuilder: FormBuilder,
    private update: MatDialogRef <UpdateuserComponent>){}

    roomBookingForm = this.formBuilder.group({
      room_name : this.formBuilder.control('', [Validators.required]),
      date_ : this.formBuilder.control('', [Validators.required]),
      start_time : this.formBuilder.control('', [Validators.required]),
      end_time : this.formBuilder.control('', [Validators.required]),
    })
}
