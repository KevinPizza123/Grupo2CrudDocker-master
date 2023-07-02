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
@Table(name = "programa")
public class Programa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titulo;

    @JoinColumn(name = "id_actividad", referencedColumnName = "id")
    @ManyToOne
    private Actividad idActividad;
    @JoinColumn(name = "id_linea", referencedColumnName = "id")
    @ManyToOne
    private Linea idLinea;
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id")
    @ManyToOne
    private Proyecto idProyecto;

}