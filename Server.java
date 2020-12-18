import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    static final int port = 1200;

    public static void main(String[] args) throws Exception {

        
        ServerSocket s = new ServerSocket(port);
        System.out.println("Waiting for connection");
        Socket socClient = s.accept(); // Accept a client socket
        System.out.println("Connection established");
        BufferedReader inServer = new BufferedReader(new InputStreamReader(socClient.getInputStream()));
        PrintWriter outServer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socClient.getOutputStream())), true);   
       
  boolean b= true;
  String str=inServer.readLine();
  int n=0;
  n=Integer.parseInt(str);
        System.out.println("la liste des entiers premier inferieurs ou égale à "+n+" est:");
   for(int i=2;i<=n;i++)
   {
  for(int j=2; j<= i/2; j++)
  {
  
     if(i%j == 0)
     {
        b = false;
        break;
     }
  }

  if(b)
     System.out.println(i);
 
  b=true;
   }
   
        inServer.close();
        outServer.close();
        socClient.close();
    }
}
