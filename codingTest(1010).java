
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
//    네이버 오피스 셀(Cell)이나 마이크로소프트 엑셀(Excel)과 같은 스프레드시트 프로그램은
//    열(column)을 표시하기 위해 알파벳 대문자를 사용합니다.
//    예를 들면 1열=A, 2열=B, 26열=Z 와 같이 표시되고,
//      26열이 넘어가면 앞쪽에 문자 하나를 추가해서 27열=AA, 28열=AB, 52열=AZ, 53열=BA가 되며,
//    동일한 원리로 ZZ의 다음 열은 AAA, AAB, ... 처럼 이어집니다.
//
//    숫자를 입력받으면 그 순서에 대응되는 스프레드시트 컬럼을 출력하는 프로그램을 작성하세요.
//
//    입력
//    입력은 다음과 같습니다.
//        1
//        10
//        100
//        1000
//        10000
//    출력
//    아래와 같이 출력합니다.
//            A
//            J
//            CV
//            ALL
//            NTP
//
//    출처) 사이냅소프트 채용퀴즈

    //1. A부터 Z까지의 알파벳 길이를 상수로 선언
    private static final int ALPHABET_LENGTH = 26;

    //2. A부터 Z까지 배열에 담아놓은 메서드
    private List<Character> setAlphabetList() {
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i <= 'Z' - 'A'; i++) {
            int a = 65 + i;
            characters.add((char) a);
        }
        return characters;
    }
    //3. A부터 Z까지 넣어둔 배열에서 인덱스를 입력하면 해당 문자로 반환시키게 하는 메서드
    private char setCH(int no) {
        if(no>26){no = no%26;}
        return setAlphabetList().get(no - 1);
    }
    //4. 매개변수로 숫자를 입력하게 되면 해당 문자열로 변환시켜주는 메서드
    public String fromNumberToString(int no) {
        //4-1. 문자열 결합을 위하여 StringBuilder 선언
        StringBuilder str = new StringBuilder();
        //4-2. no값 n 변수에 사전 할당
        int number = no;
        //4-/3 나눈 몫을 순차적으로 저장하기 위하여 배열 선언
        List<Integer> list = new ArrayList<>();
        //4-4. 매개변수 no의 값이 26보다 같거나 작으면
        if(no<=ALPHABET_LENGTH){
            return setCH(no)+"";
        }
        else {
            while(number>1){

                //나눈 몫이 1보다 작아질때까지 계속 나누고
                number = number/ALPHABET_LENGTH;
                //이를 배열에 저장시켜줌
                list.add(number);
            }
            //매개변수가 1000일 경우,
            // 첫번째 인덱스에는 38 (1000/26 = 38)
            // 두번째 인덱스에는 1 (38/26 = 1)이 들어감
            // 1000/26 = 38.xx
            //38 = 38/26 = 1.xx

            //배열을 통해서 순차적으로 나누게 된 최종적인 몫이 가장 앞으로 위치시켜야하므로 배열 순서를 반전시킨 뒤
            Collections.reverse(list);
            //매개변수에서 26을 나눈 나머지를 배열에 저장시킴
            list.add(no%ALPHABET_LENGTH);
        }
        for(int i = 0; i<list.size();i++){
            //list 값이 0인 경우 해당 요소를 삭제시킴
            if(list.get(i)==0){
                list.remove(i);
            }
            //그 뒤 걸러지는 요소들에 대하여 앞서 StringBuilder에 선언했던 문자열로 결합시킴
            str.append(setCH(list.get(i)));
        }
        return str.toString();
    }



    public static void main(String[] args) {
        Solution sol = new Solution();
        String s1 = sol.fromNumberToString(1);
        System.out.println("s1 = " + s1);
        String s2 = sol.fromNumberToString(10);
        System.out.println("s2 = " + s2);
        String s3 = sol.fromNumberToString(100);
        System.out.println("s3 = " + s3);
        String s4 = sol.fromNumberToString(1000);
        System.out.println("s4 = " + s4);
        String s5 = sol.fromNumberToString(10000);
        System.out.println("s5 = " + s5);

    }
}
