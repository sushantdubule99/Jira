import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../Class/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  
   private baseUrl="http://localhost:8080/api/user "
  
   constructor(private http:HttpClient) { }

      getUsers():Observable<User[]>{
        return this.http.get<User[]>(`${this.baseUrl}`)
      }

      saveUser(user:User):Observable<User>{
        return this.http.post<User>(`${this.baseUrl}`,user)
      }
}
