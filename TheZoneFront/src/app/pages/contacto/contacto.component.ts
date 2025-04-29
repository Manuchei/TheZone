import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms'; // 👈 Importa FormsModule para usar ngForm

@Component({
  selector: 'app-contacto',
  standalone: true, // 👈 standalone debe estar en true
  imports: [FormsModule], // 👈 aquí va FormsModule
  templateUrl: './contacto.component.html',
  styleUrls: ['./contacto.component.css']
})
export class ContactoComponent {

  constructor(private router: Router) {}

  enviarFormulario(form: any) {
    if (form.valid) {
      alert('Formulario enviado con éxito');
      this.router.navigate(['/']);
    }
  }
}
