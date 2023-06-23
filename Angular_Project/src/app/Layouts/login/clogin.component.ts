import { Component } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-clogin',
  templateUrl: './clogin.component.html',
  styleUrls: ['./clogin.component.css']
})
export class CloginComponent 
{

  constructor(
    private fb: FormBuilder,
    private router: Router
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


  public login()
  {
    this.router.navigateByUrl('/dashboard')
  }
}
