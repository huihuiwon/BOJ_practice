import java.util.*;
import java.io.*;

public class Main {	

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int ans=0;
		Stack<Integer> st = new Stack<>();
		for(char c : str.toCharArray()) {
			if(Character.isDigit(c)) {
				st.push(c-'0');
			}
			else {
				int tmp=0;
				if(c=='*') {
					tmp = st.pop()*st.pop();
				}
				else if(c=='+') {
					tmp = st.pop()+st.pop();
				}
				else if(c=='-') {
					int op=st.pop(); int op2=st.pop();
					tmp = op2-op;
				}
				else {
					int op=st.pop(); int op2=st.pop();
					tmp = op2/op;					
				}
				st.push(tmp);
			}
		}
		System.out.println(st.pop());
	}
}


***
나누기와 뺄셈을 할 때는 그냥 st.pop() 연산 st.pop() 을 하면 안되고,
두번째로 pop 한 값에서 첫 번째로 pop한 값을 연산해야 한다
