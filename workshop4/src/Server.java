/**
 * Created by soola on 2017-12-20.
 */
import java.net.*;
import java.io.*;
import java.util.Date;

public class Server {
    static Date date = new Date();
    public static void main(String[] args) throws Exception{
        System.out.println("MultiThreadServer started at " + date);

        ServerSocket ss=new ServerSocket(3333);
        System.out.println("Server is listening for the connections... ");
        Socket s=ss.accept();
        System.out.println(s.getInetAddress());
        Socket s2=ss.accept();
        System.out.println(s.getInetAddress());

        DataInputStream din=new DataInputStream(s.getInputStream());
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());

        DataInputStream din2=new DataInputStream(s2.getInputStream());
        DataOutputStream dout2=new DataOutputStream(s2.getOutputStream());

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String str="",str2="";
        while(!str.equals("stop")){
            System.out.println("Waiting message from clinet...:");
            str=din.readUTF();
            System.out.println("client says: "+str);
            str=din2.readUTF();
            System.out.println("client2 says: "+str);
            System.out.println("Write message back to client (stop 					to close connection): ");

            str2=br.readLine();
            dout.writeUTF(str2);
            dout.flush();
        }
        din.close();
        s.close();
        ss.close();
    }
}
class threadClient extends Thread {
    private Socket s;
    private String string;
    Date _date;
    String name;
    threadClient(Socket _s){
        s = _s;
        _date = new Date();
    }
    public void run(){
        System.out.println("Socket Connection: \nAddrress: " + s.getInetAddress() + "\nPort: " + s.getPort());
        try{
            DataInputStream dis = new DataInputStream((s.getInputStream()));
//            do {
//                string = dis.readUTF();
//
//
//            }while();

        }catch(Exception e){

        }
    }

}



