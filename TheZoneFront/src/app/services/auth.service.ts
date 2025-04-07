import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private user: { username: string } | null = null;

  setUser(user: { username: string }) {
    this.user = user; // Guarda el usuario
  }

  getUser() {
    return this.user; // Retorna el usuario actual o null
  }

  logout() {
    this.user = null; // Limpia el estado
  }
}
