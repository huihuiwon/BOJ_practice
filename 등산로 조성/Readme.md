두 가지 풀이법이 가능</br>
여기서 map의 값을 바꿔줘야 하지만 다음에 돌 때는 원래의 map을 사용해야 한다</br>
하지만 만약 그냥 map의 값을 바꾸고 끝내버리면 다음에도 바뀐 map 값을 그대로 이용

```
int orgin = map[nx][ny];
map[nx][ny] = map[x][y]-1;
DFS(nx, ny, count+1, false);
map[nx][ny] = orgin;
```

따라서 위와 같이 하면 값을 바꾼 것을 이용하고,</br>
다음에는 원래대로 사용할 수 있다

처음에 계속 이상한 값이 나왔던 이유는</br>
nx와 ny의 범위를 체크하고, 방문했는지 여부를 확인하고 난 다음 return을 해버렸기 때문!</br>
continue를 해줘야 올바른 값이 나온다</br>
return을 해버리면 아예 끝나기 때문

java 파일에는 Class Node를 이용한 방법이 있다</br>
Node를 이용하면 굳이 위와 같이 변수를 따로 선언해서 바꿔주고 원래 값을 다시 넣어줄 필요가 없다</br>
만약 map 배열을 그대로 사용하고 싶다면 다음과 같이 풀이


```
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    static int dx[]={0,1,0,-1};
    static int dy[]={1,0,-1,0};
    static int max = 0;
    
    static int[][] map;
    static boolean[][] chk;
    static int n=0, k=0;
    
    public static void DFS(int x, int y, int count, boolean flag) {
        chk[x][y]=true;
        max = Math.max(max, count);
        
        for(int dir=0; dir<4; dir++) {
        	int nx = dx[dir]+x;
            int ny = dy[dir]+y;
            
            if(nx< 0 || ny<0 || nx>=n || ny>=n) continue;
            if(chk[nx][ny]) continue;
            
            chk[nx][ny]=true;
            if(map[nx][ny] < map[x][y]) {
                DFS(nx, ny, count+1, flag);
            }
            else {
            	if(flag==true && (map[nx][ny]-k < map[x][y])) {
                    int orgin = map[nx][ny];
                    map[nx][ny] = map[x][y]-1;
                  	DFS(nx, ny, count+1, false);
                    map[nx][ny] = orgin;
                }
            }
            chk[nx][ny]=false;
        }
        chk[x][y]=false;
    }
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt(); k = sc.nextInt();
            map=new int[n][n];
            
            int highest= 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++){
                    map[i][j] = sc.nextInt();
                    highest = Math.max(map[i][j], highest);
                }
            }
            
            chk = new boolean[n][n];
            max = 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++){
                    if(map[i][j]==highest){
                        DFS(i, j, 1, true);
                    }
                }
            }
            
            System.out.println("#"+test_case+" "+max);
        }
    }
}
```
