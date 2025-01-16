package main.streams.analogue.models;

import lombok.Builder;

@Builder
public record Film(String make, String name, int iso, boolean color) {
}