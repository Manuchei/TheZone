package TheZone.modelo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Builder
@Entity
@Table(name = "carrito_articulos")

public class Carrito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCarrito;

	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;

	private double TotalPago;
}
