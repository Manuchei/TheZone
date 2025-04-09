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
@Table(name = "opiniones_articulos")
public class OpinionArticulo {
	@Id
	@Column(name="id_opinion")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOpinion;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "id_articulo")
	private Articulo articulo;

	private String valoracion;
	private Integer descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha")
	private Date fecha;
}
