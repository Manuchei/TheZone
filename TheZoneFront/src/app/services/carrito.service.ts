// src/app/services/carrito.service.ts

import { Injectable } from '@angular/core';
import { CarritoItem } from '../interfaces/carrito-item';
import { BehaviorSubject } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class CarritoService {
  private carrito: CarritoItem[] = [];
  private carritoSubject = new BehaviorSubject<CarritoItem[]>([]);
  private storageKey: string = 'carrito_guest';

  constructor(private authService: AuthService) {
    // Cada vez que cambie el usuario, actualizamos la clave y recargamos el carrito
    this.authService.getUserObservable().subscribe(user => {
      this.storageKey = user
        ? `carrito_${user.username}`
        : 'carrito_guest';
      this.cargarCarrito();
    });
  }

  private cargarCarrito(): void {
    const data = localStorage.getItem(this.storageKey);
    this.carrito = data ? JSON.parse(data) : [];
    this.carritoSubject.next(this.carrito);
  }

  private guardarCarrito(): void {
    localStorage.setItem(this.storageKey, JSON.stringify(this.carrito));
    this.carritoSubject.next(this.carrito);
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
    localStorage.removeItem(this.storageKey);
    this.carritoSubject.next(this.carrito);
  }
}
