import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-form-register',
  templateUrl: './form-register.component.html',
  styleUrls: ['./form-register.component.css'],
})
export class FormRegisterComponent {
  user = { email: '', username: '', password: '' };

  constructor(
    private http: HttpClient,
    private authService: AuthService,
    private router: Router
  ) {}

  updateField(field: 'email' | 'username' | 'password', event: Event) {
    const inputElement = event.target as HTMLInputElement;
    if (inputElement) {
      this.user[field] = inputElement.value;
    }
  }

  onRegister(event: Event) {
    event.preventDefault();
    this.http
      .post<any>('http://localhost:9002/articulos/usuarios/register', this.user)
      .subscribe(
        (response) => {
          console.log('Registro exitoso:', response);
          this.authService.setUser({ username: this.user.username }); // Guarda el user
          this.router.navigate(['/inicio']);
        },
        (error) => {
          console.error('Error en el registro:', error);
        }
      );
  }
}
