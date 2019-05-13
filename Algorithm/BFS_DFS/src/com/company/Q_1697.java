package com.company;

import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_1697 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(st.nextToken());//수빈위치
        int K = Integer.parseInt(st.nextToken());//동생위치
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        int[] map = new int[100000 + 1];
        while (queue.isEmpty() == false) {
            int temp = queue.poll();
            if (temp == K){
                System.out.print(map[temp]);
                return;
            }
            int[] next = new int[3];
            next[0] = temp + 1;
            next[1] = temp - 1;
            next[2] = 2 * temp;

            for (int i = 0; i < 3; i++) {
                if (next[i] < 0 || next[i] > 100000 || map[next[i]] != 0) {
                    continue;
                }
                map[next[i]] = map[temp] + 1;
                queue.add(next[i]);
            }
        }
    }
}
