import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i=0; i<25; i++) {
			hm.put(sc.nextInt(), i);
		}
		
		
		
		boolean chk[][]=new boolean[5][5];
		for(int i=1; i<=25; i++) {
			int call = hm.get(sc.nextInt());
			chk[call/5][call%5]=true;
			
			if(i>=13) {
				if(checking(chk) >= 3) {
					System.out.println(i);
					return;
				}
			}
		}
	}
	
	public static int checking(boolean chk[][]) {
		int cnt=0;
		for(int i=0; i<5; i++) {
			boolean flag=false;
			for(int j=0; j<5; j++) {
				if(!chk[i][j]) {
					flag=true;
					break;
				}
			}
			if(!flag) cnt++;
		}
		for(int i=0; i<5; i++) {
			boolean flag=false;
			for(int j=0; j<5; j++) {
				if(!chk[j][i]) {
					flag=true;
					break;
				}
			}
			if(!flag) cnt++;
		}

		boolean flag=false;
		for(int i=0; i<5; i++) {
			if(!chk[i][i]) {
				flag=true;
				break;
			}
		}
		if(!flag) cnt++;
		
		flag=false;
		for(int i=0; i<5; i++) {
			if(!chk[i][4-i]) {
				flag=true;
				break;
			}
		}
		if(!flag) cnt++;
		return cnt;
	}
	
}
