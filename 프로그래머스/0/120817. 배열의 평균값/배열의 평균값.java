class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        int totalSum = 0;
        for(int i=0; i<numbers.length; i++){
            totalSum += numbers[i];
        }
        answer = (double) totalSum / numbers.length;
        return answer;
    }
}