package proyectodeinvestigacion.GRUPO2.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import proyectodeinvestigacion.GRUPO2.entities.Sublinea;

    public interface SublineaRepository extends CrudRepository <Sublinea, Long> {

    List<Sublinea> findAll();
 
}