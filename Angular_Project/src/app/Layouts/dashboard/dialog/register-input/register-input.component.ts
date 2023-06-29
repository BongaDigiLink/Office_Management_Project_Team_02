import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-register-input',
  templateUrl: './register-input.component.html',
  styleUrls: ['./register-input.component.css']
})
export class RegisterInputComponent {

  constructor(
    private service: UserService,
    private formBuilder: FormBuilder
  ){}

  registerForm = this.formBuilder.group({
    message_early_late : this.formBuilder.control('Reason for late coming, Early sign out.'),
    time_ : Date.now(),
    date_ : Date.now()
  })

  signInRegister()
  {
    this.service.createEvent("sign-in", this.registerForm.value).subscribe( () => {

    })
  }

  signOutRegister()
  {
    this.service.createEvent("sign-out", this.registerForm.value).subscribe( () => {
      
    } )
  }

}
