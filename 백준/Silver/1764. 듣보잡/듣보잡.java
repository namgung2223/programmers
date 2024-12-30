
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Map<String,Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        StringBuilder sb =new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //돋도 못한 수
        int N = Integer.parseInt(st.nextToken());
        //보도 못한 수
        int M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            map.put(br.readLine(),1);
        }

        for(int j=0; j<M; j++){
            String name = br.readLine();
            Integer orDefault = map.getOrDefault(name,0);
            map.put(name, orDefault + 1);
            if(map.get(name) == 2) list.add(name);
        }

        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for(String str : list)
            sb.append(str).append("\n");
        System.out.println(sb);

    }

}
