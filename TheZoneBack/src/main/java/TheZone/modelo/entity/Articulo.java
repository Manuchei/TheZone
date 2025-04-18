package TheZone.modelo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode (of = "idArticulo")
@Data
@Builder
@Entity
@Table(name = "articulos")
public class Articulo {
    @Id
    @Column(name="id_articulo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idArticulo;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private String imagen;
    private boolean activo;

    @ManyToOne
    @JoinColumn(name = "id_seccion")
    private Seccion seccion;
}