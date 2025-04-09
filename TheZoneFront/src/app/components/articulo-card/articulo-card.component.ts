import { Component, Input } from '@angular/core';
import { IArticulo } from '../../interfaces/iarticulo';
import { CommonModule } from '@angular/common';
import { BotoneraComponent } from "../botonera/botonera.component";
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-articulo-card',
  imports: [CommonModule, BotoneraComponent, RouterLink],
  templateUrl: './articulo-card.component.html',
  styleUrl: './articulo-card.component.css'
})
export class ArticuloCardComponent {
  @Input() miArticulo!: IArticulo;

}
