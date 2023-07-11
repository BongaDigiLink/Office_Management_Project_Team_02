import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { AuthService } from 'src/app/service/auth.service';
import { UserService } from 'src/app/service/user.service';
import { AdminService } from 'src/app/service/admin.service';
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
    private service: AdminService,
    private update: MatDialogRef <UpdateuserComponent>){}

    updateMeetingForm = this.formBuilder.group({
      room_name : this.formBuilder.control('', [Validators.required]),
      date_ : this.formBuilder.control('', [Validators.required]),
      start_time : this.formBuilder.control('', [Validators.required]),
      end_time : this.formBuilder.control('', [Validators.required])
    })

      //updatemeeting method
      //TODO
    updateMeeting() {
      if (this.updateMeetingForm.valid) {
          alert('Updated successfully.');
          this.updateMeetingForm.reset();
          this.update.close();
        } else {
              alert('Update unsuccessful');
    }
  }

}
