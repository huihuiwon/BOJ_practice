import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int tc= Integer.parseInt(br.readLine());
    	
    	while(tc-->0) {
    		
    		int al[]=new int[26];
    		String str = br.readLine();
    		boolean flag = true;
    		for(int i=0; i<str.length(); i++) {
    			al[str.charAt(i)-'A']++;
    			if(al[str.charAt(i)-'A'] == 3) {  // 각 문자가 세 번째로 등장한 경우
    				if(i==str.length()-1 || str.charAt(i) != str.charAt(i+1)) {
              //만약 문자열의 마지막 문자였다면 당연히 FAKE, 세 번째로 등장하면 한 번 더 문자 삽입되어야 함
              //만약 직후 문자가 달라도 FAKE
    					System.out.println("FAKE");
    					flag = false;
    					break;
    				}
    				else {
              //직후 문자와 같다면, 일단 배열값을 0으로 갱신해주고 i++를 해서 삽입된 문자는 지나쳐야 함
              //왜냐면 등장 횟수를 셀 때 삽입된 문자의 등장은 세지 않기 때문
    					al[str.charAt(i)-'A'] = 0;
    					i++;
    				}
    			}
    		}
    		if(flag)
    			System.out.println("OK");
    	}
    }
}
