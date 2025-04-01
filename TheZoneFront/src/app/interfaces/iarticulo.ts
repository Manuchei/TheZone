import { ISeccion } from "./iseccion";

export interface IArticulo {
    idArticulo: number;
    nombre: string;
    descripcion: string;
    precio: number;
    stock: number;
    imagen: string;
    seccion: ISeccion; // Asociación con la sección
  }