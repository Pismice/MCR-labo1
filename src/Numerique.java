import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Numerique extends AffichageTemporel{

    Numerique(Chrono c){
        super(c);
        JLabel infos = new JLabel(chrono.getName() + ": " + hour + "h " + min + "m " + sec + "s");
        this.add(infos);
    }
    public void update(){
        super.update();
    }
}
