package main.streams;

import java.util.Collection;

import static main.streams.utils.DevelopmentUtil.*;

public class DevelopingApplication {

    public static void main(String[] args) {

        var films = createFilms();
        var developers = createDevelopers();

        var develpingChart = films.stream()
                .map(f -> createDevelopingtimeForFilm(f, developers))
                .toList();

        print(develpingChart.stream().flatMap(Collection::stream).toList());
    }
}