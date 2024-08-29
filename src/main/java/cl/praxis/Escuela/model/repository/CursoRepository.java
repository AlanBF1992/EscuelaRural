package cl.praxis.Escuela.model.repository;

import cl.praxis.Escuela.model.dto.Curso;

import java.util.List;

public interface CursoRepository {
    List<Curso> findAll();
    Curso findById(int id);
    boolean save(Curso curso);
    boolean update(Curso curso);
    boolean delete(Curso curso);
    boolean deleteById(int id);
}
