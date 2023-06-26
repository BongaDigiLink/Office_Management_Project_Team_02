import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
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

  ngOnInit(): void {
    //console.log(this.loginloginForm.value);
  }

  login(): void
  {
    console.log(this.loginForm.value)

    if(!this.loginForm.valid)
    {
      return;
    }

    this.authService.login(this.loginForm.value).subscribe( () => {
      
    })
  }


}
