CCTV가 있을 때마다 ArrayList에 x좌표, y좌표, 그리고 무슨 카메라였는지 저장</br>
그후 order() 함수를 실행하는데 이때 만약 `L==cctv_cnt`가 되었다는 말은 한 번 수행이 끝났다는 의미이므로</br>
사각지대의 개수를 세어줘야 한다

아니면 일단 그 CCTV가 무슨 타입이었는지 확인</br>
(CCTV는 1부터 시작하므로 -1을 해서 0부터 시작하게끔 해준다)</br>
그 후 cam[type][4]를 확인하는데, 여기에는 CCTV가 움직일 수 있는 방향의 개수가 들어있음</br>
그 개수만큼 도는데, 만약 cam[type][j]가 1이라면, 즉 그쪽으로 볼 수 있다면</br>
watch 함수를 돌려서 감시</br>
watch 함수에서 map 함수를 갱신해놓으니까 다시 map함수를 되돌리기 위해 copymap 함수 수행

***
감시 카메라 방향을 백트래킹을 이용해서 구해준 후, 그 방향따라 카메라를 봐야한다고 생각</br>
너무 복잡하게 생각한듯