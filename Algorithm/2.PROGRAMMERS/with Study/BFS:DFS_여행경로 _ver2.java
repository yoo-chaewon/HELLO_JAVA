import java.util.*;
class Solution {
    static ArrayList<String> results = new ArrayList<>();
    public static String[] solution(String[][] tickets) {
        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[1].compareTo(o2[1]);
            }
        });

        for (int i = 0; i < tickets.length; i++) {
            String start = tickets[i][0];
            String end = tickets[i][1];
            if (start.equals("ICN")) {
                boolean[] visited = new boolean[tickets.length];

                visited[i] = true;
                DFS(tickets, visited, end, 1, "ICN");
                visited[i] = false;
            }
        }
        return results.get(0).split(" ");
    }

    public static void DFS(String[][] ticket, boolean[] visited, String start, int depth, String result) {
        if (depth  == ticket.length) {
            results.add(result + " " + start);
            return;
        }

        for (int i = 0; i < ticket.length; i++) {
            if (!visited[i] && ticket[i][0].equals(start)) {

                visited[i] = true;
                DFS(ticket, visited, ticket[i][1], depth + 1, result + " " + ticket[i][0]);
                visited[i] = false;

            }
        }
    }
}
