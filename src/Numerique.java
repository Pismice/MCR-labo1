import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Numerique extends AffichageTemporel{
    /**
     * Constructeur pour definir le texte à afficher dans un jlabel
     * @param c le chronometre relier à cet affichage
     */
    Numerique(Chrono c){
        super(c);
        infos = new JLabel();
        update();
        this.add(infos);
    }
    private final JLabel infos; //Label dans lequel est afficher le texte (Nom + Heure)
    @Override
    public void update(){
        super.update();
        infos.setText(chrono.getName() + ": " + hour + "h " + min + "m " + sec + "s");
    }
}
