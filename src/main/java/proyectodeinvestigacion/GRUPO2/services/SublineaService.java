package proyectodeinvestigacion.GRUPO2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyectodeinvestigacion.GRUPO2.entities.Sublinea;
import proyectodeinvestigacion.GRUPO2.repository.SublineaRepository;

@Service
public class SublineaService {
    //atributo delimitador de acceso,tipo de dato,nombre del atributo
    @Autowired
    private SublineaRepository sublineaRepository;

    //Crud
    //crear
    //metod delimitador de acceso,tipo de dato que retorna,nombre del metodo/funcion
    public Sublinea save( Sublinea entity){
        return sublineaRepository.save(entity);
    }

    //read
    public Sublinea findById(long id){
        return sublineaRepository.findById(id).orElse(null);
    }

    //delete
    public void deleteById(long id){
        sublineaRepository.deleteById(id);
    }

    //traer todo
   public List<Sublinea> findAll(){
       return sublineaRepository.findAll();
   }
} 