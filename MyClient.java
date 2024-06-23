import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MyClient
{
	public static void main(String[] args)
	{
		try
		{
			Socket ser= new Socket("localhost",1234);
			
			DataInputStream dis=new DataInputStream(ser.getInputStream());
			DataOutputStream dos=new DataOutputStream(ser.getOutputStream());
			Scanner scan=new Scanner(System.in);
			
			int n1,n2,ans;
			
			System.out.println("\n Enter the no's : ");
			n1=scan.nextInt();
			n2=scan.nextInt();
			
			dos.writeInt(n1);
			dos.writeInt(n2);
			
			ans=dis.readInt();
			System.out.println("\n Sum is : "+ans);
			
			dis.close();
			dos.close();
			ser.close();
		}
		catch(Exception e)
		{
			System.out.println("\n Message : "+e.getMessage());
		}
	}
}