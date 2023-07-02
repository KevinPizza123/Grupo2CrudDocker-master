package proyectodeinvestigacion.GRUPO2.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "linea")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Linea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String carrera;
    private String estado;
    private LocalDate fecha_aprobacion;

    @OneToMany(mappedBy = "idLinea")
    private List<Programa> programaList;

    @OneToMany(mappedBy = "idLinea")
    private List<LineaSublinea> lineaSublineaList;

    @JoinColumn(name = "id_carrera", referencedColumnName = "id")
    @ManyToOne
    private Carrera idCarrera;


}