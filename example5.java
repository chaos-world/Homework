import java.io.*;
import java.util.*;

public class example5{
	public static void main(String[] args)throws IOException{
		Scanner cin=new Scanner(System.in);
		int a=cin.nextInt();
		int b=cin.nextInt();
		int sum=0;
		for(int i=0;i<b;i++){
			sum+=a;
			a=a*10+(a%10);
		}
		System.out.println(sum);
	}
}