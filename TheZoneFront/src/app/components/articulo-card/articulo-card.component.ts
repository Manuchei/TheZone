import { Component, Input } from '@angular/core';
import { IArticulo } from '../../interfaces/iarticulo';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-articulo-card',
  imports: [CommonModule, ],
  templateUrl: './articulo-card.component.html',
  styleUrl: './articulo-card.component.css'
})
export class ArticuloCardComponent {
  @Input() miArticulo!: IArticulo;

}
