import java.awt.*;
/**
 * Class qui implemente des horloges de types Analogique avec cadrab romain
 * @author Jeremie Santoro & Théo Coutaudier
 */
public class CadranRomain extends Analogique {
    /**
     * Constructeur qui transmet le filename de l'image de l'horloge
     *
     * @param c le chrono à ratacher
     */
    CadranRomain(Chrono c) {
        super(c, "cadran_chiffres_romains.jpg", Color.orange, Color.gray); /*Filename du cadran romain */
    }
}
