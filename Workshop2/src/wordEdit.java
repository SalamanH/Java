import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by soola on 2017-12-08.
 */
public class wordEdit {

    public static void main(String[] args){
        Scanner x = null;
        try {
             x = new Scanner(new File("C:/Users/soola/Desktop/school/JAC444- Introduction to Java for C++ Programmers/Workshop2/src/hangman.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        try {
//            FileOutputStream file = new FileOutputStream("C:/Users/soola/Desktop/school/JAC444- Introduction to Java for C++ Programmers/Workshop2/src/hangman.txt");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

//        Reader r = new InputStreamReader(System.in);
//        FileWriter r = null;
//        try {
////             r = new FileWriter("C:/Users/soola/Desktop/school/JAC444- Introduction to Java for C++ Programmers/Workshop2/src/hangman.txt");
//            r = new FileWriter("C:/Users/soola/Desktop/school/JAC444- Introduction to Java for C++ Programmers/Workshop2/src/h.txt");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        BufferedWriter br = new BufferedWriter(r);


        ArrayList<String> word_DB = new ArrayList<>();
        x.useDelimiter("\\s+");
        while(x.hasNext())
            word_DB.add(x.next());
//String s = "";
//        for (int i = 0; i < word_DB.size(); i++){
//            try {
//                s = (String)word_DB.get(i) + " ";
//                br.write(s);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }


        File inputFile = new File("C:/Users/soola/Desktop/school/JAC444- Introduction to Java for C++ Programmers/Workshop2/src/hangman.txt");
        File outputFile = new File("C:/Users/soola/Desktop/school/JAC444- Introduction to Java for C++ Programmers/Workshop2/src/h.txt");

        FileReader in = null;
        FileWriter out = null;
        int c = 0;

        try {
            in = new FileReader(inputFile);
            try {
                out = new FileWriter(outputFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
           // String s = "";


//            try {
//                while ((c = in.read()) != -1)
//                    try {
//                    s = c + " ";
//                        out.write(c);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            for(int i = 0; i<word_DB.size(); i++){
                try {
                    out.write((word_DB.get(i) + " ").toLowerCase());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File: " + args[0] + " does not exist");
            System.exit(0);
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (out != null)
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

}
