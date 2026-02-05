package org.example.taller1_microapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Taller1MicroapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(Taller1MicroapiApplication.class, args);
        System.out.println("\n=== API INICIADA ===");
        System.out.println("Servidor corriendo en: http://localhost:8080");
        System.out.println("\nPrueba los endpoints:");
        System.out.println("POST http://localhost:8080/estudiantes");
        System.out.println("GET http://localhost:8080/estudiantes\n");
    }


}
