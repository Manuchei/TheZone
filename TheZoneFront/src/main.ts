import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app.component';
import { provideRouter, Routes } from '@angular/router';
import { LoginComponent } from './app/pages/form-login/form-login.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: '**', redirectTo: 'login' } // Redirige cualquier ruta desconocida al login
];
bootstrapApplication(AppComponent, appConfig)
  .catch((err) => console.error(err));
