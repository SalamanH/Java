import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by soola on 2017-12-08.
 */
class readfile{

}
class Game{
    private ArrayList<String> word_DB = new ArrayList<>();
    private String word;
    private String word_shown;
    private String file_name;
    private Scanner x;
    private int correct;
    private int missed;
    FileReader file = null;

    private boolean openFile(){
        try {
            x = new Scanner(new File("C:/Users/soola/Desktop/school/JAC444- Introduction to Java for C++ Programmers/Workshop2/src/"+ file_name));
//             file = new FileReader("C:/Users/soola/Desktop/school/JAC444- Introduction to Java for C++ Programmers/Workshop2/src/"+ file_name);
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
            System.out.println("File Not Found... Program Terminating...." + e);
            return false;
        }
//        x.close();
        return true;
    }

    private void getWordList(){
        x.useDelimiter("\\s+");
        while(x.hasNext())
        word_DB.add(x.next());
//        for(String s : word_DB)
//            System.out.println(s);
    }

    private void getWord(){
        Random rand = new Random();
        int  n = rand.nextInt(word_DB.size());
        word = word_DB.get(n);
        word_shown = "*";
        for ( int i = 1; i < word.length(); i++)
            word_shown += "*";
    }
    private void check(char c){
        char[] temp_Word = new char[word.length()];
        boolean skip = false;
        boolean changed = false;
        for (int i = 0; i <word.length(); i++){
            if (word_shown.charAt(i) == c){
                skip = true;
            }
        }

        if(skip == false) {


            for (int i = 0; i < word.length(); i++) {
                temp_Word[i] = word_shown.charAt(i);
                if (word.charAt(i) == c) {
                    correct++;
                    temp_Word[i] = c;
                    changed = true;
                }
            }
            if (changed == false)
                missed++;
            word_shown = Character.toString(temp_Word[0]);
            for (int i = 1; i < word.length(); i++)
                word_shown += Character.toString(temp_Word[i]);

            if (correct == word.length()) {
                System.out.println("The word is " + word + ". You missed " + missed + " time");
            }
        }
        else
            System.out.print(c + " is already in the word\n");

    }
    private void play(){
        correct = 0;
        char c;
        do {
            System.out.print("(Guess) Enter a letter in word " + word_shown + " > ");
            Scanner read = new Scanner(System.in);
            c = read.next().charAt(0);

            this.check(c);
        }while(correct != word.length());
    }

    Game(){}
    Game(String _file_name){file_name = _file_name;}

    public void run(){
        char keep_playing;
        if(this.openFile()) {
            this.getWordList();

            do {
                this.getWord();
                this.play();

                System.out.print("Do you want to guess another word? Enter y or n> ");
                x = new Scanner(System.in);
                keep_playing = x.next().charAt(0);

            }while(keep_playing == 'y');
        }
        return;
    }

}
public class Hangman {
    public static void main(String[] args){
        Game game1 = new Game("hangman.txt");
        game1.run();
    }

}
