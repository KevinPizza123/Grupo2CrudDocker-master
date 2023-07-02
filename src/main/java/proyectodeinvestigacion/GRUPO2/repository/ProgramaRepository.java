package proyectodeinvestigacion.GRUPO2.repository;

 import java.util.List;

import org.springframework.data.repository.CrudRepository;

import proyectodeinvestigacion.GRUPO2.entities.Programa;
     
     public interface ProgramaRepository extends CrudRepository<Programa, Long> {
     
         List<Programa> findAll();
     
     
     
     }
 