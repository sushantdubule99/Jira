import { Routes } from '@angular/router';
import { LayoutComponent } from './Pages/layout/layout.component';
import { ProjectsComponent } from './Pages/projects/projects.component';
import { UsersComponent } from './Pages/users/users.component';
import { BoardComponent } from './Pages/board/board.component';
import { LoginComponent } from './Pages/login/login.component';

export const routes: Routes = [
    {
        path:'',
        redirectTo:'login',
        pathMatch:"full"
    },
    {
        path:'login',
        component:LoginComponent
    },
    {
        path:'',
        component:LayoutComponent,
        children:[
            {
                path:'projects',
                component:ProjectsComponent
            },
            {
                path:'users',
                component:UsersComponent
            },
            {
                path:'board',
                component:BoardComponent
            }
        ]
    }
];
