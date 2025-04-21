import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { IArticulo } from '../../interfaces/iarticulo';
import { ArticulosService } from '../../services/articulos.service';
import { CarritoService } from '../../services/carrito.service';

@Component({
  selector: 'app-articulo-view',
  templateUrl: './articulo-view.component.html',
  styleUrls: ['./articulo-view.component.css']
})
export class ArticuloViewComponent implements OnInit {
  articulo!: IArticulo;
  cantidad: number = 1;

  constructor(
    private route: ActivatedRoute,
    private articulosService: ArticulosService, // Inyección estándar
    private carritoService: CarritoService
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.articulosService.getById(id).then((data) => {
      if (data) {
        this.articulo = data;
      } else {
        console.error('Artículo no encontrado');
      }
    });
  }

  actualizarCantidad(event: any): void {
    const nuevaCantidad = Number(event.target.value);
    if (nuevaCantidad > 0 && nuevaCantidad <= (this.articulo.stock || 0)) {
      this.cantidad = nuevaCantidad;
    } else {
      alert('Cantidad no válida');
    }
  }

  formatearPrecio(precio: number | undefined): string {
    if (precio === undefined) {
      return '€0.00';
    }
    return new Intl.NumberFormat('es-ES', { style: 'currency', currency: 'EUR' }).format(precio);
  }

  anadirAlCarrito(): void {
    if (this.cantidad > 0) {
      const item = {
        articuloId: this.articulo.idArticulo,
        nombre: this.articulo.nombre,
        precio: this.articulo.precio,
        cantidad: this.cantidad,
        imagen: this.articulo.imagen
      };
      this.carritoService.agregarAlCarrito(item);
      alert('Producto añadido al carrito ✅');
    } else {
      alert('Seleccione una cantidad válida');
    }
  }
}
