import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-gracias',
  templateUrl: './gracias.component.html',
  styleUrls: ['./gracias.component.css']
})
export class GraciasComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
    // Redirigir automáticamente a la página de inicio después de 5 segundos
    setTimeout(() => {
      this.router.navigate(['/']);
    }, 5000); // 5000 ms = 5 segundos
  }
}
