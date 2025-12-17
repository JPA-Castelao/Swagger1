package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.example.model.Alumno;
import org.example.model.Alumno;
import org.example.model.Titor;
import org.example.repository.AlumnoRepository;
import org.example.repository.TitorRepository;
import org.example.service.AlumnoService;
import org.example.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(org.example.controller.RestAlumno.MAPPING)
public class RestAlumno {


    public static final String MAPPING = "/alumno";

    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private TitorRepository titorRepository;
    @Autowired
    private AlumnoService alumnoService;


    @Operation(summary = "Método que saúda")
    @PostMapping("/saudo")
    public String saudo() {
        return "Boas";
    }

    @Operation(summary = "Crear un novo alumno")
    @PostMapping("/alumnos")
    public Alumno crearAlumno(@RequestBody Alumno alumno) {
        return alumnoService.creaOuActualizaAlumno(alumno);
    }

    @Operation(summary = "Obter todos os alumnos")
    @GetMapping("/alumnos")
    public List<Alumno> obtenerAlumnos() {
        return alumnoService.obtenerTodosOsAlumnos();
    }

    @Operation(summary = "Obter alumno por ID")
    @GetMapping("/alumno/{id}")
    public ResponseEntity<Alumno> obtenerAlumnoPorId(@PathVariable Long id) {
        Optional<Alumno> alumno = alumnoService.obtenerAlumnoPorId(id);
        return alumno.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Actualizar un alumno")
    @PutMapping("/alumno/{id}")
    public ResponseEntity<Alumno> crearOuActualizarAlumno(@PathVariable Long id, @RequestBody Alumno AlumnoDetails) {
        Optional<Alumno> AlumnoOptional = alumnoService.obtenerAlumnoPorId(id);
        if (AlumnoOptional.isPresent()) {
            Alumno alumno = AlumnoOptional.get();
            alumno.setNome(AlumnoDetails.getNome());
            alumno.setApelidos(AlumnoDetails.getApelidos());
            Alumno AlumnoActualizado = alumnoService.creaOuActualizaAlumno(alumno);
            return ResponseEntity.ok(AlumnoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Eliminar un Alumno")
    @DeleteMapping("/Alumno/{id}")
    public ResponseEntity<Void> eliminarAlumno(@PathVariable Long id) {
        if (alumnoRepository.existsById(id)) {
            alumnoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}





