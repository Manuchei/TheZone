import { Injectable } from '@angular/core';
import { CarritoItem } from '../interfaces/carrito-item';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CarritoService {
  private carrito: CarritoItem[] = [];
  private carritoSubject = new BehaviorSubject<CarritoItem[]>([]);

  constructor() {
    this.cargarCarrito();
  }

  private cargarCarrito(): void {
    const data = localStorage.getItem('carrito');
    this.carrito = data ? JSON.parse(data) : [];
    this.carritoSubject.next(this.carrito);
  }

  private guardarCarrito(): void {
    localStorage.setItem('carrito', JSON.stringify(this.carrito));
    this.carritoSubject.next(this.carrito); // 🔁 Emitir cambios
  }

  obtenerCarrito(): CarritoItem[] {
    return this.carrito;
  }

  obtenerCarritoObservable() {
    return this.carritoSubject.asObservable();
  }

  agregarAlCarrito(item: CarritoItem): void {
    const existente = this.carrito.find(a => a.articuloId === item.articuloId);
    if (existente) {
      existente.cantidad += item.cantidad;
    } else {
      this.carrito.push(item);
    }
    this.guardarCarrito();
  }

  eliminarDelCarrito(articuloId: number): void {
    this.carrito = this.carrito.filter(a => a.articuloId !== articuloId);
    this.guardarCarrito();
  }

  limpiarCarrito(): void {
    this.carrito = [];
    localStorage.removeItem('carrito');
    this.carritoSubject.next(this.carrito); // Emitir carrito vacío
  }
}
