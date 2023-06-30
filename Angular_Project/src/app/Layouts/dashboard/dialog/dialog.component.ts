import { Component } from '@angular/core';
import { FormGroup,FormBuilder, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { AdminService } from 'src/app/service/admin.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.css']
})
export class DialogComponent {

  constructor(private service: AdminService,
    private formBuilder: FormBuilder,
    private dialog: MatDialogRef<DialogComponent>){}

  updateUserForm !: FormGroup;
  //Captures update user details from the Pop up form.
  //details are parsed to the update.service on the updateUser method

  addUserForm = this.formBuilder.group({
    email: this.formBuilder.control('', [Validators.email, Validators.required]),
    firstName: this.formBuilder.control('', [Validators.required]),
    lastName: this.formBuilder.control('', [Validators.required]),
    username: this.formBuilder.control('', [Validators.required]),
    department: this.formBuilder.control('', [Validators.required]),
    position: this.formBuilder.control('', [Validators.required])
  })

  
//you must know your types
  updateUser(): any
  {
    console.log(this.addUserForm.value);

    if(this.addUserForm.invalid)
    {
      return;
    }

    this.service.addUser(this.addUserForm.value).subscribe(
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
