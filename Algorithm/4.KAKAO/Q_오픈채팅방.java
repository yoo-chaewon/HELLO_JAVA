import java.util.*;
class Solution {
    public static String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();//uid, nickname
        for (String input : record){
            String[] inputs = input.split(" ");
            if (inputs[0].equals("Enter")|| inputs[0].equals("Change")){
                map.put(inputs[1], inputs[2]);

            }
        }
        ArrayList<String> result = new ArrayList<>();
        for (String input :record){
            String[] inputs = input.split(" ");
            switch (inputs[0]){
                case "Enter":
                    result.add(map.get(inputs[1]) + "님이 들어왔습니다.");
                    break;
                case "Leave":
                    result.add(map.get(inputs[1]) + "님이 나갔습니다.");
                    break;
            }
        }

        return result.toArray(new String[result.size()]);
    }
}