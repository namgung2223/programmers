
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) == Math.abs(o2)){
                    return o1 - o2;
                }else{
                    return Math.abs(o1) - Math.abs(o2);
                }
            }
        });

        while(N --> 0){
            Integer X = Integer.parseInt(br.readLine());
            if(X == 0){
                if(queue.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(queue.poll());
            }else{
                queue.offer(X);
            }
        }
    }
}