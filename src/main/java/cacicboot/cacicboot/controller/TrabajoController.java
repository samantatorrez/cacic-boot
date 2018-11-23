package cacicboot.cacicboot.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cacicboot.cacicboot.service.TrabajoService;
import cacicboot.cacicboot.dto.TrabajoDTO;
import cacicboot.cacicboot.entity.Trabajo;

@RestController
@RequestMapping("trabajo")
public class TrabajoController {
	@Autowired
	TrabajoService trabajoService;

    @GetMapping( "/autor/{idAutor}")
    public String getTrabajos(@PathVariable(value ="idAutor") Integer idAutor) {
        return trabajoService.obtenerListaDeTrabajosPorAutor(idAutor).toString();
    }
}

