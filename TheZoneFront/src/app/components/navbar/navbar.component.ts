import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [RouterLink, CommonModule], // Asegúrate de que CommonModule esté importado
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent {
  constructor(private authService: AuthService) {}

  get user() {
    return this.authService.getUser(); // Obtiene el usuario desde AuthService
  }

  logout() {
    this.authService.logout(); // Cierra sesión y limpia el estado del usuario
  }
}
