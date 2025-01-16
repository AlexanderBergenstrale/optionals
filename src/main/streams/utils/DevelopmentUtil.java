package main.streams.utils;

import lombok.experimental.UtilityClass;
import main.streams.analogue.models.Developer;
import main.streams.analogue.models.Developingtime;
import main.streams.analogue.models.Film;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class DevelopmentUtil {

    private final Double THOUSAND = 1000d;

    public static List<Film> createFilms() {
        var filmList = new ArrayList<Film>();
        filmList.add(Film.builder()
                .make("Fujifilm")
                .name("Velvia")
                .iso(100)
                .color(true)
                .build());

        filmList.add(Film.builder()
                .make("Fujifilm")
                .name("Fujichrome")
                .iso(200)
                .color(true)
                .build());

        filmList.add(Film.builder()
                .make("Fujifilm")
                .name("Fujicolor F-II")
                .iso(50)
                .color(true)
                .build());

        filmList.add(Film.builder()
                .make("Fujifilm")
                .name("Neopan 100 Acros II")
                .iso(200)
                .color(false)
                .build());

        filmList.add(Film.builder()
                .make("Kodak")
                .name("Ektachrome")
                .iso(100)
                .color(true)
                .build());

        filmList.add(Film.builder()
                .make("Kodak")
                .name("Portra")
                .iso(400)
                .color(true)
                .build());

        filmList.add(Film.builder()
                .make("Kodak")
                .name("Colorplus")
                .iso(400)
                .color(true)
                .build());

        filmList.add(Film.builder()
                .make("Kodak")
                .name("Gold")
                .iso(200)
                .color(true)
                .build());


        filmList.add(Film.builder()
                .make("Kodak")
                .name("Tri-x")
                .iso(400)
                .color(false)
                .build());

        filmList.add(Film.builder()
                .make("Lomography")
                .name("LomoPurple")
                .iso(400)
                .color(true)
                .build());

        filmList.add(Film.builder()
                .make("Lomography")
                .name("Lomochrome color '92 sun-kissed")
                .iso(400)
                .color(true)
                .build());

        filmList.add(Film.builder()
                .make("Lomography")
                .name("Lady Grey")
                .iso(400)
                .color(false)
                .build());

        filmList.add(Film.builder()
                .make("Lomography")
                .name("Babylon")
                .iso(50)
                .color(false)
                .build());

        return filmList;
    }

    public static List<Developer> createDevelopers() {
        var developers = new ArrayList<Developer>();

        developers.add(Developer.builder()
                .name("Rodinal")
                .bestBefore(LocalDate.of(2025, 6, 15))
                .mixture(25)
                .color(false)
                .build());

        developers.add(Developer.builder()
                .name("Rodinal")
                .bestBefore(LocalDate.of(2027, 6, 15))
                .mixture(50)
                .color(false)
                .build());

        developers.add(Developer.builder()
                .name("Rodinal")
                .bestBefore(LocalDate.of(2025, 8, 15))
                .mixture(100)
                .color(false)
                .build());

        developers.add(Developer.builder()
                .name("D-96")
                .bestBefore(LocalDate.of(2025, 6, 16))
                .mixture(20)
                .color(false)
                .build());

        developers.add(Developer.builder()
                .name("Neutol")
                .bestBefore(LocalDate.of(2024, 6, 20))
                .mixture(10)
                .color(false)
                .build());

        developers.add(Developer.builder()
                .name("Neutol")
                .bestBefore(LocalDate.of(2026, 6, 20))
                .mixture(10)
                .color(false)
                .build());

        developers.add(Developer.builder()
                .name("C-tec")
                .bestBefore(LocalDate.of(2026, 6, 20))
                .mixture(30)
                .color(true)
                .build());

        developers.add(Developer.builder()
                .name("C-tec")
                .bestBefore(LocalDate.of(2025, 6, 20))
                .mixture(40)
                .color(true)
                .build());

        return developers;
    }


    public static List<Developingtime> createDevelopingtimeForFilm(Film film, List<Developer> developers) {

        // strömmar listan och filtrerar bort alla framkallare av fel sort (färg/BW)
        // och även de framkallare som gått över bäst före
        // mappar slutligen film och framkallare till en developingtime
        return developers.stream()
                // .filter producerar en ny stream baserat på
                // ett Predicate, som tar en "sak", i detta fall en Developer
                // och returnerar den om den stämmer med kontrollen
                .filter(d -> d.color() == film.color())
                .filter(d -> d.bestBefore().isAfter(LocalDate.now()))
                // .map tar in en Function, dvs den tar emot en sak
                // och transformerar om den till något nytt (eller samma)
                // i detta fall tar den emot en Developer
                // och skapar en Developingtime
                // med d (developern) och film som input till buildermetoden
                .map(d -> Developingtime.builder()
                        .developer(d)
                        .film(film)
                        .minutes((film.iso() * d.mixture()) / THOUSAND)
                        .build()).toList();
    }


    public static void print(List<Developingtime> input) {
        // .forEach tar en consumer som tar emot en sak och returnerar ingenting
        // i detta fall tar den emot en Developingtime och skriver ut den
        input.forEach(dt ->
                System.out.println(
                        "Developingtime for film: " + dt.film().make()
                                + " - " + dt.film().name()
                                + " iso: " + dt.film().iso()
                                + " developer=" + dt.developer().name()
                                + ", 1:" + dt.developer().mixture()
                                + ", minutes=" + dt.minutes()
                ));
    }
}
