package cl.praxis.Escuela.model.repository;

import cl.praxis.Escuela.model.dto.Alumno;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlumnosRepositoryImpl implements AlumnosRepository {

    JdbcTemplate template;

    public AlumnosRepositoryImpl(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Alumno> findAll() {
        String query = "Select id, name from alumno";
        return template.query(query, new BeanPropertyRowMapper<>(Alumno.class));
    }

    @Override
    public Alumno findById(int id) {
        String query = "Select id, name from alumno WHERE id = ?";
        return template.queryForObject(query, new BeanPropertyRowMapper<>(Alumno.class), id);
    }

    @Override
    public boolean save(Alumno alumno) {
        String query = "INSERT INTO alumno (name) VALUES ( ?)";
        try {
            template.update(query, alumno.getName());
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean update(Alumno alumno) {
        String query = "UPDATE alumno SET name = ? WHERE id = ?";
        try {
            template.update(query, alumno.getName(), alumno.getId());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(Alumno alumno) {
        String query = "DELETE FROM alumno WHERE id = ?";
        try {
            template.update(query, alumno.getId());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteById(int id) {
        String query = "DELETE FROM alumno WHERE id = ?";
        try {
            template.update(query, id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
