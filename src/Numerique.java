import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Numerique extends AffichageTemporel{

    Numerique(Chrono c){
        super(c);
        infos = new JLabel();
        update();
        this.add(infos);
    }
    private final JLabel infos;
    @Override
    public void update(){
        super.update();
        infos.setText(chrono.getName() + ": " + hour + "h " + min + "m " + sec + "s");
    }
}
