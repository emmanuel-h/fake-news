package fr.octopus.technight.data;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class Teaser {

    private List<String> teasers = List.of("Checked news", "Vu sur BFM TV", "Alerte info", "Attention");

    public String getTeaser() {
        Random random = new Random();
        return teasers.get(random.nextInt(teasers.size())) + " : ";
    }
}
