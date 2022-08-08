import java.util.*;
import java.io.*;


public class Main {


	public static void main(String[] args) throws IOException{
		boolean chk[]=new boolean[10001];
		int n=1;
		
		for(int i=1; i<=10000; i++) {
			int tmp=i;
      int j=i;  
      /* 처음에 다른 변수에 할당안하고 바로 i를 이용해서 했는데,
      그러면 while문을 돌고 난 후에 i는 무조건 0이 되므로
      계속 똑같은 구문을 반복하게 된다 */
			while(j!=0) {
				tmp+=j%10;
				j/=10;
			}	
			if(tmp <= 10000)
				chk[tmp]=true;
		}
		
		for(int i=1; i<=10000; i++) {
			if(!chk[i])
				System.out.println(i);
		}
	}
	
}
