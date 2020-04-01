class Solution {
    public static void main(String[] args) {
        System.out.println(solution(8, 12));
    }

    public static long solution(int w, int h) {
        long wl = Long.parseLong(String.valueOf(w));
        long hl = Long.parseLong(String.valueOf(h));
        return wl * hl - (wl + hl - GCD(w, h));
    }

    public static long GCD(int w, int h) {
        long big = Math.max(w, h);
        long small = Math.min(w, h);

        while (small != 0) {
            long tmp = big % small;
            big = small;
            small = tmp;
        }
        return big;
    }
}