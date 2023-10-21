package com.project.concertView.web;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/*
*
* 철수는 롤케이크를 두 조각으로 잘라서 동생과 한 조각씩 나눠 먹으려고 합니다. 이 롤케이크에는 여러가지 토핑들이 일렬로 올려져 있습니다. 철수와 동생은 롤케이크를 공평하게 나눠먹으려 하는데, 그들은 롤케이크의 크기보다 롤케이크 위에 올려진 토핑들의 종류에 더 관심이 많습니다. 그래서 잘린 조각들의 크기와 올려진 토핑의 개수에 상관없이 각 조각에 동일한 가짓수의 토핑이 올라가면 공평하게 롤케이크가 나누어진 것으로 생각합니다.

예를 들어, 롤케이크에 4가지 종류의 토핑이 올려져 있다고 합시다. 토핑들을 1, 2, 3, 4와 같이 번호로 표시했을 때, 케이크 위에 토핑들이 [1, 2, 1, 3, 1, 4, 1, 2] 순서로 올려져 있습니다. 만약 세 번째 토핑(1)과 네 번째 토핑(3) 사이를 자르면 롤케이크의 토핑은 [1, 2, 1], [3, 1, 4, 1, 2]로 나뉘게 됩니다. 철수가 [1, 2, 1]이 놓인 조각을, 동생이 [3, 1, 4, 1, 2]가 놓인 조각을 먹게 되면 철수는 두 가지 토핑(1, 2)을 맛볼 수 있지만, 동생은 네 가지 토핑(1, 2, 3, 4)을 맛볼 수 있으므로, 이는 공평하게 나누어진 것이 아닙니다. 만약 롤케이크의 네 번째 토핑(3)과 다섯 번째 토핑(1) 사이를 자르면 [1, 2, 1, 3], [1, 4, 1, 2]로 나뉘게 됩니다. 이 경우 철수는 세 가지 토핑(1, 2, 3)을, 동생도 세 가지 토핑(1, 2, 4)을 맛볼 수 있으므로, 이는 공평하게 나누어진 것입니다. 공평하게 롤케이크를 자르는 방법은 여러가지 일 수 있습니다. 위의 롤케이크를 [1, 2, 1, 3, 1], [4, 1, 2]으로 잘라도 공평하게 나뉩니다. 어떤 경우에는 롤케이크를 공평하게 나누지 못할 수도 있습니다.

롤케이크에 올려진 토핑들의 번호를 저장한 정수 배열 topping이 매개변수로 주어질 때, 롤케이크를 공평하게 자르는 방법의 수를 return 하도록 solution 함수를 완성해주세요.

제한사항
1 ≤ topping의 길이 ≤ 1,000,000
1 ≤ topping의 원소 ≤ 10,000
입출력 예
topping	result
[1, 2, 1, 3, 1, 4, 1, 2]	2
[1, 2, 3, 1, 4]	0
입출력 예 설명
입출력 예 #1

롤케이크를 [1, 2, 1, 3], [1, 4, 1, 2] 또는 [1, 2, 1, 3, 1], [4, 1, 2]와 같이 자르면 철수와 동생은 각각 세 가지 토핑을 맛볼 수 있습니다. 이 경우 공평하게 롤케이크를 나누는 방법은 위의 두 가지만 존재합니다.
입출력 예 #2

롤케이크를 공평하게 나눌 수 없습니다.
* *
* */
@Slf4j
public class Solution2 {
    public int topping(int[] topping) {
        /**
         * 1. 나 : Set , 상대방 : Map 객체 선언
         * 2. 상대방에 모든 토핑을 선 할당하고, key : 토핑종류, value : 토핑갯수로 선셋팅함.
         * 3. 그 뒤 내 객체에 순차적으로 추가
         * 4. 3번을 수힝함과 동시에 상대방의 토핑 갯수를 하나씩 차감시킨다
         * 5. value 값이 0이 될시 해당 key,value 값은 삭제
         * 6. 내 토핑갯수와, 상대방이 갯수가 동일할 경우 answer++로 경우의 수 하나 추가
         * */
        int answer = 0;
        int size = topping.length;
        //1번
        Set<Integer> me = new HashSet<>();
        Map<Integer,Integer> you = new HashMap<>();
        //2번
        for(int i = 0; i<size ;i++){
            you.put(topping[i],you.getOrDefault(topping[i],0)+1);
        }
        for(int i = 0; i<topping.length;i++){
         //3번
            me.add(topping[i]);
            System.out.println("yours.get(topping[i]) = " + you.get(topping[i]));
        //4번
            you.put(topping[i],you.getOrDefault(topping[i],0)-1);
            System.out.println("--yours.get(topping[i]) = " + you.get(topping[i]));
        //5번    
            if(you.get(topping[i])==0) {
                you.remove(topping[i]);
            }
        //6번    
            if(me.size()==you.size()){
                answer++;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        int[] weight = new int[]{1, 2, 3, 1, 4};
        Solution2 sol = new Solution2();
        int topping = sol.topping(weight);
        System.out.println(" ");
        System.out.println("topping = " + topping);

    }
}
