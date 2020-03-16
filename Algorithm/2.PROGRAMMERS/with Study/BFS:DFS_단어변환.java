class Solution {
    static int answer = Integer.MAX_VALUE;
    static String mtarget;
    static String[] mwords;
    static boolean[] visited;
    static boolean flag = false;

    public static int solution(String begin, String target, String[] words) {
        mtarget = target;
        mwords = words;
        visited = new boolean[words.length];
        DFS(begin, 0);

        if (flag) return answer;
        else return 0;
    }

    public static void DFS(String cur, int count) {
        if (cur.equals(mtarget)) {
            answer = Math.min(count, answer);
            flag = true;
            return;
        }

        for (int i = 0; i < mwords.length; i++) {
            if (!visited[i]) {
                int tmp = 0;
                for (int j = 0; j < mtarget.length(); j++) {
                    if (cur.charAt(j) == mwords[i].charAt(j)) tmp++;
                }
                if (tmp >= mtarget.length()-1) {
                    visited[i] = true;
                    DFS(mwords[i], count + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
