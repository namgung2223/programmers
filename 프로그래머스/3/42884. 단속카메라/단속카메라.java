import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));
        
        int count = 0;
        int lastCamera = Integer.MIN_VALUE;
        
        for(int[] route : routes){
            if(route[0] > lastCamera){
                count ++;
                lastCamera = route[1];
            }
        }
        
        return count;
        
    }
}