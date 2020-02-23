class Solution {
    public int solution(String name) {
        int answer = 0;
        StringBuilder nameStr = new StringBuilder();
        for (int i = 0; i < name.length(); i++) nameStr.append(name.charAt(i));
        StringBuilder tmpStr = new StringBuilder();
        for (int i = 0; i < name.length(); i++) tmpStr.append("A");

        int index = 0;
        while (!tmpStr.toString().equals(name)) {
            answer += Math.min(name.charAt(index) - 'A', 'Z' - name.charAt(index) + 1);
            nameStr.setCharAt(index, 'A');
            int front = index;
            int back = index;
            int frontA = 0;
            int backA = 0;

            if (nameStr.toString().equals(tmpStr.toString())) break;

            while (nameStr.charAt((front + 1) % name.length()) == 'A') {
                front = (front + 1) % name.length();
                frontA++;
            }
            front = (front + 1) % name.length();

            while (nameStr.charAt((back + name.length() - 1) % name.length()) == 'A') {
                back = (back + name.length() - 1) % name.length();
                backA++;
            }
            back = (back + name.length() - 1) % name.length();

            if (frontA > backA) {
                index = back;
                answer += backA+1;
            } else {
                index = front;
                answer += frontA+1;
            }
        }
        return answer;
    }
}