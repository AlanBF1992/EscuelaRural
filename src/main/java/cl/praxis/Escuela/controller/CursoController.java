package cl.praxis.Escuela.controller;

import cl.praxis.Escuela.model.dto.Alumno;
import cl.praxis.Escuela.model.dto.Curso;
import cl.praxis.Escuela.model.service.CursoServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CursoController {

    CursoServiceImpl claseService;

    public CursoController(CursoServiceImpl claseService) {
        this.claseService = claseService;
    }

    @GetMapping("/cursos")
    public String alumnos(Model model) {
        model.addAttribute("clases",claseService.findAll());
        return "cursos";
    }

    @GetMapping("/cursos/add")
    public String addCurso() {
        return "cursoAdd";
    }

    @PostMapping("/cursos/add")
    public String addCurso(Curso curso) {
        claseService.save(curso);
        return "redirect:/cursos";
    }

    @GetMapping(value = "/cursos/update", params = "id")
    public String updateCurso(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("curso", claseService.findById(id));
        return "cursoUpdate";
    }

    @PostMapping("/cursos/update")
    public String updateCurso(Curso curso) {
        claseService.update(curso);
        return "redirect:/cursos";
    }

    @PostMapping(value = "/cursos/delete", params = "id")
    public String deleteCurso(@RequestParam("id") int id) {
        claseService.deleteById(id);
        return "redirect:/cursos";
    }
}