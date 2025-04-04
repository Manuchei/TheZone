import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-form-register',
  standalone: true,
  templateUrl: './form-register.component.html',
  styleUrls: ['./form-register.component.css'],
  imports: []
})
export class FormRegisterComponent {
  user = { email: '', username: '', password: '' }; // Modelo del usuario

  constructor(private http: HttpClient) {}

  onRegister(event: Event) {
    event.preventDefault(); // Evitar la recarga de la página
    this.http.post('http://localhost:9002/articulos/usuarios/register', this.user).subscribe(
      (response) => {
        console.log('Registro exitoso:', response);
        // Aquí puedes añadir lógica adicional, como mostrar un mensaje de éxito o redirigir al usuario
      },
      (error) => {
        console.error('Error en el registro:', error);
        // Manejo de errores, como mostrar un mensaje al usuario
      }
    );
  }

  updateField(field: 'email' | 'username' | 'password', event: Event) {
    const inputElement = event.target as HTMLInputElement; // Asegúrate de que es un input válido
    if (inputElement) {
      this.user[field] = inputElement.value; // Actualizar el campo correspondiente
    }
  }
}
