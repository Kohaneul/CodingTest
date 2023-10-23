/**
  x축과 y축으로 이루어진 2차원 직교 좌표계에 중심이 원점인 서로 다른 크기의 원이 두 개 주어집니다. 반지름을 나타내는 두 정수 r1, r2가 매개변수로 주어질 때, 두 원 사이의 공간에 x좌표와 y좌표가 모두 정수인 점의 개수를 return하도록 solution 함수를 완성해주세요.
※ 각 원 위의 점도 포함하여 셉니다.

제한 사항
1 ≤ r1 < r2 ≤ 1,000,000

입출력 예
r1 : 2 
r2 : 3
result : 20

 
그림과 같이 정수 쌍으로 이루어진 점은 총 20개 입니다.
문제 : https://school.programmers.co.kr/learn/courses/30/lessons/181187
**/
 public long solution(int r1, int r2) {
        long answer = 0;
   //for문 안 인덱스 x를 1에서부터 r2 까지의 범위로 셋팅함
        for(int x =1; x<=r2;x++){
  //큰 반지름 과 작은반지름 사이의 원이기 때문에 각 r1, r2 넓이에서 x의 넓이를 빼주어 루트를 씌운 후
         // r2는 Math.floor > 버림으로 값 추출
            int max = (int) Math.floor(Math.sqrt((long) r2 * r2 - (long) x * x));
         // r1은 Math.ceil > 올림으로 값 추출 
            int min = (int) Math.ceil(Math.sqrt((long) r1 * r1 - (long) x * x));
            answer +=(max-min)+1;
        }
       answer = (answer)*4;

        return answer;
        }
