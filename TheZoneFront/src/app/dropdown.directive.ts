import { Directive, HostListener, ElementRef } from '@angular/core';

@Directive({
  selector: '[appDropdown]'
})
export class DropdownDirective {

  constructor(private elRef: ElementRef) { }

  // Mostrar el menú al pasar el ratón
  @HostListener('mouseenter') onMouseEnter() {
    const dropdownMenu = this.elRef.nativeElement.querySelector('.dropdown-menu');
    if (dropdownMenu) {
      dropdownMenu.style.display = 'block'; // Cambiar estilo para mostrar el menú
    }
  }

  // Ocultar el menú al salir el ratón
  @HostListener('mouseleave') onMouseLeave() {
    const dropdownMenu = this.elRef.nativeElement.querySelector('.dropdown-menu');
    if (dropdownMenu) {
      dropdownMenu.style.display = 'none'; // Cambiar estilo para ocultar el menú
    }
  }
}
