import { Component, inject,  } from '@angular/core';
import { IArticulo } from '../../interfaces/iarticulo';
import { ArticulosService } from '../../services/articulos.service';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-articulo-view',
  imports: [CommonModule, FormsModule ],
  templateUrl: './articulo-view.component.html',
  styleUrl: './articulo-view.component.css',
})
export class ArticuloViewComponent {
  miArticulo!: IArticulo;

  ArticuloService = inject(ArticulosService);
  activatedRoute = inject(ActivatedRoute);

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(async (params: any) => {
      let id: number = params.id as number;

      try {
        this.miArticulo = await this.ArticuloService.getById(id);
      } catch (err) {
        console.log('Error al llamar a la API' + err);
      }
    });
  }
}
