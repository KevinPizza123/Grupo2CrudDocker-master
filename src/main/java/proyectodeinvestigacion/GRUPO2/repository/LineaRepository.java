package proyectodeinvestigacion.GRUPO2.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import proyectodeinvestigacion.GRUPO2.entities.Linea;

    public interface LineaRepository extends CrudRepository <Linea, Long> {

    List<Linea> findAll();
 
}
