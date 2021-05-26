package de.afp.restApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "")
public class Controller {

    @GetMapping(path = "/index")
    public String index() {
        return "Hallo Welt!";
    }
}
