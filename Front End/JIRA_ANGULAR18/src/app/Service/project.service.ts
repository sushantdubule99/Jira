import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Project } from '../Class/project';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {
 
  private baseUrl="http://localhost:8080/api/projects "

  constructor(private http:HttpClient) { }


   getProjects():Observable<Project[]>{
    return this.http.get<Project[]>(`${this.baseUrl}`)
   }

   createProject(project:Project):Observable<Project>{
    return this.http.post<Project>(`${this.baseUrl}`,project)
   }
}
