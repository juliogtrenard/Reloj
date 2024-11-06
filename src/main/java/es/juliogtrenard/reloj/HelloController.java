package es.juliogtrenard.reloj;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.time.LocalTime;
import java.util.*;

/**
 * Clase que maneja la ventana principal que muestra el reloj.
 */
public class HelloController implements Initializable {
    /**
     * Hora
     */
    @FXML
    private ImageView hora1;

    /**
     * Hora
     */
    @FXML
    private ImageView hora2;

    /**
     * Minuto
     */
    @FXML
    private ImageView min1;

    /**
     * Minuto
     */
    @FXML
    private ImageView min2;

    /**
     * Segundo
     */
    @FXML
    private ImageView seg1;

    /**
     * Segundo
     */
    @FXML
    private ImageView seg2;

    /**
     * HashMap que dependiendo de la clave, devuelve el número correspondiente
     */
    public static final HashMap<Integer,String> NUMBERS = new HashMap<>();
    static {
        NUMBERS.put(0,"ZERO");
        NUMBERS.put(1,"ONE");
        NUMBERS.put(2,"TWO");
        NUMBERS.put(3,"THREE");
        NUMBERS.put(4,"FOUR");
        NUMBERS.put(5,"FIVE");
        NUMBERS.put(6,"SIX");
        NUMBERS.put(7,"SEVEN");
        NUMBERS.put(8,"EIGHT");
        NUMBERS.put(9,"NINE");
    }

    /**
     * Devuelve la imagen del número dado
     *
     * @param n número
     * @return imagen
     */
    private Image getImage(int n) {
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream("/es/juliogtrenard/reloj/img/" + NUMBERS.get(n) + ".png")));
    }

    /**
     * Cuando se inicia la ventana.
     *
     * @param url la url
     * @param resourceBundle los recursos
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Timer timer = new Timer("RELOJ");
        timer.scheduleAtFixedRate(new TimerTask() {
            /**
             * Se ejecuta cuando se inicia la actividad
             */
            @Override
            public void run() {
                LocalTime actual = LocalTime.now();
                // Horas
                int hora = actual.getHour();
                int h1 = hora / 10;
                hora1.setImage(getImage(h1));
                int h2 = hora % 10;
                hora2.setImage(getImage(h2));
                // Minutos
                int minuto = actual.getMinute();
                int m1 = minuto / 10;
                min1.setImage(getImage(m1));
                int m2 = minuto % 10;
                min2.setImage(getImage(m2));
                // Segundos
                int segundo = actual.getSecond();
                int s1 = segundo / 10;
                seg1.setImage(getImage(s1));
                int s2 = segundo % 10;
                seg2.setImage(getImage(s2));
            }
        }, 0, 1000);
    }

}