import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Login } from '../../Class/login';
import { LoginService } from '../../Service/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  
    login:Login = new Login();
  
    loginService = inject(LoginService)
    router=inject(Router)

    onLogIn(){
      this.loginService.createLogin(this.login).subscribe((res=>{
        if(res){
          localStorage.setItem('jiraLoginDetails',JSON.stringify(res));
          this.router.navigateByUrl('/board')
        }else{
          alert('Unable to login')
        }
      }))
    }

}
