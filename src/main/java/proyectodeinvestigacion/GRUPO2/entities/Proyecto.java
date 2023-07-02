package proyectodeinvestigacion.GRUPO2.entities;

import java.util.List;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "proyecto")
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String justificacion;
    private String antecedentes;

    @OneToMany(mappedBy = "idProyecto")
    private List<Programa> programaList;

}
