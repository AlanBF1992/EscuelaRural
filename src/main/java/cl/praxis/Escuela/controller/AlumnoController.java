package cl.praxis.Escuela.controller;

import cl.praxis.Escuela.model.dto.Alumno;
import cl.praxis.Escuela.model.service.AlumnoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class AlumnoController {

    AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/alumnos")
    public String alumnos(Model model) {
        model.addAttribute("alumnos",alumnoService.findAll());
        return "alumnos";
    }

    @GetMapping("/alumnos/add")
    public String addAlumno() {
        return "alumnoAdd";
    }

    @PostMapping("/alumnos/add")
    public String addAlumno(Alumno alumno) {
        alumnoService.save(alumno);
        return "redirect:/alumnos";
    }

    @GetMapping(value = "/alumnos/update", params = "id")
    public String updateAlumno(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("alumno",alumnoService.findById(id));
        return "alumnoUpdate";
    }

    @PostMapping(value = "/alumnos/update")
    public String updateAlumno(Alumno alumno) {
        alumnoService.update(alumno);
        return "redirect:/alumnos";
    }

    @PostMapping(value = "/alumnos/delete", params = "id")
    public String deleteAlumno(@RequestParam("id") int id) {
        alumnoService.deleteById(id);
        return "redirect:/alumnos";
    }
}
