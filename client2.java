//CLIENT SIDE PROGRAM

import java.io.*;
import java.net.*;

class client2
{
	public static void main(String[] args) throws IOException 
  	{
	    Socket s = null;
    	PrintWriter out = null;
    	String fname;
    
    	try 
    	{
      		s=new Socket("127.0.0.1", 1234);
      		String ans="1";
      		String msg=null;
      		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      		BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
      		out = new PrintWriter(s.getOutputStream(), true);
   	  		while(ans.equals("1"))
	  		{ 
				System.out.println("Enter the file name: ");
      			fname=br.readLine();
      			out.println(fname);
      			msg=in.readLine();
      			System.out.println(msg);
      			System.out.println("Press 1 to continue ");
      			ans=br.readLine();
      			out.println(ans);
      		}
      		int ctr=Integer.parseInt(in.readLine());
  			System.out.println("No of files exists on server are : "+ctr);
      		s.close();
     	} 
    	catch(UnknownHostException e) 
    	{
      		System.out.println("Error :"+e);
    	} 
  	}
}