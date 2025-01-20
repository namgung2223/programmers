
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String,Integer> poketmonStringKey = new HashMap<>();
        HashMap<Integer,String> poketmonIntegerKey = new HashMap<>();

        for(int i = 0; i < N; i++){
            String poketmon = br.readLine();
            poketmonStringKey.put(poketmon, i+1);
            poketmonIntegerKey.put(i+1, poketmon);
        }

        for(int i = 0; i < M; i++){
            String regex = "^[0-9]*$";
            String key = br.readLine();
            if(Pattern.matches(regex, key)){
                System.out.println(poketmonIntegerKey.get(Integer.parseInt(key)));
            }else{
                System.out.println(poketmonStringKey.get(key));
            }
        }

    }
}