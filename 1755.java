import java.io.*;
import java.util.*;


public class Main {
	static String num[]= {"0","1","2","3","4","5","6","7","8","9"};
	static String str[]= {"zero","one","two","three","four","five","six","seven","eight","nine"};
	public static String change(int a) {
		String ans="";
		if(a>=10) {
			ans=str[a/10];
			ans+=str[a%10];
		}
		else {
			ans=str[a];
		}
		return ans;
	}
	
	public static String changeton(String s) {
		for(int i=0; i<10; i++)
			s = s.replace(str[i], num[i]);
		return s;
	}
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		ArrayList<String> arr = new ArrayList<>();
		for(int i=a; i<=b; i++) {
			arr.add(change(i));
		}
		Collections.sort(arr);
		
		for(int i=1; i<=arr.size(); i++) {
			System.out.print(changeton(arr.get(i-1))+" ");
			if(i%10==0) System.out.println();
		}
	}
}
