import java.awt.*;

public class Analogique extends AffichageTemporel{

    Analogique(Chrono c, String filename){
        super(c);
        image = Toolkit.getDefaultToolkit().getImage(filename);
        image = image.getScaledInstance(200, 200, Image.SCALE_AREA_AVERAGING);
        f.add(this);
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
        drawAiguille(g, Color.black, hour * 30 + 0.5 * min, 30, 6);
    }
    private void drawAiguille(Graphics g, Color c, double a, int lo, int la){
        int x = lo, y = lo, coord = 105;
        a %= 360;
        if(a == 0){
            x *= 0;
            y *= -1;
        }
        else if(a == 90){
            y *= 0;
        }
        else if(a == 180){
            x *= 0;
        }
        else if(a == 270){
            x *= -1;
            y *= 0;
        }
        else if (a > 0 && a < 90){
            x *= Math.cos(a);
            y *= Math.sin(a);
        }
        else if(a < 180){
            x *= Math.sin(a-90);
            y *= Math.cos(a-90);
        }
        else if(a < 270){
            x *= Math.cos(a-180);
            y *= Math.sin(a-180);
        }
        else if(a < 360){
            x *= Math.sin(a-270);
            y *= Math.cos(a-270);
        }
        g.setColor(c);
        ((Graphics2D)g).setStroke(new BasicStroke(la));

        g.drawLine(coord, coord,x+coord,y+coord);
    }
}
