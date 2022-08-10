import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); int k=sc.nextInt();
		int arr[][]=new int[n][4];
		int g=0; int s=0; int d=0;
		for(int i=0; i<n; i++) {
			arr[i][0]=sc.nextInt(); arr[i][1]=sc.nextInt(); arr[i][2]=sc.nextInt(); arr[i][3]=sc.nextInt();
			if(arr[i][0]==k) {
				g=arr[i][1]; s=arr[i][2]; d=arr[i][3];
			}
		}
		
		Arrays.sort(arr, (o1, o2)->{  // 이차원 배열 정렬 방법
			if(o1[1]==o2[1]) {
				if(o1[2]==o2[2])
					return Integer.compare(o2[3], o1[3]);
				return Integer.compare(o2[2], o1[2]);
			}
			return Integer.compare(o2[1], o1[1]);
		});
		
		int win=1;
		for(int i=0; i<n; i++) {
			if(arr[i][0]==k) {
				System.out.println(win);
				return;
			}
			if(arr[i][1] != g || arr[i][2] != s || arr[i][3] != d)  // 구하고자 하는 K와 금, 은, 동 모두 같다면 순위는 같아야함
				win++;
		}

		
	}
	
}
