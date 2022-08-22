import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException{

		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(); int k=sc.nextInt();
		int sum=k*(k+1)/2;
		if(sum > n) {    
      /* 만약 N이 1~k까지 합보다 작다면, 모두 다른 개수로 공을 넣을 수 없음
      모두 다른 개수로 공을 넣을 수 있는 기본적인 방법은 바구니에 1개, 2개, 3개, ... 넣는 것*/
			System.out.println(-1);
		}
		else {
			if((n-sum) % k == 0)
        // 만약 N에서 기본적인 합을 뺐을 때, 뺀 값도 k로 나누어떨어진다면 바구니에 1개, 2개, 3개, .. 넣을 수 있다
				System.out.println(k-1);
			else
				System.out.println(k);
		}
		
	}
	
}
