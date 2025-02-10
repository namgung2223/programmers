class Solution {
    public int solution(int n, int m, int[] section) {
        int count = 0; 
        int lastPainted = 0;

        for (int pos : section) {
            if (pos > lastPainted) { 
                count++;
                lastPainted = pos + m - 1; // 롤러가 덮을 수 있는 마지막 위치 갱신
            }
        }
        return count;
    }
}