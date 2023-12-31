import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { Asset } from '../models/asset';
import { Booking, dtoBooking } from '../models/booking';
import { Observable } from 'rxjs';
import { RegisterRecord, dtoRegisterRecord } from '../models/register';
import { LogAsset, logdtoAsset } from '../models/LogAsset';
import { DashBoardData } from '../models/DashBoardData';

@Injectable({
  providedIn: 'root'
})

export class UserService 
{
  constructor(private http: HttpClient) { }

  apiURL = 'http://localhost:8081/v1'

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
  assetRegister(email: string | undefined, logDetails: logdtoAsset)
  {
    return this.http.post<LogAsset>(`${this.apiURL}/asset-register/${email}`, logDetails);
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
  myRegister(email: string | undefined): Observable<RegisterRecord[]>
  {
    return this.http.get<RegisterRecord[]>(`${this.apiURL}/my-register/${email}`)
  }

  //User creates event// Register (in or out)
  createEvent(email: string | undefined, registerRecord: dtoRegisterRecord)
  {
    return this.http.post<any>(`${this.apiURL}/sign-register/${email}`, registerRecord)
  }

  requestFood(email: string)
  {
    this.http.get<any>(`${this.apiURL}/request-food/${email}`)
  }

  getMyEvents(email: string | undefined): Observable<LogAsset[]>
  {
    return this.http.get<LogAsset[]>(`${this.apiURL}/get-my-asset-log/${email}`)
  }
  


  /**
   * user routes, my meetings/bookings
   */
  newBooking(email: string | undefined, newBooking: dtoBooking)
  {
    return this.http.post<any>(`${this.apiURL}/user/create-facility-request/${email}`, newBooking);
  }

  editBooking(id: number, editBooking: Booking)
  {
    return this.http.put<Booking>(`${this.apiURL}/edit-booking/${id}`, editBooking)
  }

  getDashBoardData(email: string | undefined): Observable<DashBoardData>
  {
    return this.http.get<DashBoardData>(`${this.apiURL}/get-dashboard-data/${email}`);
  }

  /**
   * @returns list of my bookings
   */
  getMyBookings(email: string | undefined): Observable<Booking[]>
  {
    return this.http.get<Booking[]>(`${this.apiURL}/user/user-facility-requests/${email}`);
  }


}
