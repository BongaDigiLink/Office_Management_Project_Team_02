import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User, dtoUser } from '../models/user';
import { Asset } from '../models/asset';
import { Observable } from 'rxjs';
import { Booking } from '../models/booking';
import { RegisterRecord } from '../models/register';
import { LogAsset, logdtoAsset } from '../models/LogAsset';
import { updateBooking } from '../models/updateBooking';

@Injectable({
  providedIn: 'root'
})
export class AdminService 
{

  constructor(private http: HttpClient) { }


  apiURL = 'http://localhost:8081/v1'

  /**
   * Admin Registering a user.
   * Service for adding new User,Post request
   */
  addUser(userDetails: dtoUser)
  {
    return this.http.post<dtoUser>(`${this.apiURL}/add-user`, userDetails);
  }

  //Register of all users
  usersRegistration()
  {
    this.http.get<RegisterRecord[]>(`${this.apiURL}/all-users-registration`);
  }

  /**
   * Admin user management
   * Service for updating user by email
   */
  updateUser(email:string | null, updateUser: dtoUser)
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

  
  getAllAssetLogs()
  {
    return this.http.get<logdtoAsset[]>(`${this.apiURL}/get-all-asset-log`)
  }
  

  acceptAssetLog(admin: number | undefined)
  {
    return this.http.put<any>(`${this.apiURL}/approve-log/${admin}`,admin);
  }

  disapproveAssetLog(admin: number|undefined)
  {
    
    return this.http.put<any>(`${this.apiURL}/disapprove-log/${admin}`, admin);
  }


  /**
   * Admin routes to edit meetings/bookings
   * 
   */
  editBooking(editBooking: updateBooking)
  {
    return this.http.put<any>(`${this.apiURL}/update-facility-request/`, editBooking)
  }

  getBookings(): Observable<Booking[]>
  {
    return this.http.get<Booking[]>(`${this.apiURL}/user/get-all-facility-requests`);
  }

}
