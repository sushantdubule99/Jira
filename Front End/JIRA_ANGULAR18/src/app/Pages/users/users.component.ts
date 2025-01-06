import { Component, inject, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { User } from '../../Class/user';
import { UserService } from '../../Service/user.service';

@Component({
  selector: 'app-users',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './users.component.html',
  styleUrl: './users.component.css'
})
export class UsersComponent implements OnInit {
  
     user:User=new User();

     userList: User[]= [];
        
    userService = inject(UserService)
   
   ngOnInit(): void {
     this.getAllUsers();
   }

    getAllUsers(){
       this.userService.getUsers().subscribe((res=>{
        this.userList = res;
       }))
    }

     onSave(){
       this.userService.saveUser(this.user).subscribe((res=>{
        if(res){
          alert('User Created Successfully');
          this.getAllUsers();
        }else{
          alert('Unable to create User')
        }
       }))
     }
}
