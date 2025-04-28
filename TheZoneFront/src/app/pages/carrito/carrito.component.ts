import { Component, OnInit, OnDestroy } from '@angular/core';
import { CommonModule, CurrencyPipe } from '@angular/common';
import { CarritoService } from '../../services/carrito.service';
import { CarritoItem } from '../../interfaces/carrito-item';
import { Subscription } from 'rxjs';
import { Router } from '@angular/router'; // <-- IMPORTAR ROUTER

@Component({
  selector: 'app-carrito',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './carrito.component.html',
  styleUrls: ['./carrito.component.css'],
  providers: [CurrencyPipe]
})
export class CarritoComponent implements OnInit, OnDestroy {
  carrito: CarritoItem[] = [];
  total: number = 0;
  private carritoSub!: Subscription;

  constructor(
    private carritoService: CarritoService,
    private currencyPipe: CurrencyPipe,
    private router: Router   // <-- INYECTAR ROUTER
  ) {}

  ngOnInit(): void {
    this.carritoSub = this.carritoService.obtenerCarritoObservable().subscribe(carrito => {
      this.carrito = carrito;
      this.calcularTotal();
    });
  }

  ngOnDestroy(): void {
    this.carritoSub.unsubscribe(); // 🧹 Limpieza
  }

  calcularTotal(): void {
    this.total = this.carrito.reduce((suma, item) => suma + item.precio * item.cantidad, 0);
  }

  formatearPrecio(valor: number): string {
    return this.currencyPipe.transform(valor, 'EUR') ?? '';
  }

  eliminarDelCarrito(id: number): void {
    this.carritoService.eliminarDelCarrito(id);
  }

  irACheckout(): void {
    this.carritoService.limpiarCarrito(); // Limpiar el carrito
    this.router.navigate(['/checkout']); // Navegar al formulario de checkout
  }
}
