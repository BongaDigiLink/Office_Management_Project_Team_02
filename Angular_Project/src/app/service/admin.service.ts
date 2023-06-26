import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { Asset } from '../models/asset';
import { Observable } from 'rxjs';
import { Booking } from '../models/booking';

@Injectable({
  providedIn: 'root'
})
export class AdminService 
{

  constructor(private http: HttpClient) { }

  apiURL = 'http://localhost:8080/admin'

  /**
   * Admin Registering a user.
   * Service for adding new User,Post request
   */
  addUser(userDetails: User)
  {
    return this.http.post<User>(`${this.apiURL}/add-user`, userDetails);
  }

  /**
   * Admin user management
   * Service for updating user by email
   */
  updateUser(email:string, updateUser: User)
  {
    return this.http.put<User>(`${this.apiURL}/update-user/${email}`, updateUser);
  }

  getUsers(): Observable<User[]>
  {
    return this.http.get<User[]>(`${this.apiURL}/all-users`);
  }

  /**
   * Admin Asset management
   * Service for adding new asset
   */
  addAsset(assetDetails: Asset)
  {
    return this.http.post<User>(`${this.apiURL}/add-asset`, assetDetails);
  }

  /**
   * @param updatedAsset update asset by id
   * @returns 
   */
  updateAsset(id: number, updatedAsset: Asset)
  {
    return this.http.put<Asset>(`${this.apiURL}/update-asset/${id}`, updatedAsset)
  }

  getAssets(): Observable<Asset[]>
  {
    return this.http.get<Asset[]>(`${this.apiURL}/all-assets`);
  }


  /**
   * Admin routes to edit meetings/bookings
   * 
   */
  editBooking(id: number, editBooking: Booking)
  {
    return this.http.put<Booking>(`${this.apiURL}/edit-booking/${id}`, editBooking)
  }

  getBookings(): Observable<Booking[]>
  {
    return this.http.get<Booking[]>(`${this.apiURL}/all-bookings`);
  }

}
