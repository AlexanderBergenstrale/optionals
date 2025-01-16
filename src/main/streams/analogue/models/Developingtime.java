package main.streams.analogue.models;

import lombok.Builder;
import lombok.Data;

@Builder
public record Developingtime(Film film, Developer developer, Double minutes) {
}
