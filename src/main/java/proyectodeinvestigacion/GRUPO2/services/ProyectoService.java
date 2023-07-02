package proyectodeinvestigacion.GRUPO2.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyectodeinvestigacion.GRUPO2.entities.Proyecto;
import proyectodeinvestigacion.GRUPO2.repository.ProyectoRepository;

@Service
public class ProyectoService {
    //atributo delimitador de acceso,tipo de dato,nombre del atributo
    @Autowired
    private ProyectoRepository proyectoRepository;

    //Crud
    //crear
    //metod delimitador de acceso,tipo de dato que retorna,nombre del metodo/funcion
    public Proyecto save( Proyecto entity){
        return proyectoRepository.save(entity);
    }

    //read
    public Proyecto findById(long id){
        return proyectoRepository.findById(id).orElse(null);
    }

    //delete
    public void deleteById(long id){
        proyectoRepository.deleteById(id);
    }

    //traer todo
   public List<Proyecto> findAll(){
       return proyectoRepository.findAll();
   }
} 