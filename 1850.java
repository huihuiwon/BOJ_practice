import java.util.*;
import java.io.*;


public class Main {	
	
	public static long uc(long a, long b) {
		if(b==0)
			return a;
		return uc(b, a%b);
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong(); long b = sc.nextLong();
		
		long tmp = uc(a, b);
		StringBuilder sb = new StringBuilder();
		for(long i=1; i<=tmp; i++)
			sb.append(1);
		System.out.println(sb);
	}
}


***
여기서 A가 3 이면 실제 수는 111
B가 4 이면 실제 수는 1111

3과 4의 최대공약수는 1이고, 111과 1111의 최대공약수도 1(1이 1개)이다
3과 6의 최대공약수는 3이고, 111과 111111의 최대공약수는 111(1이 3개)
  
따라서 최대공약수를 구해놓고,
for문을 돌려서 그만큼 1을 출력해주면 된다

처음에 출력할 때 그냥 print() 을 썼더니 시간초과 발생
