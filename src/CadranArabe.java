import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class CadranArabe extends Analogique{

    CadranArabe(Chrono c, JFrame f) {
        super(c, f,"cadran_chiffres_arabes.jpg");
    }
}
