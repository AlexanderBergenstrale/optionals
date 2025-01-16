package main.streams.analogue.models;

import lombok.Builder;

@Builder
public record Developingtime(Film film, Developer developer, Double minutes) {
}
