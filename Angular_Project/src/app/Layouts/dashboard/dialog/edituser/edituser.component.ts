import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { AuthService } from 'src/app/service/auth.service';
import { UserService } from 'src/app/service/user.service';
import { AdminService } from 'src/app/service/admin.service';
import { User } from 'src/app/models/user';
import { UserComponent } from '../../users/user.component';

@Component({
  selector: 'app-edituser',
  templateUrl: './edituser.component.html',
  styleUrls: ['./edituser.component.css']
})
export class EdituserComponent {
  constructor(
private edit: MatDialogRef<EdituserComponent>,
private formBuilder: FormBuilder,
private service: AdminService){}

editdata: any;

editUserForm = this.formBuilder.group({
  email : this.formBuilder.control('', [Validators.required]),
  first_name : this.formBuilder.control('', [Validators.required]),
  last_name : this.formBuilder.control('', [Validators.required]),
  username : this.formBuilder.control('', [Validators.required]),
  role : this.formBuilder.control('', [Validators.required]),
  address : this.formBuilder.control('',[Validators.required])
})


loaduserdata(code: string, user : User) {
  this.service.updateUser(code,user).subscribe(res => {
    this.editdata = res;
    console.log(this.editdata);
    this.editUserForm.setValue({
      email: this.editdata.email, first_name: this.editdata.first_name,last_name: this.editdata.last_name,username:this.editdata.username,
      role: this.editdata.role,address:this.editdata.address
    });
  });
}


// editUser(code:any) {
//   this.service.edituser(this.editform.value.id, this.editform.value).subscribe(res => {
//     this.toastr.success('Updated successfully.');
//     this.dialogref.close();
//   });
// }

  updateUser(){

  }
}
