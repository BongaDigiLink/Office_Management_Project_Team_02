import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { Asset } from '../models/asset';
import { Booking } from '../models/booking';
import { Observable } from 'rxjs';
import { RegisterRecord } from '../models/register';

@Injectable({
  providedIn: 'root'
})

export class UserService 
{
  constructor(private http: HttpClient) { }

  apiURL = 'http://localhost:8080/user'

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
  assetRegister(assetDetails: Asset)
  {
    return this.http.post<Asset>(`${this.apiURL}/asset-register`, assetDetails);
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

  requestFood(email: string)
  {
    this.http.get<any>(`${this.apiURL}/request-food/${email}`)
  }


  /**
   * user routes, my meetings/bookings
   */
  editBooking(id: number, editBooking: Booking)
  {
    return this.http.put<Booking>(`${this.apiURL}/edit-booking/${id}`, editBooking)
  }

  /**
   * @returns list of my bookings
   */
  getMyBookings(email: string): Observable<Booking[]>
  {
    return this.http.get<Booking[]>(`${this.apiURL}/my-bookings/${email}`);
  }


}
