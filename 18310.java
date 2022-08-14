import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException{

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int home[]=new int[t];
		for(int i=0; i<t; i++)
			home[i]=sc.nextInt();
		Arrays.parallelSort(home);

		if(t % 2 == 1)
			System.out.println(home[t/2]);
		else
			System.out.println(home[t/2-1]);
	}
	
}
