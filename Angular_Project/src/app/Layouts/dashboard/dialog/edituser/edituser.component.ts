import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { AuthService } from 'src/app/service/auth.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-edituser',
  templateUrl: './edituser.component.html',
  styleUrls: ['./edituser.component.css']
})
export class EdituserComponent {
  constructor(
private edit: MatDialogRef<EdituserComponent>,
private formBuilder: FormBuilder){}


editUserForm = this.formBuilder.group({
  email : this.formBuilder.control('', [Validators.required]),
  first_name : this.formBuilder.control('', [Validators.required]),
  last_name : this.formBuilder.control('', [Validators.required]),
  username : this.formBuilder.control('', [Validators.required]),
  role : this.formBuilder.control('', [Validators.required]),
  address : this.formBuilder.control('',[Validators.required])
})
}
