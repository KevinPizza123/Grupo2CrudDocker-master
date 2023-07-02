package proyectodeinvestigacion.GRUPO2.controllers;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proyectodeinvestigacion.GRUPO2.entities.Programa;
import proyectodeinvestigacion.GRUPO2.services.ProgramaService;

@RestController
@RequestMapping("api/programa")
@CrossOrigin("*")
public class ProgramaController {

    @Autowired
    private ProgramaService programaService;

    // crear
    // metod delimitador de acceso,tipo de dato que retorna,nombre del
    // metodo/funcion
    @PostMapping("/crear")
    public Programa save(@RequestBody Programa entity) {
        return programaService.save(entity);
    }

    // traer por id
    @GetMapping("/listar/{id}")
    public Programa findById(@PathVariable long id) {
        return programaService.findById(id);
    }

    // traer todo
    @GetMapping("/listar")
    public List<Programa> findAll() {
        return programaService.findAll();
    }

    // actualizar
    @PutMapping("/actualizar")
    public Programa update(@RequestBody Programa entity) {
        return programaService.save(entity);
    }

    // actualizar parcial
    @PatchMapping("/actualizar/{id}")
    public Programa partialUpdate(@PathVariable long id, @RequestBody Map<String, Object> fields) {
        Programa programa = findById(id);
        for (Map.Entry<String, Object> field : fields.entrySet()) {
            String fieldName = field.getKey();
            Object fieldValue = field.getValue();
            try {
                Field campoEntidad = Programa.class.getDeclaredField(fieldName);
                campoEntidad.setAccessible(true);
                campoEntidad.set(programa, fieldValue);
            } catch (NoSuchFieldException | IllegalAccessException ex) {
                
            }
        }
        return update(programa);
    }

    // eliminar
    @DeleteMapping("/eliminar/{id}")
    public void deleteById(@PathVariable long id) {
        programaService.deleteById(id);
    }

}