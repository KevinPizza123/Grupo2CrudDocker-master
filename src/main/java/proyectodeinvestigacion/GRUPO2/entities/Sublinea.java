package proyectodeinvestigacion.GRUPO2.entities;

//java 

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sublinea")
public class Sublinea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "idSublinea")
    private List<LineaSublinea> lineaSublineaList;
}
