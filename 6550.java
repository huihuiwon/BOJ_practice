import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String str = "";
    	while(true) {
    		str = br.readLine();
    		if(str==null) break;
    		String tmp[] = str.split(" ");
    		int si=0; // 투포인터 이용
    		if(tmp[0].length() > tmp[1].length()) { // s가 t의 부분 문자열이려면 s의 길이가 t의 길이보다 짧거나 같아야 함
    			System.out.println("No");
    			break;
    		}
    		for(int i=0; i<tmp[1].length(); i++) {
    			if(tmp[1].charAt(i) == tmp[0].charAt(si)) { 
            // i는 계속 변동, si는 일단 고정하되 만약 두 문자가 같다면 si도 +1
    				si++;
    			}
    			if(si == tmp[0].length()) { // s는 t의 부분 문자열!
    				break;
    			}
    		}
    		if(si != tmp[0].length()) {
    			System.out.println("No");
    		}
    		else
    			System.out.println("Yes");
    	}
    }
}

***
Yes, No로 출력해야하는데 YES, NO로 출력.. -> 출력문 제대로 확인하기
