import java.util.*;
import java.io.*;


public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp[] = br.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]);
		int k = Integer.parseInt(tmp[1]);
		int result=0;
		char hp[] = br.readLine().toCharArray();
		boolean chk[] =new boolean[n];

		for(int i=0; i<n; i++) {
			if(chk[i]) continue;
			for(int j=i+1; j<=i+k && j<n; j++) {
				if(chk[j]) continue;
				if(hp[i] != hp[j]) {
					result++;
					chk[i] = true;
					chk[j] = true;
					break;
				}
			}
		}
		
		System.out.println(result);
	}
}


/* 브루트포스로 풀었지만 다른 풀이로도 가능
위의 경우 오른쪽만 보면서 풀이해줬다

hp[i] == 'P' 이고, i-k ~ i+k 사이에 H가 있다면, 햄버거를 분배할 수 있다는 뜻
i-k ~ i+k 사이에 H가 있는 지는 boolean 함수를 구현해서 결과가 True이면 result++을 해주는 방식으로도 풀이 가능
이때도 햄버거를 먹었다면 먹었다는 표시를 해줘야 한다!
*/
