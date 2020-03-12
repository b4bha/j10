//SEVER SIDE PROGRAM

import java.net.*;
import java.io.*;

class server2
{
	public static void main(String[] args) throws IOException 
  	{
    	Socket s = null;
	    PrintWriter out = null;
    	ServerSocket ss = null;
    	String fname;
    	int ctr=0;
    	try 
    	{
      		ss = new ServerSocket(1234);
      		System.out.println("Server Started.......");
      		s= ss.accept();
      		System.out.println("Server Connected.......");
      		BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
      		out = new PrintWriter(s.getOutputStream(), true);
      		String ans="1";
      		while(ans.equals("1"))
      		{
				fname=in.readLine();
      			System.out.println("The file name is: "+fname);
      			File fis=new File(fname);
      
     			if(!fis.exists())
      				out.println(fname+" File does not exist on server");
      			else
      			{
      				out.println(fname+" File exists on server");
     				ctr++;
      			}
      			ans=in.readLine();
      		}
      		out.println(ctr);
      		out.close();
      		s.close();
    	} 
    	catch(Exception e) 
    	{
      		System.out.println("Error: "+e);
    	}
  	} 
}

/*====================================================================*/
 
