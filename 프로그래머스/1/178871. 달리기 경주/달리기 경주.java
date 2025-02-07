import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> ranking = new HashMap<>();
        int n = players.length;

        for (int i = 0; i < n; i++) {
            ranking.put(players[i], i);
        }

        for (String player : callings) {
            int idx = ranking.get(player);
            if (idx > 0) {
                String frontPlayer = players[idx - 1];
              
                players[idx - 1] = player;
                players[idx] = frontPlayer;
                
                ranking.put(player, idx - 1);
                ranking.put(frontPlayer, idx);
            }
        }

        return players;
    }
}
