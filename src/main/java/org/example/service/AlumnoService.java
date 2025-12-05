package org.example.service;

import org.example.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.beans.Transient;

public class AlumnoService {

    private final AlumnoRepository alumnoRepository;

    @Autowired
    public AlumnoService(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }
    @Transactional
}
