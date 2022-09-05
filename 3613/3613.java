import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		if(!Character.isLowerCase(str.charAt(0)) || str.charAt(str.length()-1)=='_') {
			System.out.println("Error!");
			return;
		}
		

		StringBuilder sb = new StringBuilder();
		if(str.contains("_")) {
			String tmp[]=str.split("_");
			for(char c : tmp[0].toCharArray()) {
				if(Character.isUpperCase(c)) {
					System.out.println("Error!");
					return;
				}
				sb.append(c);
			}

			for(int i=1; i<tmp.length; i++) {
				if(tmp[i].length() == 0) {
					System.out.println("Error!");
					return;
				}
				if(Character.isLowerCase(tmp[i].charAt(0)))
					sb.append(Character.toUpperCase(tmp[i].charAt(0)));
				else {
					System.out.println("Error!");
					return;
				}
				for(int j=1; j<tmp[i].length(); j++) {
					if(Character.isUpperCase(tmp[i].charAt(j))) {
						System.out.println("Error!");
						return;
					}
					sb.append(tmp[i].charAt(j));
				}
			}
		}
		else {
			for(int i=0; i<str.length(); i++) {
				if(Character.isUpperCase(str.charAt(i))) {
					sb.append("_");
					sb.append(Character.toLowerCase(str.charAt(i)));
				}
				else
					sb.append(str.charAt(i));
			}
		}
		System.out.println(sb);
	}
}
