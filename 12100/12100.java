import java.util.*;
import java.io.*;

class Main {
	static int arr[]=new int[5];
	static boolean chk[]=new boolean[6];
	static int n = 4; static int m = 5;
	static int map[][];
	static int size;
	static int ans = 0;
	public static void order(int L) {
		if(L==m) {
			
			int tmp[][]=new int[size][size];
			for(int i=0; i<size; i++)
				for(int j=0; j<size; j++)
					tmp[i][j] = map[i][j];
			
			for(int a: arr) {
				if(a==1) {
					for(int j=0; j<size; j++) {
						Queue<Integer> q = new LinkedList<>();
						for(int i=0; i<size; i++) {
							if(tmp[i][j]!=0) q.add(tmp[i][j]);
							tmp[i][j]=0;
						}
						
						if(q.size() == 1) tmp[0][j]=q.poll();
						else {
							int k = 0;
							while(q.size()>1) {
								int first = q.poll(); int second = q.peek();
								if(first == second) tmp[k][j] = q.poll()*2;
								else tmp[k][j]= first;
									
								k++;
							}

							if(q.size() == 1)
							tmp[k][j]=q.poll();
						}
					}
				}
				else if(a==2) {
					for(int i=0; i<size; i++) {
						Queue<Integer> q = new LinkedList<>();
						for(int j=size-1; j>=0; j--) {
							if(tmp[i][j]!=0) q.add(tmp[i][j]);
							tmp[i][j]=0;
						}
						
						if(q.size() == 1) tmp[i][size-1]=q.poll();
						else {
							int k = size-1;
							while(q.size() > 1) {
								int first = q.poll(); int second = q.peek();
								if(first == second) tmp[i][k] = q.poll()*2;
								else tmp[i][k]= first;
									
								k--;
								
							}
							
							if(q.size() == 1)
							tmp[i][k]=q.poll();
						}
					}
				}
				else if(a==3) {
					for(int j=0; j<size; j++) {
						Queue<Integer> q = new LinkedList<>();
						for(int i=size-1; i>=0; i--) {
							if(tmp[i][j]!=0) q.add(tmp[i][j]);
							tmp[i][j]=0;
						}
						
						if(q.size() == 1) tmp[size-1][j]=q.poll();
						else {
							int k = size-1;
							while(q.size()>1) {
								int first = q.poll(); int second = q.peek();
								if(first == second) tmp[k][j] = q.poll()*2;
								else tmp[k][j]= first;
									
								k--;
							}

							if(q.size() == 1)
							tmp[k][j]=q.poll();
						}
					}
				}
				else {
					for(int i=0; i<size; i++) {
						Queue<Integer> q = new LinkedList<>();
						for(int j=0; j<size; j++) {
							if(tmp[i][j]!=0) q.add(tmp[i][j]);
							tmp[i][j]=0;
						}
						
						if(q.size() == 1) tmp[i][0]=q.poll();
						else {
							int k = 0;
							while(q.size()>1) {
								int first = q.poll(); int second = q.peek();
								if(first == second) tmp[i][k] = q.poll()*2;
								else tmp[i][k]= first;
									
								k++;
							}

							if(q.size() == 1)
							tmp[i][k]=q.poll();
						}
					}
				}
				
				for(int i=0; i<size; i++) {
					for(int j=0; j<size; j++) {
						if(tmp[i][j] != 0)
							ans = Math.max(ans, tmp[i][j]);
					}
				}
			}
			
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(chk[i]) continue;
			arr[L]=i+1;
			chk[i+1]=true;
			order(L+1);
			chk[i+1]=false;
		}
	}
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		size = sc.nextInt();
		
		map=new int[size][size];
		for(int i=0; i<size; i++)
			for(int j=0; j<size; j++)
				map[i][j]=sc.nextInt();
		
		order(0);
		
		System.out.println(ans);
	}
}
