package org.example.taller1_microapi.controller;


import org.example.taller1_microapi.model.Estudiante;
import org.example.taller1_microapi.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @PostMapping
    public ResponseEntity<?> registrarEstudiante(@RequestBody Estudiante estudiante) {
        try {
            Estudiante estudianteRegistrado = estudianteService.registrarEstudiante(estudiante);

            Map<String, Object> response = new HashMap<>();
            response.put("mensaje", "Estudiante registrado exitosamente");
            response.put("estudiante", estudianteRegistrado);

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (IllegalArgumentException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    /**
     * GET /estudiantes - Lista todos los estudiantes
     */
    @GetMapping
    public ResponseEntity<List<Estudiante>> listarEstudiantes() {
        List<Estudiante> estudiantes = estudianteService.listarEstudiantes();
        return ResponseEntity.ok(estudiantes);
    }
}
