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

import proyectodeinvestigacion.GRUPO2.entities.Actividad;
import proyectodeinvestigacion.GRUPO2.services.ActividadService;
    
    @RestController
    @RequestMapping("api/actividad")
    @CrossOrigin("*")
    public class ActividadController {
    
        @Autowired
        private ActividadService actividadService;
    
        // crear
        // metod delimitador de acceso,tipo de dato que retorna,nombre del
        // metodo/funcion
        @PostMapping("/crear")
        public Actividad save(@RequestBody Actividad entity) {
            return actividadService.save(entity);
        }
    
        // traer por id
        @GetMapping("/listar/{id}")
        public Actividad findById(@PathVariable long id) {
            return actividadService.findById(id);
        }
    
        // traer todo
        @GetMapping("/listar")
        public List<Actividad> findAll() {
            return actividadService.findAll();
        }
    
        // actualizar
        @PutMapping("/actualizar")
        public Actividad update(@RequestBody Actividad entity) {
            return actividadService.save(entity);
        }
    
        // actualizar parcial
        @PatchMapping("/actualizar/{id}")
        public Actividad partialUpdate(@PathVariable long id, @RequestBody Map<String, Object> fields) {
            Actividad actividad = findById(id);
            for (Map.Entry<String, Object> field : fields.entrySet()) {
                String fieldName = field.getKey();
                Object fieldValue = field.getValue();
                try {
                    Field campoEntidad = Actividad.class.getDeclaredField(fieldName);
                    campoEntidad.setAccessible(true);
                    campoEntidad.set(actividad, fieldValue);
                } catch (NoSuchFieldException | IllegalAccessException ex) {
                    
                }
            }
            return update(actividad);
        }
    
        // eliminar
        @DeleteMapping("/eliminar/{id}")
        public void deleteById(@PathVariable long id) {
            actividadService.deleteById(id);
        }
    
    }
