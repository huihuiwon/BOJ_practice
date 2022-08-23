import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException{

		Scanner sc = new Scanner(System.in);
		int k=1;
		while(true) {
			String str = sc.nextLine();
			if(str.contains("-")) {
				return;
			}
			int cnt=0;
			Stack<Character> st = new Stack<>();
			for(char c : str.toCharArray()) {
				if(c=='{') st.push(c);
				else {
					if(st.isEmpty()) {
						st.push('{');   //비어있는데 '}' 못 넣음 -> '{' 로 바꿔줘야함
						cnt++;
					}
					else if(c=='}') st.pop();  //올바른 괄호
					else {
						st.pop();  
            //'}}' 는 안된다. 앞에 있던 '}'를 '{'로 바꾸면 올바른 괄호가 되니 pop -> 생략해서 그냥 pop
						cnt++;
					}
				}
			}
			
			cnt+=st.size()/2;  
      /* 만약 '{' 이 연속으로 들어오고 짝인 '}'이 안들어왔으면 '{'만 남은채 위의 for문 종료
      그것을 해결하기 위한 부분
      만약 '{{' 이 남아있다면 둘 중 하나만 바꾸면 되므로, st.size()/2 를 더해준다
      '}'가 하나라도 끼여있는 경우는 없음
      push만 하고 끝나는 경우는 '{'가 들어가는 순간 뿐이기 때문
      st.isEmpty()일때 '}' 가 들어오면, 이것을 '{'로 바꾸기 때문에 끼여있다고 할 수 없다*/
			
			System.out.println(k+". "+cnt);
			k++;
		}
	}	
}
