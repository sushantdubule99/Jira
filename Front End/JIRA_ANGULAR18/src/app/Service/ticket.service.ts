import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Ticket } from '../Class/ticket';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TicketService {
  
   private baseUrl="http://localhost:8080/api/tickets"

  constructor(private http:HttpClient) { 

  }
  
  saveTicketByProjectId(projectId:number,ticket:Ticket):Observable<any>{
    return this.http.post(`${this.baseUrl}/${projectId}`,ticket)
  }

 
 
}
