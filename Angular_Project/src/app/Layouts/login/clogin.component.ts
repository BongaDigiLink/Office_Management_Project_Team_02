import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/service/auth.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-clogin',
  templateUrl: './clogin.component.html',
  styleUrls: ['./clogin.component.css']
})
export class CloginComponent implements OnInit
{
  hide = true;
  constructor
  (
    private router: Router,
    private authService: AuthService,
    private formBuilder: FormBuilder
  ){}


  loginForm = this.formBuilder.group({
    email: this.formBuilder.control('', [Validators.email, Validators.required]),
    password: this.formBuilder.control('', [Validators.required, Validators.minLength(6)]),
  })

  ngOnInit(): void {}

  login(): void
  {
    if(!this.loginForm.valid)
    {
      return;
    }

/**
 * submit inputs, if user exists : user object returned from the Server 
 *       access user role (admin/user) and set Interface views by
 *      emitting value (0, 1 or 2) from the auth behaviour subject observable
 *      navigate user to the dashboard.
 * 
 * If user does not exist or password incorrect. Not handled yet. instead null is returned
 *    and display error pop up
 */
  this.authService.login(this.loginForm.value).subscribe(
    {
      next: (data) => 
      {
        if( data.role === "admin")
        {
          this.authService.userType$.next(1);
          Swal.fire({
            position: 'center',
            icon: 'success',
            title: 'You are logged in.',
            showConfirmButton: false,
            timer: 1600
          })
          this.router.navigateByUrl('/dashboard')
        }
        else if(data.role === "user")
        {
          this.authService.userType$.next(2);
          Swal.fire({
            position: 'center',
            icon: 'success',
            title: 'You are logged in.',
            showConfirmButton: false,
            timer: 1600
          })
          this.router.navigateByUrl('/dashboard')
        }
      },
      error: () => 
      {
        Swal.fire({
          position: 'center',
          icon: 'error',
          title: 'Oops!',
          showConfirmButton: false,
          timer: 1600
        })
      }

    });

  }
}
