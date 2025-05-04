import { Component, inject } from '@angular/core';
import { IArticulo } from '../../interfaces/iarticulo';
import { ArticulosService } from '../../services/articulos.service';
import { ArticuloCardComponent } from '../../components/articulo-card/articulo-card.component';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-tienda',
  standalone: true,
  imports: [ArticuloCardComponent, CommonModule],
  templateUrl: './tienda.component.html',
  styleUrl: './tienda.component.css',
})
export class TiendaComponent {
  arrArticulos: IArticulo[] = [];
  articulosFiltrados: IArticulo[] = [];
  seccionesSeleccionadas: string[] = [];
  secciones: string[] = [];
  articuloService = inject(ArticulosService);
  route = inject(ActivatedRoute);

  async ngOnInit(): Promise<void> {
    try {
      this.arrArticulos = await this.articuloService.getAllWithPromises();
      this.secciones = [...new Set(this.arrArticulos.map(a => a.seccion.nombre))];

      this.route.queryParams.subscribe(params => {
        const seccion = params['seccion'];

        if (seccion && this.secciones.includes(seccion)) {
          this.seccionesSeleccionadas = [seccion];
        }

        this.filtrarArticulos();
      });

    } catch (err) {
      console.error('Error al inicializar la API:', err);
    }
  }

  filtrarPorSeccion(event: Event): void {
    const input = event.target as HTMLInputElement;
    const nombreSeccion = input.value;

    if (input.checked) {
      this.seccionesSeleccionadas.push(nombreSeccion);
    } else {
      this.seccionesSeleccionadas = this.seccionesSeleccionadas.filter(s => s !== nombreSeccion);
    }

    this.filtrarArticulos();
  }

  private filtrarArticulos(): void {
    if (this.seccionesSeleccionadas.length === 0) {
      this.articulosFiltrados = [...this.arrArticulos];
    } else {
      this.articulosFiltrados = this.arrArticulos.filter(art =>
        this.seccionesSeleccionadas.includes(art.seccion.nombre)
      );
    }
  }
}
