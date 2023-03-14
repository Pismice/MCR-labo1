import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class CadranArabe extends Analogique{

    CadranArabe(Chrono c) {
        super(c, "cadran_chiffres_arabes.jpg");
    }
}
