import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Scanner;


/**
 * Course:JAC444 - 4
 Last Name:         Hamidkohzad
 First Name:        Salaman
 ID:                073 808 149
 Section:           SCC
 This assignment represents my own work in accordance with
 Seneca Academic Policy.
 Signature         Salaman Hamidkohzad
 Date:             11 October, 2017
 */
class DiscountRate {
    public static double serviceDiscountPremium = 0.2;
    public static double serviceDiscountGold = 0.15;
    public static double serviceDiscountSilver = 0.1;
    public static double productDiscountPremium = 0.1;
    public static double productDiscountGold = 0.1;
    public static double productDiscountSilver = 0.1;

    public static double getServiceDiscountRate(String type){
        type.toLowerCase();
        switch (type) {
            case "premium":
                return serviceDiscountPremium;
            case "gold":
                return serviceDiscountGold;
            case "silver":
                return serviceDiscountSilver;
        }
        return 1;

    }
    public static double getProductDiscountRate (String type) {
        type.toLowerCase();
        switch (type){
            case "premium":
                return productDiscountPremium;
            case "gold":
                return productDiscountGold;
            case "silver":
                return productDiscountSilver;
        }
        return 1;

    }
}

class Customer {
    private String name;
    private boolean member = false;
    private String memberType;

    public Customer(){
        name = "";
        memberType = "";
    }

    public Customer(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public boolean isMember(){
        return member;
    }
    public void setMember(boolean member){
        this.member = member;
    }
    public String getMemberType(){
        return memberType;
    }
    public void setMemberType(String type){
        this.memberType = type;

    }



}

class Visit extends Customer {

    private Customer customer;
    private Date date;
    private double serviceExpense;
    private double productExpense;

    public Visit(String name, Date date){
        customer = new Customer(name);
        this.date = date;

    }
    public String getName(){
        return customer.getName();
    }
    public double getServiceExpense(){
        return serviceExpense;
    }
    public void setServiceExpense(double ex){
        serviceExpense = ex;
    }
    public double getProductExpense(){
        return productExpense;
    }
    public void setProductExpense(double ex){
        productExpense = ex;
    }
    public void setMember(boolean member){
        this.customer.setMember(member);
    }
    public void setMemberType(String type){
        this.customer.setMemberType(type);

    }
    public double getTotalExpense(){

        double price;

        if(customer.isMember()) {
            return (serviceExpense*(1-DiscountRate.getServiceDiscountRate(customer.getMemberType()))) + (productExpense * (1-DiscountRate.getProductDiscountRate(customer.getMemberType())));
        }
        else
            return serviceExpense + productExpense;
    }
    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("##.##");df.setRoundingMode(RoundingMode.CEILING);
        return date  + "\n" + "Name: " + customer.getName() + "\n" + "Is Member?: " + customer.isMember() + "\n"
                + (customer.isMember()== true? "Member Type: " + customer.getMemberType() + "\n" : "\n")
                + "Service Expense: " + getServiceExpense()  + "\n"
                + "Product Expense: " + getProductExpense()  + "\n"
                + "Total Expense: " + df.format(getTotalExpense()) + "\n \n";
    }


}
public class As1 {

    public static void main(String[] args)
    {
        boolean exit = true;
        Scanner reader = new Scanner(System.in);
        int visitNum = 0;
        String n = "";
        double expense = 0;
        do {
            boolean leave;
            visitNum++;

            System.out.print("Enter a name: ");
            n = reader.next();
            Date d = new Date();
            Visit visit = new Visit(n, d);


            leave = false;
            do {
                System.out.print("Are you a member?: ");
                n = reader.next();
                if(n.trim().toUpperCase().equals("YES") || n.trim().toUpperCase().equals("NO") )
                    leave = true;
                else
                    System.out.println("Please enter \"yes \" or \"no\" ");

            }while(leave==false);
            if (n.trim().toUpperCase().equals("YES"))
                visit.setMember(true);




            leave = false;
            if(n.trim().toUpperCase().equals("YES"))
            {
                do {
                    System.out.print("Set Member Type? : ");
                    n = reader.next();
                    if(n.trim().toUpperCase().equals("PREMIUM") || n.trim().toUpperCase().equals("GOLD") || n.trim().toUpperCase().equals("SILVER") )
                        leave = true;
                    else
                        System.out.println("Please enter \"PREMIUM\" or \"GOLD\" or \"SILVER\" ");
                }while(leave==false);

                visit.setMemberType(n);
            }




            boolean temp1 = true;

            do {

                temp1=true;



                    System.out.print("Enter Product expense: ");
                    try {
                        expense = reader.nextDouble();

                    }catch(Exception e){
                        System.out.println("please make sure that expense are entered in numeric value");
                        temp1 = false;
                        reader.next();
                    }

            }while(temp1 == false);
            visit.setProductExpense(expense);


            do {
                temp1=true;


                System.out.print("Enter Service expense: ");
                    try {
                        expense = reader.nextDouble();

                    }catch(Exception e){
                        System.out.println("please make sure that expense are entered in numeric value");
                        temp1 = false;
                        reader.next();
                    }

            }while(temp1== false);
            visit.setServiceExpense(expense);



                    System.out.println();





            boolean exit2;
            exit = false;
            System.out.println(visit);

            do {
                System.out.print("enter 0 if you would like to finish: ");
                exit2 = true;
                int temp = 9;

                try {
                    temp = reader.nextInt();
                    exit2= true;
                } catch (Exception e) {
                    System.out.println("Please enter 0 or a non 0 numeric number");
                    reader.next();
                    exit2 = false;

                }
                if (temp == 0)
                    exit  = true;

            }while(exit2 == false);

            if (exit == false)
                System.out.println("\n");

        }while(exit == false);
    }

}
