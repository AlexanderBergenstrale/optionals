package main.streams.analogue.models;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public record Developer(String name, LocalDate bestBefore, int mixture, boolean color) {
}
