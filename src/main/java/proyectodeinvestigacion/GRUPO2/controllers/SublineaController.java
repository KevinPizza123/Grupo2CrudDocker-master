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

import proyectodeinvestigacion.GRUPO2.entities.Sublinea;
import proyectodeinvestigacion.GRUPO2.services.SublineaService;
    
    @RestController
    @RequestMapping("api/sublinea")
    @CrossOrigin("*")
    public class SublineaController {
    
        @Autowired
        private SublineaService sublineaService;
    
        // crear
        // metod delimitador de acceso,tipo de dato que retorna,nombre del
        // metodo/funcion
        @PostMapping("/crear")
        public Sublinea save(@RequestBody Sublinea entity) {
            return sublineaService.save(entity);
        }
    
        // traer por id
        @GetMapping("/listar/{id}")
        public Sublinea findById(@PathVariable long id) {
            return sublineaService.findById(id);
        }
    
        // traer todo
        @GetMapping("/listar")
        public List<Sublinea> findAll() {
            return sublineaService.findAll();
        }
    
        // actualizar
        @PutMapping("/actualizar")
        public Sublinea update(@RequestBody Sublinea entity) {
            return sublineaService.save(entity);
        }
    
        // actualizar parcial
        @PatchMapping("/actualizar/{id}")
        public Sublinea partialUpdate(@PathVariable long id, @RequestBody Map<String, Object> fields) {
            Sublinea sublinea = findById(id);
            for (Map.Entry<String, Object> field : fields.entrySet()) {
                String fieldName = field.getKey();
                Object fieldValue = field.getValue();
                try {
                    Field campoEntidad = Sublinea.class.getDeclaredField(fieldName);
                    campoEntidad.setAccessible(true);
                    campoEntidad.set(sublinea, fieldValue);
                } catch (NoSuchFieldException | IllegalAccessException ex) {
                    
                }
            }
            return update(sublinea);
        }
    
        // eliminar
        @DeleteMapping("/eliminar/{id}")
        public void deleteById(@PathVariable long id) {
            sublineaService.deleteById(id);
        }
    
    }
