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

import proyectodeinvestigacion.GRUPO2.entities.Proyecto;
import proyectodeinvestigacion.GRUPO2.services.ProyectoService;

@RestController
@RequestMapping("api/proyecto")
@CrossOrigin("*")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    // crear
    // metod delimitador de acceso,tipo de dato que retorna,nombre del
    // metodo/funcion
    @PostMapping("/crear")
    public Proyecto save(@RequestBody Proyecto entity) {
        return proyectoService.save(entity);
    }

    // traer por id
    @GetMapping("/listar/{id}")
    public Proyecto findById(@PathVariable long id) {
        return proyectoService.findById(id);
    }

    // traer todo
    @GetMapping("/listar")
    public List<Proyecto> findAll() {
        return proyectoService.findAll();
    }

    // actualizar
    @PutMapping("/actualizar")
    public Proyecto update(@RequestBody Proyecto entity) {
        return proyectoService.save(entity);
    }

    // actualizar parcial
    @PatchMapping("/actualizar/{id}")
    public Proyecto partialUpdate(@PathVariable long id, @RequestBody Map<String, Object> fields) {
        Proyecto proyecto = findById(id);
        for (Map.Entry<String, Object> field : fields.entrySet()) {
            String fieldName = field.getKey();
            Object fieldValue = field.getValue();
            try {
                Field campoEntidad = Proyecto.class.getDeclaredField(fieldName);
                campoEntidad.setAccessible(true);
                campoEntidad.set(proyecto, fieldValue);
            } catch (NoSuchFieldException | IllegalAccessException ex) {
                
            }
        }
        return update(proyecto);
    }

    // eliminar
    @DeleteMapping("/eliminar/{id}")
    public void deleteById(@PathVariable long id) {
        proyectoService.deleteById(id);
    }

}