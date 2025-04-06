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
@EqualsAndHashCode(of="idUsuario")
@Builder
public class CarritoDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int idUsuario;
	private double totalPago;
}
