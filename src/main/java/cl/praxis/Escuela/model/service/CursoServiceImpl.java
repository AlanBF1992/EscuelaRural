package cl.praxis.Escuela.model.service;

import cl.praxis.Escuela.model.dto.Curso;
import cl.praxis.Escuela.model.repository.CursoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {
    CursoRepository cursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    @Transactional
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    @Override
    @Transactional
    public Curso findById(int id) {
        return cursoRepository.findById(id);
    }

    @Override
    @Transactional
    public boolean save(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    @Transactional
    public boolean update(Curso curso) {
        return cursoRepository.update(curso);
    }

    @Override
    @Transactional
    public boolean delete(Curso curso) {
        return cursoRepository.delete(curso);
    }

    @Override
    @Transactional
    public boolean deleteById(int id) {
        return cursoRepository.deleteById(id);
    }

}
