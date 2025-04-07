import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthService } from '../../services/auth.service'; // AÑADE esto
import { Router } from '@angular/router'; // Opcional para redirigir después de login

@Component({
  selector: 'app-form-login',
  templateUrl: './form-login.component.html',
  styleUrls: ['./form-login.component.css'],
})
export class LoginComponent {
  credentials = { email: '', password: '' };
  loggedInMessage = false;

  constructor(
    private http: HttpClient,
    private authService: AuthService, // INYECTA el servicio
    private router: Router
  ) {}

  updateField(field: 'email' | 'password', event: Event) {
    const inputElement = event.target as HTMLInputElement;
    if (inputElement) {
      this.credentials[field] = inputElement.value;
    }
  }

  onLogin(event: Event) {
    event.preventDefault();

    this.http
      .post<any>('http://localhost:9002/articulos/usuarios/login', this.credentials)
      .subscribe(
        (response) => {
          console.log('Login exitoso:', response);
          this.authService.setUser({ username: response.username }); // GUARDA el usuario
          this.loggedInMessage = true;
          setTimeout(() => {
            this.loggedInMessage = false;
          }, 5000);
          this.router.navigate(['/inicio']); // Redirige si quieres
        },
        (error) => {
          console.error('Error en el login:', error);
          this.loggedInMessage = false;
        }
      );
  }
}
