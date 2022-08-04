import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException{

		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
			int n=sc.nextInt();
			int num[]=new int[n];
			for(int i=0; i<n; i++)
				num[i]=sc.nextInt();
			
			int max=num[n-1]; int result = 0;
			for(int i=n-2; i>=0; i--) {
				if(max < num[i]) {
					max=num[i];
				}
				else {
					result += max-num[i];
				}
			}
			
			System.out.println(result);
		}
	}	
}


/*
그 구간 내에 최댓값을 찾아서 그 최댓값에서 뺀 값을 더해줘야하는 문제
만약 배열의 값이 1 2 3 이라면, (2-1)+(3-2)=2 가 아닌, (3-1)+(3-2)=3 이 정답이어야 한다
이를 위해서 만약 앞에서부터 값을 구하려고 한다면 O(n^2) 이 될 것

O(n) 시간 복잡도를 가지기 위해서는 뒤에서부터 살펴보면서, 현재 가지고 있는 max값보다 num[i]가 크다면 max를 갱신하고,
아니라면 result += max-num[i] 를 하는 식으로 값을 구해준다

만약 5 1 2 3 이라면, 처음의 max는 3
2는 max보다 작으니 result = (3-2),
1 역시 max보다 작으니 result += (3-1),
5는 max보다 크니까 3에 팔아서는 이익을 얻을 수 없다
따라서 max를 5로 갱신

날의 수가 1,000,000 이하이고 날 별 주가는 10,000 이하이니 최종 결과는 int형을 넘을 수도 있다
따라서 result의 자료형을 long형으로 선언해줘야함
*/
