import javax.swing.*;
import java.awt.*;

public class Analogique extends AffichageTemporel{

    Analogique(Chrono c,String filename){
        super(c);
        image = Toolkit.getDefaultToolkit().getImage(filename);
        image = image.getScaledInstance(200, 200, Image.SCALE_AREA_AVERAGING);
        update();
    }
    Image image;
    @Override
    public void update(){
        super.update();
        repaint();
    }

    @Override
   public void paintComponent(Graphics g){
        g.drawImage(image, 0, 0, this);
        g.drawString(chrono.getName(), 75,100);
        drawAiguille(g, Color.red, sec * 6, 70, 2);
        drawAiguille(g, Color.blue, min * 6, 50, 4);
        drawAiguille(g, Color.black, hour * 30, 30, 6);
    }
    private void drawAiguille(Graphics g, Color c, double a, int lo, int la){
        int coord = 105;
        a %= 360;
        a *= Math.PI / 180;
        System.out.println(" Angles : " + a);
        double  x = Math.sin(a)*lo,
                y = -Math.cos(a)*lo;
        g.setColor(c);
        ((Graphics2D)g).setStroke(new BasicStroke(la));
        g.drawLine(coord, coord,(int) x+coord,(int) y+coord);
    }
}
