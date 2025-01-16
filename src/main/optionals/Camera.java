package main.optionals;

import lombok.Builder;
import lombok.Data;

import java.util.Optional;

@Builder
@Data
public class Camera {
    private String model;
    private boolean analog;
    private Integer shots;

    // Optionals ska bara returneras från metoder inte vara inparametrar
    public static Optional<Camera> findCamera(String nameOfModel) {
        var camera = Camera.builder()
                .analog(true)
                .model("Fujica")
                .shots(100)
                .build();

        var optionalCamera = Optional.of(camera);

        // Finns det en matchande kamera returneras den i en optional
        // annars returneras en tom optional
        return optionalCamera.filter(c -> c.model.equals(nameOfModel));
    }
}
