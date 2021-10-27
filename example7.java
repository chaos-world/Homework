import java.io.*;
import java.util.*;


public class example7{
	public static void main(String[] args)throws IOException{
		Scanner cin=new Scanner(System.in);
		ymd s=new ymd();
		s.year=cin.nextInt();
		s.mouth=cin.nextInt();
		s.day=cin.nextInt();
		int pastedDay=0;
		for(int i=2000;i<s.year;i++){
			if((s.year%4==0&&s.year%100!=0)||(s.year%400==0)){
				pastedDay+=366;
			}
			else{
				pastedDay+=365;
			}
		}
		pastedDay+=s.getDay(s.year,s.mouth,s.day);
		System.out.println(pastedDay);
	}
}
class ymd{
	int year;
	int mouth;
	int day;
	int getDay(int a,int b,int c){
		int[] array={31,28,31,30,31,30,31,31,30,31,30,31};
		if((a%4==0&&a%100!=0)||(a%400==0)){
			array[1]=29;
		}
		int sum=c;
		for(int i=0;i<b;i++){
			sum+=array[i];
		}
		return sum;
	}
}