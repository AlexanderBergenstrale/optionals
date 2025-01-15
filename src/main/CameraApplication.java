package main;

import main.camera.Camera;

public class CameraApplication {
    static final String FUJICA = "Fujica";
    static final String NIKON = "Nikon";

    public static void main(String[] args) {

        // Skriver bara ut om det finns en kamera i optional:en
        var foundCamera = Camera.findCamera(FUJICA);
        foundCamera.ifPresent(x -> System.out.println("First: " + x));
        // annars händer inget
        var foundOtherCamera = Camera.findCamera(NIKON);
        foundOtherCamera.ifPresent(x -> System.out.println("Second: " + x));

        // Om första kameran ej finns försöker vi returnera den andra kameran
        // finns inte den heller kastar vi exception
        var thisCameraExists = foundOtherCamera.orElse(foundCamera.orElseThrow());
        System.out.println("Third: " + thisCameraExists);

        // Vi kör filter på en optional för att bara skriva ut den om den är analog
        foundCamera
                .filter(Camera::isAnalog)
                .ifPresent(x -> System.out.println("Fourth: " + x));
        // annars händer inget även om det inte ens finns en kamera i vår optional
        foundOtherCamera
                .filter(Camera::isAnalog)
                .ifPresent(x -> System.out.println("Fifth: " + x));

        // Även fast första filtret ger 0 träffar fortsätter programmet, nullcheck behövs alltså ej
        foundCamera
                .filter(c -> c.getShots() < 5)
                .filter(Camera::isAnalog)
                .ifPresent(x -> System.out.println("Sixth: " + x));
    }
}