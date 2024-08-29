package cl.praxis.Escuela.model.dto;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Alumno")
@Table(name = "alumno")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(nullable = false, length = 20)
    private String name;

    public Alumno() {}

    public Alumno(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "alumno_curso",
            joinColumns = @JoinColumn(name = "alumno_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private List<Curso> cursos = new ArrayList<Curso>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public void addCurso(Curso curso) {
        cursos.add(curso);
        curso.getAlumnos().add(this);
    }

    public void removeCurso(Curso curso) {
        cursos.remove(curso);
        curso.getAlumnos().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alumno)) return false;
        return id == ((Alumno) o).getId();
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
