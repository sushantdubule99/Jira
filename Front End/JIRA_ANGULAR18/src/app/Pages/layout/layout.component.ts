import { Component, inject, OnInit } from '@angular/core';
import { Router, RouterLink, RouterOutlet } from '@angular/router';
import { Project } from '../../Class/project';
import { ProjectService } from '../../Service/project.service';
import { User } from '../../Class/user';
import { UserService } from '../../Service/user.service';
import { Ticket } from '../../Class/ticket';
import { FormsModule } from '@angular/forms';
import { TicketService } from '../../Service/ticket.service';
import { CommonModule } from '@angular/common';
import { MasterService } from '../../Service/master.service';

@Component({
  selector: 'app-layout',
  standalone: true,
  imports: [RouterOutlet,FormsModule,CommonModule],
  templateUrl: './layout.component.html',
  styleUrl: './layout.component.css'
})
export class LayoutComponent implements OnInit {
    

   
   project:Project = new Project();

   ticket:Ticket=new Ticket();
  
      projectList:Project[] = [];
  
      projectsrv = inject(ProjectService)
         user:User=new User();
       
            userList: User[]= [];
               
           userService = inject(UserService)

           ticketService = inject(TicketService)

           masterService = inject(MasterService)

           router = inject(Router)

           

           issueTypes: string[] =['Ticket','Defect','RnD Work'];
           status: string[] = ['To Do','In Progress','Done']

           constructor(){
            const loginData = localStorage.getItem('jiraLoginDetails');
            if(loginData != null){
              const parseData = JSON.parse(loginData);
              this.ticket.createdBy = parseData.userId;
            }
           }
  
      ngOnInit(): void {
        this.getAllproject();
        this.getAllUsers();
      }

      setProject(obj:any){
         this.masterService.onProjectChange.next(obj);
      }
      
      getAllproject(){
        debugger;
        this.projectsrv.getProjects().subscribe(((res=>{
          
          this.projectList = res;
          this.masterService.onProjectChange.next(this.projectList[0])
        })))
      }

      getAllUsers(){
        this.userService.getUsers().subscribe((res=>{
         this.userList = res;
        }))
     }

     createTicket(): void{
        if(this.ticket){
          this.ticketService.saveTicketByProjectId(this.project.projectId,this.ticket).subscribe({
            next: (data) =>{
              console.log('Ticket saved successfully:',data)
              alert('Ticket Saved Sucessfully');
              this.router.navigateByUrl('/board');
              this.masterService.onTicketCreate.next(true);
            },
            error:(err) =>{
              console.error('Error saving Ticket',err);
            }
          })

          
        }else{
          alert('Please fill out all required fields')
        }
     }
 
  

}
