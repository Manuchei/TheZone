import { Component, inject } from '@angular/core';
import { IArticulo } from '../../interfaces/iarticulo';
import { ArticulosService } from '../../services/articulos.service';
import { ArticuloCardComponent } from '../../components/articulo-card/articulo-card.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-tienda',
  imports: [ArticuloCardComponent, CommonModule],
  templateUrl: './tienda.component.html',
  styleUrl: './tienda.component.css',
})
export class TiendaComponent {
  arrArticulos: IArticulo[];
  articuloService = inject(ArticulosService);
  page!: number;
  articulo!: IArticulo;

  constructor() {
    this.arrArticulos = [];
  }

  async ngOnInit(): Promise<void> {
    try {
      this.arrArticulos = await this.articuloService.getAllWithPromises();
    } catch (err) {
      console.log('Error al inicializar la API: ' + err);
    }
  }
}
