package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.example.model.Titor;
import org.example.repository.TitorRepository;
import org.example.service.TitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(RestTitor.MAPPING)
public class RestTitor {


    public static final String MAPPING = "/titor";

    @Autowired
    private TitorRepository titorRepository;
    @Autowired
    private TitorService titorService;

    @Operation(summary = "Crear un novo titor")
    @PostMapping("/titores")
    public Titor crearTitor(@RequestBody Titor titor) {
        return titorService.creaOuactualizaTitor(titor);
    }

    @Operation(summary = "Obter todos os titores")
    @GetMapping("/titores")
    public List<Titor> obtenerTitores() {
        return titorService.obtenerTodosOsTitores();
    }


    @Operation(summary = "Método que saúda")
    @PostMapping("/saudo")
    public String saudo() {
        return "Boas";
    }


    @Operation(summary = "Obter titor por ID")
    @GetMapping("/titor/{id}")
    public ResponseEntity<Titor> obtenerTitorPorId(@PathVariable Long id) {
        Optional<Titor> titor = titorService.obtenerTitorPorId(id);
        return titor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Actualizar un titor")
    @PutMapping("/titor/{id}")
    public ResponseEntity<Titor> actualizarTitor(@PathVariable Long id, @RequestBody Titor titorDetails) {
        Optional<Titor> titorOptional = titorService.obtenerTitorPorId(id);
        if (titorOptional.isPresent()) {
            Titor titor = titorOptional.get();
            titor.setNome(titorDetails.getNome());
            titor.setApelidos(titorDetails.getApelidos());
            Titor titorActualizado = titorService.creaOuactualizaTitor(titor);
            return ResponseEntity.ok(titorActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Eliminar un titor")
    @DeleteMapping("/titor/{id}")
    public ResponseEntity<Void> eliminarTitor(@PathVariable long id) {
        if (titorRepository.existsById(id)) {
            titorRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}



