
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //연산의 개수
        int N = Integer.parseInt(br.readLine());

        while (N --> 0) {
            int X = Integer.parseInt(br.readLine());
            print(X);

        }
        br.close();
    }
    static void print(int X){
        if(X == 0){
            if(pq.isEmpty())
                System.out.println(0);
            else
                System.out.println(pq.poll());
        }else{
            pq.add(X);
        }
    }
}

