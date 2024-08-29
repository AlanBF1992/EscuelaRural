package cl.praxis.Escuela.model.service;

import cl.praxis.Escuela.model.dto.Alumno;
import cl.praxis.Escuela.model.repository.AlumnosRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoService{

    AlumnosRepository alumnosRepository;

    public AlumnoServiceImpl(AlumnosRepository alumnosRepository) {
        this.alumnosRepository = alumnosRepository;
    }

    @Override
    @Transactional
    public List<Alumno> findAll() {
        return alumnosRepository.findAll();
    }

    @Override
    @Transactional
    public Alumno findById(int id) {
        return alumnosRepository.findById(id);
    }

    @Override
    @Transactional
    public boolean save(Alumno alumno) {
        return alumnosRepository.save(alumno);
    }

    @Override
    @Transactional
    public boolean update(Alumno alumno) {
        return alumnosRepository.update(alumno);
    }

    @Override
    @Transactional
    public boolean delete(Alumno alumno) {
        return alumnosRepository.delete(alumno);
    }

    @Override
    @Transactional
    public boolean deleteById(int id) {
        return alumnosRepository.deleteById(id);
    }
}
