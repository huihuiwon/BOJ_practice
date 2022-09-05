import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		HashMap<String, Integer> hm = new HashMap<>();
		for(int i=0; i<n; i++) {
			hm.put(br.readLine(), i);
		}
		
		int arr[]=new int[n];
		for(int i=0; i<n; i++) {
			arr[i]=hm.get(br.readLine());
		}
		
		int cnt=0;
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				if(arr[i] > arr[j]) {
					cnt++;
					break;
				}
			}
		}
		
		System.out.println(cnt);
	}
}


***
만약 N이 4이고
0 1 2 3
1 2 3 0
으로 들어오고 나갔다면 추월한 대수는 3
왜냐면 0이 제일 먼저 나와야 했는데 1, 2, 3이 먼저 나왔다

이를 위해서 먼저 들어간 차들의 순서를 HashMap에 담아두고, 나온 차들의 들어간 순서를 arr 배열에 담는다
그 후 이중 for문을 돌면서, 만약 arr[i] > arr[j] 라면, 추월했다는 뜻이므로 cnt++ 을 해주고 break

즉 1은 0보다 크므로 cnt++
2도 0보다 크므로 +1, 3도 0보다 크므로 +1
최종적인 답은 3
