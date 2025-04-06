package TheZone.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of="idCarritoArticulo")
@Builder
public class CarritoArticuloDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int idCarritoArticulo;
	private int idCarrito;
	private int idArticulo;
	private int cantidad;
	private double precio;
	private double totalImporte;

}
