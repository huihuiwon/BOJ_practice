import java.util.*;
import java.io.*;


public class Main {
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(); int m=sc.nextInt();
		int j=sc.nextInt(); int apple[]=new int[j];
		
		int result=0; int cur=1; m-=1;
		for(int i=0; i<j; i++) {
			int want=sc.nextInt();
			if(want <= cur+m && want >=cur) continue;
			
			if(want >= cur+m) {
				result += want - (cur+m);
				cur += want - (cur+m);
			}
			else {
				result += cur - want;
				cur += want - cur;
			}
    }
		
		System.out.println(result);
	}
	
}
