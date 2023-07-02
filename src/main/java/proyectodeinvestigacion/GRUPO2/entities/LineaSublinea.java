package proyectodeinvestigacion.GRUPO2.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "linea_sublinea")
public class LineaSublinea {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JoinColumn(name = "id_linea", referencedColumnName = "id")
    @ManyToOne
    private Linea idLinea;
    @JoinColumn(name = "id_sublinea", referencedColumnName = "id")
    @ManyToOne
    private Sublinea idSublinea;
}
