package TheZone.modelo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
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
public class CarritoArticulo {

	@Id
	@Column(name = "id_carrito_articulo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCarritoArticulo;

	@ManyToOne
	@JoinColumn(name = "id_carrito")
	private Carrito carrito;

	@ManyToOne
	@JoinColumn(name = "id_articulo")
	private Articulo articulo;

	private int Cantidad;
	private double precio;
	
	@Column(name = "Total_importe")
	private double totalImporte;

}
