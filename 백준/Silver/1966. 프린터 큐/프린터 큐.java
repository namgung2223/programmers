import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static LinkedList<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            // 문서 개수
            int N = Integer.parseInt(st.nextToken());
            // 몇 번째로 인쇄 되는지
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                queue.add(new int[]{i, Integer.parseInt(st.nextToken())});
            }
            sb.append(getNumber(M)).append("\n");
        }
        System.out.println(sb);
    }

    static int getNumber(int M){
        int number = 0;
        while(!queue.isEmpty()){
            int[] X = queue.poll();
            boolean check = true;

            for(int i = 0; i < queue.size(); i++){
                if(X[1] < queue.get(i)[1]){
                    queue.add(X);
                    for(int j = 0; j < i; j++){
                        queue.add(queue.poll());
                    }
                    check = false;
                    break;
                }
            }

            if(check){
                number++;
                if(X[0] == M) break;
            }
        }
        return number;
    }
}