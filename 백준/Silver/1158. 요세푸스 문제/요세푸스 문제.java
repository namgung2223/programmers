
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while(queue.size() != 1) {
            //K번째 이전까지의 값을 모두 반환하여 다시 삽입
            for (int i = 0; i < K - 1; i++) {
                queue.offer(queue.poll());
            }
            //K번째 값 추출
            sb.append(queue.poll() + ", ");
        }

        sb.append(queue.poll() + ">");
        System.out.println(sb);
        br.close();
    }

}
