import java.io.*;
import java.util.*;

public class isPrime{
	public static void main(String[] args)throws IOException{
		Scanner cin=new Scanner(System.in);
		int val=cin.nextInt();
		boolean a=true;
		for(int i=2;i<=Math.sqrt(val);i++){
			if(val%i==0){
				a=false;
				break;
			}
		}
		System.out.println(a);
	}
}