import java.util.*;

/**
 * Created by soola on 2017-12-10.
 */
class Lottery implements Collection{
    private int[] winning_numbers = new int[3];
    private int[] player_numbers = new int[3];
    private int[] player_Index = {5,5,5};
    private int[] lotto_Index = {5,5,5};




    private void generate_numbers(){
        Random rand = new Random();
        winning_numbers[0] = rand.nextInt(10);
        winning_numbers[1] = rand.nextInt(10);
        winning_numbers[2] = rand.nextInt(10);

    }
    private void get_Player_Numbers(){
        int num = 0;
        String s= "";
        boolean exit = true;

        System.out.print("Enter your 3 digit lottery number: ");
        Scanner x = new Scanner(System.in);
        do {
            do {

                exit = true;
                try {
                    num = x.nextInt();
                } catch (Exception e) {
                    System.out.print("\nValues entered must be a 3 digit numeric value. " + e + "\nEnter your 3 digit lottery number: ");
                    x.next();
                    exit = false;
                }
            } while (exit == false);
            s = Integer.toString(num);

            String ss[] = s.split("");
            if(ss.length !=3) {
                exit = false;
                System.out.println("\nValues entered must be a 3 digit numeric value. " + "\nEnter your 3 digit lottery number: ");
            }
            else {
                player_numbers[0] = Integer.parseInt(ss[0]);
                player_numbers[1] = Integer.parseInt(ss[1]);
                player_numbers[2] = Integer.parseInt(ss[2]);
            }
        }while(exit ==false);

    }
    private boolean checkMatched(int pIndex, int lIndex){
        boolean val = true;
        if(pIndex == player_Index[0] || pIndex == player_Index[1] || pIndex == player_Index[2])
            val = false;
        if(lIndex == lotto_Index[0] || lIndex == lotto_Index[1] || lIndex == lotto_Index[2])
            val = false;

        if(val){
            for(int i =0; i < 3; i++)
                if(this.player_Index[i] == 5) {
                    player_Index[i] = pIndex;
                    break;
                }
            for(int i =0; i < 3; i++)
                if(this.lotto_Index[i] == 5){
                    lotto_Index[i] = lIndex;
                    break;
                }
        }

        return val;
    }
    //task 2 b
    private boolean check2Matched(){
        int correct = 0;
        ArrayList<Integer> collection1 = new ArrayList<Integer>();
        collection1.add(player_numbers[0]);
        collection1.add(player_numbers[1]);
        collection1.add(player_numbers[2]);

        int[] winning = {winning_numbers[0], winning_numbers[1], winning_numbers[2]};


        if (collection1.contains(winning[0])) {
            collection1.remove(collection1.indexOf(winning[0]));
            winning[0] = 5;
            correct++;
        }
        if (collection1.contains(winning[1])) {
            collection1.remove(collection1.indexOf(winning[1]));
            winning[1] = 5;
            correct++;
        }
        if (collection1.contains(winning[2])) {
            collection1.remove(collection1.indexOf(winning[2]));
            winning[2] = 5;
            correct++;
        }

        return (correct == 2)? true : false;


    }
    //task 2 a
    private void check(){
        int winnings = 0;
        boolean win = false;
        int correct = 0;
        if(!this.check2Matched()) {
            for (int i = 0; i < 3; i++) {
                if (player_numbers[i] == winning_numbers[i])
                    correct++;
            }
            if (correct != 3) {
                correct = 0;


                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (player_numbers[i] == winning_numbers[j])
                            if (this.checkMatched(i, j))
                                correct++;

                    }
                }
                if (correct == 3)
                    winnings = 3000;
                else if (correct > 0 && correct < 3)
                    winnings = 1000;
            } else if (correct == 3)
                winnings = 10000;
        }else{
            winnings = 2000;
        }

        System.out.println("The numbers were: " + winning_numbers[0] + "," + winning_numbers[1] + "," + winning_numbers[2] + "\nyour winnnings are: " + winnings);
    }

    public void play(){
        this.generate_numbers();
        this.get_Player_Numbers();
        this.check();


    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
public class Task2 {
    public static void main(String[] args){
        Lottery lottery = new Lottery();
        lottery.play();
        




    }
}
