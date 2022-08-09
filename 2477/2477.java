import java.util.*;
import java.io.*;


public class Main {


	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] div=new int[6];
		int[] len=new int[6];
		int maxh=0, maxw=0;
		for(int i=0; i<6; i++) {
			int a=sc.nextInt(); int b=sc.nextInt();
			if(a==1 || a==2){
				maxw=Math.max(maxw, b);
				div[i]=a;
				len[i]=b;
			}
			else {
				maxh=Math.max(maxh, b);
				div[i]=a;
				len[i]=b;
			}
		}


		int minw=0; int minh=0;

		for(int i=0; i<6; i++) {
			if(len[i]==maxw || len[i]==maxh) {
				if(len[i+1]==maxw || len[i+1]==maxh) {
					minw=len[(i+3)%6];
					minh=len[(i+4)%6];
					break;
				}
				else {
					minw=len[(i+2)%6];
					minh=len[(i+3)%6];
					break;	
				}
			}
		}

    
		int tmp = maxh*maxw - minh*minw;
		System.out.println(n*tmp);
	}
	
}
