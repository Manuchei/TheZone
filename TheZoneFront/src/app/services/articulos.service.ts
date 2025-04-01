import { IArticulo } from './../interfaces/iarticulo';
import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { lastValueFrom } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ArticulosService {
  httpClient = inject(HttpClient);
  private baseUrl: string = 'http://localhost:9002/articulos/';

  constructor() {}

  async getAllWithPromises(): Promise<IArticulo[]> {
    const response = await lastValueFrom(
      this.httpClient.get<IArticulo[]>(this.baseUrl)
    );
    return response ?? [];
  }

  getById(id: number): Promise<IArticulo> {
    return lastValueFrom(
      this.httpClient.get<IArticulo>(`${this.baseUrl}/${id}`)
    );
  }
}
