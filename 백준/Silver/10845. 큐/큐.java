import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Queue10845 que = new Queue10845();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(1<= N && N <= 10000){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String order = st.nextToken();
                switch (order){
                    case "push" :
                        int value = Integer.parseInt(st.nextToken());
                        que.push(value);
                        break;
                    case "front" :
                        sb.append(que.front()).append("\n");
                        break;
                    case "back" :
                        sb.append(que.back()).append("\n");
                        break;
                    case "size" :
                        sb.append(que.size()).append("\n");
                        break;
                    case "pop" :
                        sb.append(que.pop()).append("\n");
                        break;
                    case "empty" :
                        sb.append(que.empty()).append("\n");
                        break;
                }
            }
            System.out.println(sb);
        }

    }

    static class Queue10845{
        private Queue<Integer> queue;
        private int lastVal = 0;

        public Queue10845() {
            queue = new LinkedList<>();
        }

            public Integer push(Integer integer) {
                lastVal = integer;
                queue.add(lastVal);
                return lastVal;
            }

            public Integer pop() {
                if(queue.isEmpty()) return -1;
                else return queue.poll();
            }

            public Integer size() {return queue.size();}

            public Integer empty() {
                if(queue.isEmpty()) return 1;
                else return 0;
            }

            public Integer front(){
                if(queue.peek() == null) return -1;
                else return queue.peek();
            }

            public Integer back(){
                if(queue.isEmpty()) return -1;
                else return lastVal;
            }
    }
}
