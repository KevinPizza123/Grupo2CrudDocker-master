package proyectodeinvestigacion.GRUPO2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyectodeinvestigacion.GRUPO2.entities.Carrera;
import proyectodeinvestigacion.GRUPO2.repository.CarreraRepository;

import java.util.List;

@Service
public class CarreraService {


    @Autowired
    CarreraRepository carreraRepository;

    // Metodo Crear
    public Carrera crearCarrera(Carrera carrera) {
        return carreraRepository.save(carrera);
    }

    // Metodo listar
    public List<Carrera> getAll() {
        return carreraRepository.findAll();
    }

    // Read buscar por ID
    public Carrera findById(long id) {
        return carreraRepository.findById(id).orElse(null);
    }

    // Eliminar registro
    public void deleteById(long id) {
        carreraRepository.deleteById(id);
    }

    // Actualizar registro
    public Carrera actualizarCarrera(Carrera carrera) {
        Carrera carreraExistente = carreraRepository.findById(carrera.getId()).orElse(null);
        Carrera carreraActualizada = carreraRepository.save(carreraExistente);
        return carreraActualizada;
    }
}
