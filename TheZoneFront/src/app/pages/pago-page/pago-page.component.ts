import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pago-page',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './pago-page.component.html',
  styleUrls: ['./pago-page.component.css']
})
export class PagoPageComponent {
  formaDePago = '';
  tipoEnvio = '';  // Agregado para controlar el tipo de envío

  datosTarjeta: any = { numero: '', expiracion: '', cvv: '' };
  datosPaypal: any = { correo: '' };
  datosContraReembolso: any = { direccion: '' };

  constructor(private router: Router) {}

  mostrarFormulario(tipoPago: string) {
    this.formaDePago = tipoPago;
  }

  seleccionarEnvio(tipo: string) {
    this.tipoEnvio = tipo;
  }

  enviarPago() {
    if (!this.tipoEnvio) {
      alert('Por favor, selecciona un tipo de envío.');
      return;
    }

    if (!this.formaDePago) {
      alert('Por favor, selecciona un método de pago.');
      return;
    }

    console.log('Pago realizado con:', this.formaDePago);
    console.log('Tipo de envío seleccionado:', this.tipoEnvio);
    alert('Pago realizado correctamente');

    this.router.navigate(['/gracias']);
  }
}
