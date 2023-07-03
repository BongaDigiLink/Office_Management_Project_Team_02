import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
//import { LoginCredentials } from '../models/login';
import { User } from '../models/user';
import { BehaviorSubject, Observable, tap } from 'rxjs';
import { LoginCredentials } from '../models/login';


@Injectable({
  providedIn: 'root'
})
export class AuthService 
{
  constructor(private http: HttpClient) {}

  //Maintains login status of the user. Emitts (boolean) this value to all components.
  signedIn$ = new BehaviorSubject(false);

  //Maintains user type status. Emitts number.
  //0 - none, 1 - admin, 2 - Candidate/Staff
  userType$ = new BehaviorSubject(0);

  //User details of the current logged in user.
  user_!: User;

  //user id
  user_id !: number;

  getName(): string | undefined
  {
    return this.user_.firstName
  }

  getSurname(): string | undefined
  {
    return this.user_.lastName
  }

  getEmail(): string | undefined
  {
    return this.user_.email
  }

  // getId(): number | undefined
  // {
  //   return this.user_.;
  // }


  apiURL = 'http://localhost:8081/auth'

  /**
   * @param loginDetails - from input form and post to Server
   * @returns - User object if user exists and credentiasl are correct.
   * line 34 - 37 rns only if status 200 is returned. else block of code skipped.
   * therefore user not logged in.
   */
  login(loginDetails: LoginCredentials): Observable<User>
  {
    return this.http.post<User>(`${this.apiURL}/login`, loginDetails)
    .pipe(
      tap( (user) => 
      {
        this.signedIn$.next(true)
        this.user_ = user;
        console.log(user)
      } )
    )
  }

  //Change the status of the user. redirect to login page.
  logout()
  {
    return this.http.post<any>(`${this.apiURL}/logout`, {}).pipe(
      tap( () => {
        //Diasble user to false (exit app)
        this.signedIn$.next(false);
      } )
    )
  }


  /**
   * 
   * @param email Find user by email, reset pssw back to default
   * on the server
   */
  public resetPassword(email: string)
  {
    this.http.post<any>(`${this.http}/reset-user`, email)
  }


}
