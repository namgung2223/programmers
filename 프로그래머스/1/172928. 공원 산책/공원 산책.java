import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] locate = new int[2];  
        
        //시작 위치
        for (int i = 0; i < park.length; i++) {
            int locateSIndex = park[i].indexOf('S'); 
            if (locateSIndex != -1) {
                locate = new int[]{i, locateSIndex}; 
                break;
            }
        }
        
        //명령
        for (String route : routes) {
            String[] parts = route.split(" ");
            String direction = parts[0];  // 방향
            int move = Integer.parseInt(parts[1]); // 이동 거리
            
            // 이동 전 원래 위치 저장
            int newRow = locate[0];
            int newCol = locate[1];
            
            boolean isValid = true;
            
            // 이동 거리만큼 한 칸씩 이동하면서 확인
            for (int j = 0; j < move; j++) {
                if (direction.equals("E")) newCol++; // 동쪽
                else if (direction.equals("W")) newCol--; // 서쪽
                else if (direction.equals("S")) newRow++; // 남쪽
                else if (direction.equals("N")) newRow--; // 북쪽
                
                // 공원 경계를 벗어나거나 장애물을 만나면 이동 취소
                if (newRow < 0 || newRow >= park.length || 
                    newCol < 0 || newCol >= park[0].length() || 
                    park[newRow].charAt(newCol) == 'X') {
                    isValid = false;
                    break;
                }
            }
            
            // 이동이 유효하면 최종 위치 반영
            if (isValid) {
                locate[0] = newRow;
                locate[1] = newCol;
            }
        }
        
        return locate;
    }
}
