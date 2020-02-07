package fr.octopus.technight.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/generation")
public class GenerationController {

    @GetMapping
    public ResponseEntity<String> generateNews() {
        System.out.println("ok");
        return ResponseEntity.ok("ok");
    }
}
