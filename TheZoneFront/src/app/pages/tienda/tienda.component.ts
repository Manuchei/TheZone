import { Component, inject } from '@angular/core';
import { IArticulo } from '../../interfaces/iarticulo';
import { ArticulosService } from '../../services/articulos.service';
import { ArticuloCardComponent } from '../../components/articulo-card/articulo-card.component';
import { CommonModule } from '@angular/common';

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
  secciones: string[] = []; // Aquí se cargarán los nombres únicos
  articuloService = inject(ArticulosService);

  async ngOnInit(): Promise<void> {
    try {
      this.arrArticulos = await this.articuloService.getAllWithPromises();
      this.articulosFiltrados = [...this.arrArticulos];

      // Extraer secciones únicas
      const nombresSeccion = this.arrArticulos.map(a => a.seccion.nombre);
      this.secciones = [...new Set(nombresSeccion)];
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

    if (this.seccionesSeleccionadas.length === 0) {
      this.articulosFiltrados = [...this.arrArticulos];
    } else {
      this.articulosFiltrados = this.arrArticulos.filter(art =>
        this.seccionesSeleccionadas.includes(art.seccion.nombre)
      );
    }
  }
}
