import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http:HttpClient) {



   }

   apiurl='http://localhost:3000/user';

   GetUserbyCode(id:any){
    return this.http.get(this.apiurl+'/'+id);


  }
}
