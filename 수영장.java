import java.util.Scanner;
import java.io.FileInputStream;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
		{
			int day = sc.nextInt();
            int month = sc.nextInt();
            int month_3 = sc.nextInt();
            int year = sc.nextInt();
            
            int price[]=new int[13];
            for(int i=1; i<=12; i++)
                price[i] = sc.nextInt();
            
            int dp[]=new int[13];
            for(int i=1; i<=12; i++) {  // 1일권으로 구매 vs 1달권 구매
            	if(price[i] != 0)
                    dp[i] = price[i] * day;
                
              dp[i] = Math.min(dp[i], month);
            }
            
            for(int i=1; i<=12; i++){

            	if(i>=3){  //3달권 구매 vs 1일 혹은 1달권 구매
                	dp[i] = Math.min(dp[i-3]+month_3, dp[i-1]+dp[i]);
              }
              else
                  dp[i] +=dp[i-1];
            }
            
            
            int result = Math.min(dp[12], year);  //1년 구매 vs 그외 구매
            System.out.println("#"+test_case+" "+result);
			
		}
	}
}


***
처음에 dp에 누적합이 들어가는 게 아니고 그 달에 내야하는 돈을 넣어놓음
-> 3달권을 구매하기로 마음 먹었다면 어떤 인덱스에 값을 넣어야하는지가 애매

1달, 3달.. 같은 것을 dp[i-1], dp[i-3] 으로 표현할 수 있다는 생각을 하기
