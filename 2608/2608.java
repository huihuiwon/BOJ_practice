import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n1=br.readLine();
		String n2=br.readLine();
		
		String arr1[]= {"IV", "IX", "XL", "XC", "CD", "CM", "I", "V", "X", "L", "C", "D", "M"};
		String arr2[]= {"4 ","9 ","40 ","90 ","400 ","900 ","1 ","5 ","10 ","50 ","100 ","500 ","1000 "};
		
		for(int i=0 ;i<arr1.length; i++) {
			n1 = n1.replace(arr1[i], arr2[i]);
			n2 = n2.replace(arr1[i], arr2[i]);
		}
		
		String tmp[] = n1.split(" ");
		String tmp2[] = n2.split(" ");
		
		int sum=0;
		for(int i=0; i<tmp.length; i++) {
			sum += Integer.parseInt(tmp[i]);
		}
		int total = sum;
		sum=0;
		for(int i=0; i<tmp2.length; i++) {
			sum += Integer.parseInt(tmp2[i]);
		}
		total += sum;
		
		System.out.println(total);
		
		
		StringBuilder sb = new StringBuilder();
		String arr3[]= {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		int arr4[]= {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		
		while(total != 0) {
			for(int j=0; j<arr4.length; j++) {
				if(total>=arr4[j]) {
					total-=arr4[j];
					sb.append(arr3[j]);
					break;
				} 
			}
		}
		System.out.println(sb);
	}
}
