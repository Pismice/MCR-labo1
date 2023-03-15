import java.awt.*;

public class CadranArabe extends Analogique {
    /**
     * Constructeur qui transmet le filename de l'image de l'horloge
     *
     * @param c le chrono à ratacher
     */
    CadranArabe(Chrono c) {
        super(c, "cadran_chiffres_arabes.jpg", Color.red, Color.blue); /* Filename du cadran arabe */
    }
}
