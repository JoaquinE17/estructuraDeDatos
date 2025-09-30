import java.io.IOException;

public class LimpiarPantalla {
    public static void limpiar() {
        try {
            String sistemaOperativo = System.getProperty("os.name").toLowerCase();

            if (sistemaOperativo.contains("windows")) {
                // Ejecutar comando "cls" para Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Ejecutar comando "clear" para Linux/Mac
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("No se pudo limpiar la consola.");
        }
    }
}
