
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by soola on 2017-12-20.
 */
 class Banks{
   private double balance;
    private int numBanksLoaned;
    private double totalAssets;
    HashMap<String, Double> map = new HashMap<>();

    public void fillMap(String s){
       String[]ss = s.split("\\s");
       balance = Integer.parseInt(ss[1]);
       numBanksLoaned = Integer.parseInt(ss[2]);

       for ( int i =3; i<ss.length-1; i++){
           map.put(ss[i],Double.parseDouble(ss[i+1]));
           i++;
       }
    }

    public double getBalance(){return balance;}
    public double getTotalAssets(){return totalAssets;}
    public void setTotalAssets(double total){totalAssets = total;}
    public int getNumBanksLoaned(){return  numBanksLoaned;}

}

public class Bank {
    public static void main(String[] args){

        ArrayList<Banks> banks = new ArrayList<>();
        ArrayList<Integer> index = new ArrayList<>();

        String text;
        Scanner x = null;

        try {
            x = new Scanner(new File("C:/Users/soola/Desktop/school/JAC444- Introduction to Java for C++ Programmers/Workshop4/src/interactions.txt"));

        } catch (FileNotFoundException e) {

            System.out.println("File Not Found... Program Terminating...." + e);
        }
        int count = 0;

        while(x.hasNext()) {
            text = x.nextLine();
            banks.add(new Banks());
            banks.get(count).fillMap(text);
            count++;
        }

        System.out.println();
        double num;

        int j;

        for(int i = 0;i<banks.size();i++){

            int y=0;
            j=0;
            num = banks.get(i).getBalance();

            do{

                if (banks.get(i).map.containsKey(Integer.toString(y))) {
                    num += banks.get(i).map.get(Integer.toString(y));
                    j++;
                }

                y++;
            }while(j<banks.get(i).getNumBanksLoaned());

            banks.get(i).setTotalAssets(num);
            if (num < 201)
                index.add(i);


        }


        for(int i=0;i<banks.size();i++){
            int y=0;
            j=0;


            do{
                if(banks.get(i).map.containsKey(Integer.toString(index.get(y))) ) {
                    num = banks.get(i).map.get(Integer.toString(index.get(y)));
                    j++;
                    if ((banks.get(i).getTotalAssets() - num) < 201)
                        index.add(i);
                }

                y++;
            }while(y< index.size());

        }
        String temp="Unsafe banks are ";
        for(int i =0;i<index.size();i++){
            temp+= Integer.toString(index.get(i));
            if(i<(index.size()-1))
                temp += " and Bank ";
        }
        System.out.println(temp);

    }
}
