package proyectodeinvestigacion.GRUPO2.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import proyectodeinvestigacion.GRUPO2.entities.Carrera;

public interface CarreraRepository extends CrudRepository <Carrera, Long> {

    List<Carrera> findAll();
 
}