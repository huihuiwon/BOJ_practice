import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException{

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		boolean flag1=false, flag2=false, flag3=false, flag4=false;
		for(char c : str.toCharArray()) {
			if(!flag1) {
				if(c=='U') flag1=true;
			}
			else {
				if(!flag2) {
					if(c=='C') flag2=true;
				}
				else {
					if(!flag3) {
						if(c=='P') flag3=true;
					}
					else {
						if(!flag4) {
							if(c=='C') {
								flag4=true;
								break;
							}
						}
					}
				}
			}
		}
		if(flag4) System.out.println("I love UCPC");
		else System.out.println("I hate UCPC");
	}
}


//flag 변수를 이용해서 구현했는데, UCPC를 배열로 선언하고 `if(c=='U') ucpc[idx++]` 같은 식으로 구현하면 더 깔끔하게 구현 가능
