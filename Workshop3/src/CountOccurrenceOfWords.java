import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class CountOccurrenceOfWords {
    public static void main(String[] args) {
// Set text in a string
//        String text = "Good morning. Have a good class. " +
//                "Have a good visit. Have fun!";
        String text ="";
        String file="";
        Scanner x = null;

        for(String s: args){
            file += s;
        }
        try {
             x = new Scanner(new File("C:/Users/soola/Desktop/school/JAC444- Introduction to Java for C++ Programmers/Workshop3/src/"+ file));

        } catch (FileNotFoundException e) {

            System.out.println("File Not Found... Program Terminating...." + e);
        }
        while(x.hasNext())
           text += x.next() + " ";

// Create a TreeMap to hold words as key and count as value
        Map<String, Integer> map = new TreeMap<>();
        String[] words = text.split("[ \n\t\r.,;:!?(){}]");
        for (int i = 0; i < words.length; i++) {
            String key = words[i].toLowerCase();
            if (key.length() > 0) {
                if (!map.containsKey(key)) {
                    map.put(key, 1);
                }
                else {
                    int value = map.get(key);
                    value++;
                    map.put(key, value);
                }
            }

        }
        System.out.println(map);

    }}