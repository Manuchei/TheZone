import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';  // Importar FormsModule
import { CommonModule } from '@angular/common';  // Importar CommonModule para usar directivas como *ngIf
import { Router } from '@angular/router';  // Importar Router

@Component({
  selector: 'app-pago-page',
  standalone: true,
  imports: [FormsModule, CommonModule],  // Asegúrate de incluir CommonModule y FormsModule
  templateUrl: './pago-page.component.html',
  styleUrls: ['./pago-page.component.css']
})
export class PagoPageComponent {
  formaDePago = '';
  datosTarjeta: any = { numero: '', expiracion: '', cvv: '' };
  datosPaypal: any = { correo: '' };
  datosContraReembolso: any = { direccion: '' };

  constructor(private router: Router) {}  // Inyecta el Router

  mostrarFormulario(tipoPago: string) {
    this.formaDePago = tipoPago;
  }

  enviarPago() {
    console.log('Pago realizado con:', this.formaDePago);
    alert('Pago realizado');

    // Redirige a la página de agradecimiento después de realizar el pago
    this.router.navigate(['/gracias']);  // Asegúrate de que la ruta esté configurada en tu enrutador
  }
}
