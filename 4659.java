import java.util.*;
import java.io.*;

public class Main {
	
	static int map[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String str=br.readLine();
			if(str.equals("end")) return;
			
			int m=0; //모음 자음 개수
			int mc=0; int jc=0; //연속된 모음 자음 개수
			boolean flag=false;
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i)=='a' || str.charAt(i)=='e' || str.charAt(i)=='i' ||
						str.charAt(i)=='o' || str.charAt(i)=='u') {
					m++;
					mc++;
					jc=0;  // 모음이 나왔으니 자음 연속이 끊김
				}
				else {
					jc++;
					mc=0;  // 자음이 나왔으니 모음 연속 끊김
				}
				if(jc >= 3 || mc >= 3) {  // 자음이나 모음이 연속 3개 이상인 경우
					System.out.println("<"+str+">"+" is not acceptable.");
					flag=true;
					break;
				}
				if(i != str.length()-1) {
					if(str.charAt(i)==str.charAt(i+1) && (str.charAt(i)!='e' && str.charAt(i)!='o')) {  // e나 o가 아닌데 같은 문자가 연속된 경우
						System.out.println("<"+str+">"+" is not acceptable.");
						flag=true;
						break;
					}
				}
			}
			if(!flag && m==0) System.out.println("<"+str+">"+" is not acceptable.");  // 모음이 없는 경우
			else if(!flag) System.out.println("<"+str+">"+" is acceptable.");
		}
	}
	
}
