import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Login } from '../Class/login';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private baseUrl="http://localhost:8080/api/login "

  constructor(private http:HttpClient) {

   }

   createLogin( login:Login):Observable<Login>{
    return this.http.post<Login>(`${this.baseUrl}`,login)
   }
}
