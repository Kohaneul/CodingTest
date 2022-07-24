public class Solution {


    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        List<String> ar1 = resultList(report, 0);
        List<String> ar2 = resultList(report, 1);
        Map<String, Integer> map = setMap(id_list, ar1, ar2);
        answer = setArr(id_list,map,k,ar1,ar2);
        return answer;
    }


    public Set<String> setSet(String[] report) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < report.length; i++) {
            set.add(report[i]);
        }
        return set;
    }

    public String setList(String[] report) {
        String str = "";
        Set<String> set = setSet(report);
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            str += iterator.next() + " ";
        }
        return str;
    }


    public List<String> resultList(String[] report, int no) {
        List<String> list = new ArrayList<>();
        String[] str = setList(report).split(" ");
        for (int i = 0; i < str.length; i++) {
            if (i % 2 == no) {
                list.add(str[i]);
            }
        }
        return list;
    }

    public Map<String,Integer> setMap(String[] id_list,List<String> ar1, List<String>ar2){
        Map<String,Integer>map = new HashMap<>();
        for(int i = 0; i<id_list.length;i++){
            int count  = 0;
            for(int j = 0; j<ar1.size();j++){
                if(id_list[i].equals(ar2.get(j))){
                    count++;
                }
            }
              map.put(id_list[i],count);
        }

    return map;
    }

    public int[] setArr(String[] id_list,Map<String,Integer> map, int k, List<String>ar1, List<String>ar2){
        Map<String,Integer>resultMap = new HashMap<>();
        List<String> list = new ArrayList<>();
        for(int i = 0; i<id_list.length;i++){
            if(k<=map.get(id_list[i])){
                list.add(id_list[i]);
                resultMap.put(id_list[i],1);
            }
            else{
                resultMap.put(id_list[i],0);
            }
        }

        for(int i = 0; i<list.size();i++){
            resultMap.put(list.get(i),0);
        }

        for(int i = 0; i<list.size();i++){
            int cnt = 0;
            for(int j = 0; j<ar1.size();j++){

                 if(list.get(i).equals(ar2.get(j))){
                     cnt++;
                     resultMap.put(ar1.get(j),cnt);
                 }
            }
        }

        int[] ar = new int[id_list.length];

        for(int i = 0; i<ar.length;i++){
            ar[i] = resultMap.get(id_list[i]);
        }


        return ar;


    }




    public static void main(String[] args) {
        String[] user = new String[]{"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        Solution sol = new Solution();
        int k= 3;
        int[] solution = sol.solution(user, report, k);

    }
}