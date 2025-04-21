import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IArticulo } from './../interfaces/iarticulo';
import { inject } from '@angular/core';
import { lastValueFrom } from 'rxjs';
@Injectable({
  providedIn: 'root',
})
export class ArticulosService {
  private baseUrl: string = 'http://localhost:9002/articulos/';

  constructor(private httpClient: HttpClient) {}  // Inyección tradicional

  // Obtener todos los artículos con Promesas
  async getAllWithPromises(): Promise<IArticulo[]> {
    try {
      const response = await lastValueFrom(
        this.httpClient.get<IArticulo[]>(this.baseUrl)
      );
      return response ?? []; // Devolver lista vacía si no hay respuesta
    } catch (error) {
      console.error('Error al obtener los artículos:', error);
      return []; // Devolver lista vacía en caso de error
    }
  }

  // Obtener artículo por ID con Promesas
  async getById(id: number): Promise<IArticulo> {
    try {
      const response = await lastValueFrom(
        this.httpClient.get<IArticulo>(`${this.baseUrl}${id}`)
      );
      return response;
    } catch (error) {
      console.error('Error al obtener el artículo:', error);
      throw error; // Lanzamos el error para que el componente pueda manejarlo
    }
  }
}