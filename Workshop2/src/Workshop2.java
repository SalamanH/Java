
import java.util.Date;

import static java.lang.StrictMath.sqrt;
import java.util.Scanner;


/**
 * Created by soola on 2017-12-04.
 */
//

class IllegalTriangleException extends Exception {
    public static final long serialVersionUID = 42L;
    
    @Override
     public String getMessage(){
        return "illegal Triangle, sum of any two sides must be greater than the other side";
    }
}
class IllegalTriangle{
    public static boolean isLegal(double s1, double s2, double s3) {
        double[] side = {s1, s2, s3};
        double temp = 0;
        int n = side.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (side[j - 1] < side[j]) {
                    temp = side[j - 1];
                    side[j - 1] = side[j];
                    side[j] = temp;
                }

            }
        }
        boolean t = side[0] > (side[1]+side[2])? false : true;
        return t;
    }
}
abstract class GeometricObject{
    private String colour;
    private boolean filled;
    private Date dateCreated;

    GeometricObject(){
        colour = "no colour";
        filled = false;
        dateCreated = new Date();
    }
    GeometricObject(String _colour, boolean _filled){
        colour = _colour;
        filled = _filled;
    }
    public String getColor(){ return colour;}
    public void setColor(String _colour){ colour = _colour;}
    public boolean isFilled(){ return filled;}
    public void setFilled(boolean _filled){filled = _filled;}
    public Date getDateCreated(){ return dateCreated;}
    public String toString(){
        return "Filled: " + filled + (filled? "\nColour: " + colour : "") + "\n";
    }
    abstract public double getArea();
    abstract public double getPerimeter();
}
class Triangle extends GeometricObject{
    private double side1;
    private double side2;
    private double side3;

    Triangle(){side1=side2=side3=1;}
    Triangle (double _side1, double _side2, double _side3) {



            side1 = _side1;
            side2 = _side2;
            side3 = _side3;
        }

    public double getArea() {
        double s = 0.5 * (side1 + side2 + side3);
        return sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    public double getside1() {
        return side1;
    }

    public double getside2() {
        return side2;
    }

    public double getside3() {
        return side3;
    }

    public String toString() {
        return super.toString() + "Aea: " + getArea() + "\nPerimeter: " + getPerimeter() + "\nTriangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
    }

}

public class Workshop2 {
        public static void main(String[] args){
            double s1,s2,s3;
            String colour; 
            boolean filled,legalTriangle = true;
            

            Triangle triangle = null;
            Scanner dis=new Scanner(System.in);
            Scanner reader = new Scanner(System.in);
            dis.useDelimiter("\\D");
            System.out.print("Enter 3 sides for the triangle separated by spaces: ");
            do {
                legalTriangle = true;
                s1 = dis.nextDouble();
                s2 = dis.nextDouble();
                s3 = dis.nextDouble();

                try {
                    if (IllegalTriangle.isLegal(s1, s2, s3)) {
                        triangle = new Triangle(s1, s2, s3);
                    } else {
                        legalTriangle = false;

                        throw(new IllegalTriangleException());
                    }
                }catch(IllegalTriangleException e){
                    System.out.println(e.getMessage());
                    System.out.print("Enter 3 sides where the largest size is smaller than the sum of the remaining 2 sides: ");
                }

            }while(!legalTriangle);


            System.out.print("\nEnter if triangle filled(true or false): ");
            filled = reader.nextBoolean();

            if(filled){ // can condense contents into one method
                System.out.print("\nEnter colour of triangle: ");
                colour = reader.next();
                triangle.setFilled(filled);
                triangle.setColor(colour);

            }

            System.out.println(triangle);

        }
}



