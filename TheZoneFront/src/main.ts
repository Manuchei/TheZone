import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';
import { provideRouter, Routes } from '@angular/router';
import { appConfig } from './app/app.config';

import { LoginComponent } from './app/pages/form-login/form-login.component';
import { CarritoComponent } from './app/pages/carrito/carrito.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'carrito', component: CarritoComponent },
  { path: '**', redirectTo: 'login' }
];

bootstrapApplication(AppComponent, {
  ...appConfig,
  providers: [
    ...appConfig.providers || [],
    provideRouter(routes)
  ]
}).catch((err) => console.error(err));
