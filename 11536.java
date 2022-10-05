import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n= Integer.parseInt(br.readLine());
    	
    	String org[] = new String[n];
    	for(int i=0; i<n; i++) {
    		org[i]=br.readLine();
    	}
    	
    	String sort[]= Arrays.copyOf(org, n);
    	String reverse[] = Arrays.copyOf(org, n);
    	
    	Arrays.sort(sort);
    	Arrays.sort(reverse, Collections.reverseOrder());


    	if(Arrays.equals(org, sort)) {
    		System.out.println("INCREASING");
    	}
    	else if(Arrays.equals(org, reverse)) {
    		System.out.println("DECREASING");
    	}
    	else {
    		System.out.println("NEITHER");
    	}
    }
}

***
Arrays.equals(A, B) 는 A와 B 배열 내용이 같은지 비교하는 것
A.equals(B)는 객체가 같은지 비교하는 것

이 경우 배열 값이 같은지를 비교해야 하므로 Arrays.equals() 를 사용해줘야 한다
