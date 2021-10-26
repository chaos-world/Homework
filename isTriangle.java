import java.io.*;
import java.util.*;

public class isTriangle{
	public static void main(String[] args)throws IOException{
		Scanner cin=new Scanner(System.in);
		boolean a;
		int val1=cin.nextInt();
		int val2=cin.nextInt();
		int val3=cin.nextInt();
		int perimeter=val1+val2+val3;
		float temp=(val1+val2+val3)/2;
		float square=(float)Math.sqrt(temp*(temp-val1)*(temp-val2)*(temp-val3));
		if(val1<(val2+val3)&&val2<(val1+val3)&&val3<(val1+val2)){
			a=true;
		}
		else{
			a=false;
		}
		System.out.println("周长="+perimeter);
		System.out.println("面积="+square);
		System.out.println("是否为三角形:"+a);
	}
}