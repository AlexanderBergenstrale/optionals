package main.streams.analogue.models;

import lombok.Builder;

// Ett Record skapar automatiskt konstruktorer och getters och lite annat
// baserat på de parametrar man specificerar inom parenteserna
// Ett record är immutable och kan inte ändras när det skapats
@Builder
public record Film(String make, String name, int iso, boolean color) {
}