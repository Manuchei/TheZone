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
@Table(name = "lineas_devolucion")
public class LineaDevolucion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLineaDevolucion;

	@ManyToOne
	@JoinColumn(name = "idDevolucion")
	private Devolucion devolucion;

	@ManyToOne
	@JoinColumn(name = "idArticulo")
	private Articulo articulo;
	private int Cantidad;
	private double precio;
	private double TotalImporte;
}
