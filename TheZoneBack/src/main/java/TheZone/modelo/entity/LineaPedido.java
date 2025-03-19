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
@Table(name = "lineas_pedido")
public class LineaPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLineaPedido;

	@ManyToOne
	@JoinColumn(name = "idPedido")
	private Pedido pedido;

	@ManyToOne
	@JoinColumn(name = "idArticulo")
	private Articulo articulo;

	private int cantidad;
	private double precio;
	private double TotalImporte;
}
