package proyectodeinvestigacion.GRUPO2.controllers;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import proyectodeinvestigacion.GRUPO2.entities.Linea;
import proyectodeinvestigacion.GRUPO2.services.LineaService;

@RestController
@RequestMapping("api/linea")
@CrossOrigin("*")
@Tag(name = "Controlador de Linea (Tabla Linea_Investigacion)")
public class LineaController {

    @Autowired
    private LineaService lineaService;

    // crear
    // metod delimitador de acceso,tipo de dato que retorna,nombre del
    // metodo/funcion
    @PreAuthorize("hasAuthority('Linea_Crear')")
    @PostMapping("/crear")
    @Operation(summary = "Guarda una nueva linea de investigacion, requiere el permiso Linea_Crear")
    public Linea save(@RequestBody Linea entity) {
        return lineaService.save(entity);
    }

    // traer por id
    @PreAuthorize("hasAuthority('Linea_Leer')")
    @GetMapping("/listar/{id}")
    @Operation(summary = "Obtiene una linea de investigacion por su id, requiere el permiso Linea_Leer")
    public Linea findById(@PathVariable long id) {
        return lineaService.findById(id);
    }

    // traer todo
    @PreAuthorize("hasAuthority('Linea_LeerTodos')")
    @GetMapping("/listar")
    @Operation(summary = "Obtiene todas las lineas de investigacion, requiere el permiso Linea_LeerTodos")
    public List<Linea> findAll() {
        return lineaService.findAll();
    }

    // actualizar
    @PreAuthorize("hasAuthority('Linea_Actualizar')")
    @PutMapping("/actualizar")
    @Operation(summary = "Actualiza una linea de investigacion por su id, requiere el permiso Linea_Actualizar")
    public Linea update(@RequestBody Linea entity) {
        return lineaService.save(entity);
    }

    // actualizar parcial
    @PatchMapping("/actualizar/{id}")
    public Linea partialUpdate(@PathVariable long id, @RequestBody Map<String, Object> fields) {
        Linea linea = findById(id);
        for (Map.Entry<String, Object> field : fields.entrySet()) {
            String fieldName = field.getKey();
            Object fieldValue = field.getValue();
            try {
                Field campoEntidad = Linea.class.getDeclaredField(fieldName);
                campoEntidad.setAccessible(true);
                campoEntidad.set(linea, fieldValue);
            } catch (NoSuchFieldException | IllegalAccessException ex) {
                
            }
        }
        return update(linea);
    }

    // eliminar
    @PreAuthorize("hasAuthority('Linea_Eliminar')")
    @DeleteMapping("/eliminar/{id}")
    @Operation(summary = "Elimina una linea por su id, requiere el permiso Linea_Eliminar")
    public void deleteById(@PathVariable long id) {
        lineaService.deleteById(id);
    }

}