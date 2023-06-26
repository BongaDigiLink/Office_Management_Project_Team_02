import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-clogin',
  templateUrl: './clogin.component.html',
  styleUrls: ['./clogin.component.css']
})
export class CloginComponent implements OnInit
{

  constructor
  (
    private router: Router,
    private authService: AuthService
  ){}

  loginForm = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [Validators.required, Validators.minLength(6)])
  })

  ngOnInit(): void {}

  login(): void
  {

    if(!this.loginForm.valid)
    {
      return;
    }

    this.authService.login(this.loginForm.value).subscribe( (data: User) => 
    {
      console.log(data)
      if( data.role === "admin")
      {
        this.authService.userType$.next(1);
        this.router.navigateByUrl('/dashboard')
      }
      else if(data.role === "user")
      {
        this.authService.userType$.next(2);
        this.router.navigateByUrl('/dashboard')
      }
    })
  }


}
