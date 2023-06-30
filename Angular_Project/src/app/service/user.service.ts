import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { Asset } from '../models/asset';
import { Booking, dtoBooking } from '../models/booking';
import { Observable } from 'rxjs';
import { RegisterRecord, dtoRegisterRecord } from '../models/register';
import { logdtoAsset } from '../models/LogAsset';

@Injectable({
  providedIn: 'root'
})

export class UserService 
{
  constructor(private http: HttpClient) { }

  apiURL = 'http://localhost:8081/user'

  /**
   * User updates details.
   */
  updateDetails(email: string, userDetails: User)
  {
    return this.http.put<User>(`${this.apiURL}/update-profile/${email}`, userDetails);
  }


  /**
   * Asset Register
   */
  assetRegister(logDetails: logdtoAsset)
  {
    return this.http.post<any>(`${this.apiURL}/asset-register`, logDetails);
  }

  /**
   * @param updatedAsset update asset by id
   * @returns 
   */
  updateAsset(id: number, updatedAsset: Asset)
  {
    return this.http.put<Asset>(`${this.apiURL}/update-asset/${id}`, updatedAsset)
  }

  /**
   * @param email - user email
   * @returns - record of my register attendance
   */
  myRegister(email: string): Observable<RegisterRecord[]>
  {
    return this.http.get<RegisterRecord[]>(`${this.apiURL}/my-register/${email}`)
  }

  //User creates event// Register (in or out)
  createEvent(event_type: string, registerRecord: dtoRegisterRecord)
  {
    return this.http.post<any>(`${this.apiURL}/record-register/`, registerRecord)
  }

  requestFood(email: string)
  {
    this.http.get<any>(`${this.apiURL}/request-food/${email}`)
  }
  


  /**
   * user routes, my meetings/bookings
   */
  newBooking(newBooking: dtoBooking)
  {
    return this.http.post<any>(`${this.apiURL}/create-booking/`, newBooking);
  }

  editBooking(id: number, editBooking: Booking)
  {
    return this.http.put<Booking>(`${this.apiURL}/edit-booking/${id}`, editBooking)
  }

  /**
   * @returns list of my bookings
   */
  getMyBookings(email: string | null): Observable<Booking[]>
  {
    return this.http.get<Booking[]>(`${this.apiURL}/my-bookings/${email}`);
  }


}
