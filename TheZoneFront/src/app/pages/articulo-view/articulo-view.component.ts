import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { IArticulo } from '../../interfaces/iarticulo';
import { ArticulosService } from '../../services/articulos.service';

@Component({
  selector: 'app-articulo-view',
  templateUrl: './articulo-view.component.html',
  styleUrls: ['./articulo-view.component.css']
})export class ArticuloViewComponent implements OnInit {
  articulo!: IArticulo;
  cantidad: number = 1;

  constructor(
    private route: ActivatedRoute,
    private articulosService: ArticulosService
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.articulosService.getById(id).then((data) => {
      this.articulo = data;
    });
  }

  actualizarCantidad(event: any): void {
    this.cantidad = event.target.value;
  }

  formatearPrecio(precio: number | undefined): string {
    if (precio === undefined) {
      return '€0.00'; // Valor por defecto en caso de que sea undefined
    }
    return new Intl.NumberFormat('es-ES', { style: 'currency', currency: 'EUR' }).format(precio);
  }
}
