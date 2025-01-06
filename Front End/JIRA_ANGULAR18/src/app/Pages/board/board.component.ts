import { Component, inject } from '@angular/core';
import { MasterService } from '../../Service/master.service';
import { TicketService } from '../../Service/ticket.service';
import { Project } from '../../Class/project';
import { CommonModule } from '@angular/common';
import { Ticket } from '../../Class/ticket';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-board',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './board.component.html',
  styleUrl: './board.component.css'
})
export class BoardComponent {
    
     project: Project = new Project()
     ticket: Ticket = new Ticket()
     selectedProjectData:any ;
     masterService = inject(MasterService)
     ticketService = inject(TicketService)
     http = inject(HttpClient)
     ticketArray: Ticket[] = [];
     status: string[] = ['To Do','In Progress','Done']
    
     constructor(){
      debugger;
      this.masterService.onProjectChange.subscribe((res:any)=>{
        this.getProjectTickets(res.projectId);
        this.selectedProjectData = res;
      })
      this.masterService.onTicketCreate.subscribe((res:any)=>{
        debugger;
        this.getProjectTickets(this.selectedProjectData.projectId);
      })
     }

     getProjectTickets(projectId:number){
        
        const url = `http://localhost:8080/api/tickets/${projectId}`;
        console.log(url);

        this.http.get<Ticket[]>(url).subscribe((res=>{
          this.ticketArray = res;
        }))
     }

     filterTicket(status:string) {
      return this.ticketArray.filter(m=>m.status == status)
     }
}
