package cl.praxis.Escuela.model.service;

import cl.praxis.Escuela.model.dto.Alumno;

import java.util.List;

public interface AlumnoService {
    List<Alumno> findAll();
    Alumno findById(int id);
    boolean save(Alumno alumno);
    boolean update(Alumno alumno);
    boolean delete(Alumno alumno);
    boolean deleteById(int id);
}
