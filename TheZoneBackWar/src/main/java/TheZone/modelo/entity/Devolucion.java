package TheZone.modelo.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
@Table(name = "devoluciones")
public class Devolucion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDevolucion;

	@ManyToOne
	@JoinColumn(name = "idFactura")
	private Factura factura;

	@ManyToOne
	@JoinColumn(name = "idLineaFactura")
	private LineaFactura lineaFactura;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha")
	private Date fecha;

	private String motivo;

}