import { Component } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-clogin',
  templateUrl: './clogin.component.html',
  styleUrls: ['./clogin.component.css']
})
export class CloginComponent
{

  constructor(
    private fb: FormBuilder,
    private router: Router,
    // private service: AuthService
  )
  {}

  form = this.fb.group({
    email: ['', Validators.required],
    password: ['', Validators.required]
  })

  initForm(): FormGroup
  {
    let form =  this.fb.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
    })

  return form
}

result: any;
  // public login()
  // {

  //   if (this.form.valid) {
  //     this.service.GetUserbyCode(this.form.value.email).subscribe(item => {
  //       this.result = item;
  //       if (this.result.password === this.form.value.password) {
  //         if (this.result.isactive) {
  //           sessionStorage.setItem('username',this.result.id);
  //           sessionStorage.setItem('role',this.result.role);
  //           this.router.navigate(['']);
  //         } else {
  //           console.log('Please contact Admin', 'InActive User');
  //         }
  //       } else {
  //         console.log('Invalid credentials');
  //       }
  //     });
  //   } else {
  //     console.log('Please enter valid data.')
  //   }
  //   this.router.navigateByUrl('/dashboard')
  // }
}

/*
result: any;

loginform = this.builder.group({
  id: this.builder.control('', Validators.required),
  password: this.builder.control('', Validators.required)
});

proceedlogin() {
  if (this.loginform.valid) {
    this.service.GetUserbyCode(this.loginform.value.id).subscribe(item => {
      this.result = item;
      if (this.result.password === this.loginform.value.password) {
        if (this.result.isactive) {
          sessionStorage.setItem('username',this.result.id);
          sessionStorage.setItem('role',this.result.role);
          this.router.navigate(['']);
        } else {
          this.toastr.error('Please contact Admin', 'InActive User');
        }
      } else {
        this.toastr.error('Invalid credentials');
      }
    });
  } else {
    this.toastr.warning('Please enter valid data.')
  }
}
*/
