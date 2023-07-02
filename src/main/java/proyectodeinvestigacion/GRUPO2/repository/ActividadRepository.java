package proyectodeinvestigacion.GRUPO2.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import proyectodeinvestigacion.GRUPO2.entities.Actividad;

    public interface ActividadRepository extends CrudRepository <Actividad, Long> {

    List<Actividad> findAll();
 
}