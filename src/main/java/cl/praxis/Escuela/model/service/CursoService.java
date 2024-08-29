package cl.praxis.Escuela.model.service;

import cl.praxis.Escuela.model.dto.Curso;

import java.util.List;

public interface CursoService {
    List<Curso> findAll();
    Curso findById(int id);
    boolean save(Curso curso);
    boolean update(Curso curso);
    boolean delete(Curso curso);
    boolean deleteById(int id);
}
