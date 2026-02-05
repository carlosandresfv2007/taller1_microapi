package org.example.taller1_microapi.service;


import jakarta.annotation.PostConstruct;
import org.example.taller1_microapi.model.Estudiante;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EstudianteService {

    private final Map<String, Estudiante> estudiantes = new HashMap<>();

    public Estudiante registrarEstudiante(Estudiante estudiante) {
        if (estudiantes.containsKey(estudiante.getId())) {
            throw new IllegalArgumentException(
                    "Ya existe un estudiante con el ID " + estudiante.getId()
            );
        }
        estudiantes.put(estudiante.getId(), estudiante);
        return estudiante;
    }

    public List<Estudiante> listarEstudiantes() {
        return new ArrayList<>(estudiantes.values());
    }
}