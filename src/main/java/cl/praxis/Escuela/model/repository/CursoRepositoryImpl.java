package cl.praxis.Escuela.model.repository;

import cl.praxis.Escuela.model.dto.Curso;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CursoRepositoryImpl implements CursoRepository {

    JdbcTemplate template;

    public CursoRepositoryImpl(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Curso> findAll() {
        String query = "Select id, name, description from curso";
        return template.query(query, new BeanPropertyRowMapper<>(Curso.class));
    }

    @Override
    public Curso findById(int id) {
        String query = "Select id, name, description from curso WHERE id = ?";
        return template.queryForObject(query, new BeanPropertyRowMapper<>(Curso.class), id);
    }

    @Override
    public boolean save(Curso curso) {
        String query = "Insert into curso (name, description) values (?, ?)";
        try {
            template.update(query, curso.getName(), curso.getDescription());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Curso curso) {
        String query = "Update curso set name = ?, description = ? where id = ?";
        try {
            template.update(query, curso.getName(), curso.getDescription(), curso.getId());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(Curso curso) {
        String query = "Delete from curso where id = ?";
        try {
            template.update(query, curso.getId());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteById(int id) {
        String query = "Delete from curso where id = ?";
        try {
            template.update(query, id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
