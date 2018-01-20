/**
 * Created by soola on 2017-10-07.
 */
import java.awt.*;
import javax.swing.*;
public class ImageTutorial extends JFrame
{
    private ImageIcon image1;
    private JLabel label1;

    ImageTutorial()
    {
        setLayout(new FlowLayout());

        image1 = new ImageIcon(getClass().getResource("spiral.png"));
        label1 = new JLabel(image1);
        add(label1);

    }

    public static void main(String[] args)
    {
        ImageTutorial gui = new ImageTutorial();
        gui.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        gui.setVisible(true);
    }

}
