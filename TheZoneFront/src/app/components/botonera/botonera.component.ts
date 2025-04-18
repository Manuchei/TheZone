import { ArticulosService } from './../../services/articulos.service';
import { Component, inject, Input } from '@angular/core';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-botonera',
  imports: [RouterLink],
  templateUrl: './botonera.component.html',
  styleUrl: './botonera.component.css'
})
export class BotoneraComponent {
borrarUser(arg0: any) {
throw new Error('Method not implemented.');
}

  ArticulosService = inject(ArticulosService)
  router = inject(Router)

  @Input() id!: number
  @Input() parent!: string


}
