package proyectodeinvestigacion.GRUPO2.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import proyectodeinvestigacion.GRUPO2.entities.Proyecto;

    public interface ProyectoRepository extends CrudRepository <Proyecto, Long> {

    List<Proyecto> findAll();
 
}
