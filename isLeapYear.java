import java.io.*;
import java.util.*;

public class isLeapYear{
	public static void main(String[] args)throws IOException{
		Scanner cin=new Scanner(System.in);
		int year=cin.nextInt();
		boolean a;
		if(year%4==0&&year%100!=0||year%400==0){
			a=true;
		}
		else{
			a=false;
		}
		System.out.println(a);
	}
}