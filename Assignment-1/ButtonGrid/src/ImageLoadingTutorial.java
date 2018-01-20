/**
 * Created by soola on 2017-10-07.
 */
import java.applet.Applet;
import java.awt.*;
import java.net.URL;

public class ImageLoadingTutorial extends Applet
{

    private Image  spiral = null;
    public void paint(Graphics g)
    {
        this.setSize(680, 480);
        if ( spiral == null)
            spiral = getImage("spiral.png");
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(spiral, 25, 50 ,25, 25, this);
    }
    public Image getImage(String path)
    {
        Image tempImage = null;
        try
        {
            URL imageURL = ImageLoadingTutorial.class.getResource(path);
            tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
        }
        catch(Exception e)
        {
            System.out.println("An error occured - " + e.getMessage());
        }
        return tempImage;
    }
   /*public static void main(String[] args){
        Graphics g= null;
        ImageLoadingTutorial I1 = new ImageLoadingTutorial();
        I1.paint(g);
    }*/
}
