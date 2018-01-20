import javax.swing.*;
import java.awt.*;

public class ButtonGrid {
    private ImageIcon image1  = new ImageIcon(getClass().getResource("queen.png"));

    JFrame frame=new JFrame(); //creates frame
    JButton[][] grid; //names the grid of buttons

    public ButtonGrid(int width, int length){ //constructor
        frame.setLayout(new GridLayout(width,length)); //set layout
        grid=new JButton[width][length]; //allocate the size of grid

        for(int y=0; y<length; y++){
            for(int x=0; x<width; x++){

                //grid[x][y]=new JButton("("+x+","+y+")");
                if ( (x==2 && y ==0) || (x==5 && y==1) || (x==3 && y==2) || (x==0 && y==3 ) || (x==7 && y==4 ) || (x==4 && y==5 ) || (x==6 && y==6 ) || (x==1 && y==7 ) )
                    grid[x][y]=new JButton(image1); //creates new button
                else
                    grid[x][y]=new JButton(); //creates new button

                //grid[x][y].setBackground(Color.decode("#D18B46"));
                if((x == y) || ( (x-y)%2==0) || ( (y-x)%2== 0))
                    grid[x][y].setBackground(Color.white);

                frame.add(grid[x][y]); //adds button to grid
            }
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); //sets appropriate size for frame
        frame.setVisible(true); //makes frame visible
    }
    public static void main(String[] args)
    {
        new ButtonGrid(8,8);//makes new ButtonGrid with 2 parameters
    }
}