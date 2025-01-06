import { Component, inject, OnInit } from '@angular/core';
import { Project } from '../../Class/project';
import { ProjectService } from '../../Service/project.service';
import { DatePipe } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-projects',
  standalone: true,
  imports: [DatePipe,FormsModule],
  templateUrl: './projects.component.html',
  styleUrl: './projects.component.css'
})
export class ProjectsComponent implements OnInit {
  
    project:Project = new Project();

    projectList:Project[] = [];

    projectsrv = inject(ProjectService)

    ngOnInit(): void {
      this.getAllproject();
    }
    
    getAllproject(){
      debugger;
      this.projectsrv.getProjects().subscribe(((res=>{
        
        this.projectList = res;
      })))
    }

    onSave(){
       this.projectsrv.createProject(this.project).subscribe((res=>{
        if(res){
          alert('Project Created successfully')
          this.getAllproject();
        }else{
          alert('Not able to create project')
        }
       }))
    }
}
