package proyectodeinvestigacion.GRUPO2.authz.repository;

import java.util.List;



import org.springframework.data.repository.CrudRepository;

import proyectodeinvestigacion.GRUPO2.authz.entity.Role;



public interface RoleRepository extends CrudRepository <Role, Long> {

    List<Role> findAll();
    
}