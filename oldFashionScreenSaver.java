import javax.swing.*;
import java.awt.*;

public class oldFashionScreenSaver extends JFrame {

    Image dvd = Toolkit.getDefaultToolkit().getImage("images/dvd.png");
    Image black = Toolkit.getDefaultToolkit().getImage("images/black.jpg");  //lazy load

    double x = 100;
    double y = 100;
    double degree = 3.14 / 3;   //60 degree

    public void paint(Graphics g) {
        //System.out.println("Window has been drawn");
        g.drawImage(black,0,0,null);
        g.drawImage(dvd,(int)x,(int)y,null);

        x = x + 10 * Math.cos(degree);
        y = y + 10 * Math.sin(degree);

        if(y > 560 || y < 20) {
            degree = - degree;
        }
        if(x < 0 || x > 750) {
            degree = 3.14 - degree;
        }
    }

    void launchFrame(){
        setSize(800, 600);
        setLocation(100, 100);   //top left corner's location
        setVisible(true);

        //keep drawing the images
        while(true) {
            repaint();
            try{
                Thread.sleep(30);    //40ms
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        oldFashionScreenSaver saver = new oldFashionScreenSaver();
        saver.launchFrame();
    }
}
