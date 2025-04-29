import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private user: { username: string } | null = null;
  private userSubject = new BehaviorSubject<{ username: string } | null>(null);

  constructor(private router: Router) {
    // Opcional: recuperar user de localStorage si se persiste entre recargas
    const stored = localStorage.getItem('user');
    if (stored) {
      this.user = JSON.parse(stored);
      this.userSubject.next(this.user);
    }
  }

  setUser(user: { username: string }) {
    this.user = user;
    localStorage.setItem('user', JSON.stringify(user));
    this.userSubject.next(user);
    // Redirigir al inicio tras login
    this.router.navigate(['/inicio']);
  }

  getUser() {
    return this.user;
  }

  logout() {
    this.user = null;
    localStorage.removeItem('user');
    this.userSubject.next(null);
    // Redirigir al inicio tras logout
    this.router.navigate(['/inicio']);
  }

  isAuthenticated(): boolean {
    return this.user !== null;
  }

  getUserObservable() {
    return this.userSubject.asObservable();
  }
}