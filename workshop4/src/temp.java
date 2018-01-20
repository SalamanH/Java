// stuff
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyword;
import org.omg.CORBA.Object;

import  java.util.Date;

/**
 *
 * @author soola
 */
abstract class tempp{ /* stuff*/
    final String ss = "hello";
    private static volatile int _instance; // helllo

    public void dosomething(){
        System.out.println(this.ss);
    }
}
class ttempp extends tempp{
    public enum FB_TYPE {
        GREEN, WRINKLED, SWEET,
    }
      private int num = 0;
      protected int num2 = 0;
      public strictfp int getNum(){
          return num;
      }
    public synchronized int getnum2(){
        return num2;
    }
//    public transient int getsum(){
//        return num2+num;
//    }
    public void ifDouble(Number parameter) {
        if (parameter instanceof Double) {
            System.out.println("param is double");
        }

    }
       ttempp(){
           super();
       }
//    native void something2(){
//
//    }

}
interface Interface{
    default void something(){

    }


        }
public class temp implements Interface {
    public static void main(String[] args) throws Exception{
//        const
        int iint=0;
        double ddouble;
        float ffloat;
        long llong;
        short sshort;
        char cchar;
        boolean bboolean = true;
        bboolean = false;

        byte bbyte;

        String ss = null;
        switch (ss){
            case "HI":
                System.out.println("hi");
        }
        if(bboolean){

        }
        else

        for(iint = 0; iint<3;iint++){
            break;
        }
        try{
            throw new IllegalArgumentException("...");

        }catch(Exception e){

        }finally {

        }

        do{
//             goto outsideloops;
//            continue outsideloops;

        }while(bboolean == false);
//        assert mode == 0;
        outsideloops:


















                return;
    }
    
}
