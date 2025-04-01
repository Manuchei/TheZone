import { Routes } from '@angular/router';
import { FormLoginComponent } from './pages/form-login/form-login.component';
import { InicioComponent } from './pages/inicio/inicio.component';
import { QuienesSomosComponent } from './pages/quienes-somos/quienes-somos.component';
import { TiendaComponent } from './pages/tienda/tienda.component';
import { ContactoComponent } from './pages/contacto/contacto.component';
import { Page404Component } from './pages/page404/page404.component';
import { ArticuloViewComponent } from './pages/articulo-view/articulo-view.component';

export const routes: Routes = [
    { path: '', pathMatch: 'full', redirectTo: 'inicio'},
    { path: 'inicio', component: InicioComponent  },
    { path: 'quienes-somos', component: QuienesSomosComponent},
    { path: 'tienda', component: TiendaComponent},
    { path: 'contacto', component: ContactoComponent},
    { path: 'login', component: FormLoginComponent },
    { path: 'articulo/:id', component: ArticuloViewComponent},
    { path: '**', component: Page404Component },
];
