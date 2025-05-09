package TheZone.modelo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CARRITO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Carrito {

	@Id
	@Column(name = "id_carrito")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCarrito;
	
    @OneToOne
    @JoinColumn(name = "id_usuario") 
    private Usuario usuario;

    @Column(name = "total_pago")
    private double totalPago;
}