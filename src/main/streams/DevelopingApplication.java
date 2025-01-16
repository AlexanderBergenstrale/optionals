package main.streams;

import java.util.Collection;

import static main.streams.utils.DevelopmentUtil.*;

public class DevelopingApplication {

    public static void main(String[] args) {
        var developers = createDevelopers();

        // Kör metoden för att skapa filmer och streamar ut listan
        // för varje filmsort körs map för att producera ett resultat av filmsort,
        // de framkallare som passar och framkallningstid
        var develpingChart = createFilms().stream()
                .map(f -> createDevelopingtimeForFilm(f, developers))
                .toList();

        print(develpingChart.stream().flatMap(Collection::stream).toList());
    }
}