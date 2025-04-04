import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-form-login',
  standalone: true,
  templateUrl: './form-login.component.html',
  styleUrls: ['./form-login.component.css'],
  imports: []
})
export class LoginComponent {
  credentials = { email: '', password: '' };
  loggedInMessage = false; // Controlar la visibilidad del mensaje

  constructor(private http: HttpClient) {}

  onLogin(event: Event) {
    event.preventDefault(); // Evitar la recarga de la página
    this.http.post('http://localhost:9002/articulos/usuarios/login', this.credentials).subscribe(
      (response) => {
        console.log('Login exitoso:', response);
        this.loggedInMessage = true; // Mostrar el mensaje
        setTimeout(() => {
          this.loggedInMessage = false; // Ocultar el mensaje después de 5 segundos
        }, 5000);
      },
      (error) => {
        console.error('Error en el login:', error);
        this.loggedInMessage = false; // Asegurarse de que el mensaje no se muestre si falla el login
      }
    );
  }

  updateField(field: 'email' | 'password', event: Event) {
    const inputElement = event.target as HTMLInputElement; // Cast explícito
    if (inputElement) {
      this.credentials[field] = inputElement.value; // Actualizar el campo
    }
  }
}
