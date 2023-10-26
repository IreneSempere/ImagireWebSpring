package com.irene_sempere.hibernate.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/")
    public String mostrarPagina(Model model) {
        return "index";
    }
}
