import { Component } from '@angular/core';
import { Router } from '@angular/router';  // Importar Router
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-checkout-page',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './checkout-page.component.html',
  styleUrls: ['./checkout-page.component.css']
})
export class CheckoutPageComponent {

  nombreCompleto: string = '';
  direccion: string = '';
  ciudad: string = '';
  provincia: string = '';
  codigoPostal: string = '';
  pais: string = '';
  dni: string = '';

  constructor(private router: Router) {} // Inyecta Router

  // Método para enviar el formulario
  enviarFormulario() {
    if (
      this.nombreCompleto && this.direccion && this.ciudad &&
      this.provincia && this.codigoPostal && this.pais && this.dni
    ) {
      alert('Formulario enviado correctamente');
      this.router.navigate(['/pago']); // Redirige a la página de pago
    } else {
      alert('Por favor, rellena todos los campos antes de continuar.');
    }
  }
}
