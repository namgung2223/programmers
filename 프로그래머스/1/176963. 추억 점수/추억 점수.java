import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        Map<String,Integer> personAndScore = new HashMap<>();
        int[] result = new int[photo.length];
    
        for(int i=0; i<name.length; i++){
            personAndScore.put(name[i],yearning[i]);
        }
        
        for(int i=0; i<photo.length; i++){
            String[] people = photo[i];
            int score = 0;
            
            for(int j=0; j<people.length; j++){
                String personName = people[j];
                if(personAndScore.containsKey(personName)){
                    score += personAndScore.get(personName);
                }
            }
            result[i] = score;
            
        }
        
        
       
        return result;
    }
}