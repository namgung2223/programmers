
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    /*
문제
정수를 저장하는 덱(Deque)를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 여덟 가지이다.

push_front X: 정수 X를 덱의 앞에 넣는다.
push_back X: 정수 X를 덱의 뒤에 넣는다.
pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 덱에 들어있는 정수의 개수를 출력한다.
empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.

입력
첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.

출력
출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.

예제 입력 1
15
push_back 1
push_front 2
front
back
size
empty
pop_front
pop_back
pop_front
size
empty
pop_back
push_front 3
empty
front

    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = 0;
        StringBuilder sb = new StringBuilder();
        DequeueClass dequeueClass = new DequeueClass();
        while (N > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            switch (str){
                case "push_front":
                    dequeueClass.pushFront(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    dequeueClass.pushBack(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    sb.append(dequeueClass.popFront());
                    dequeueClass.appendEnter(sb);
                    break;
                case "pop_back":
                    sb.append(dequeueClass.popBack());
                    dequeueClass.appendEnter(sb);
                    break;
                case "size":
                    sb.append(dequeueClass.size());
                    dequeueClass.appendEnter(sb);
                    break;
                case "empty":
                    sb.append(dequeueClass.isEmpty());
                    dequeueClass.appendEnter(sb);
                    break;
                case "front":
                    sb.append(dequeueClass.peekFirst());
                    dequeueClass.appendEnter(sb);
                    break;
                case "back":
                    sb.append(dequeueClass.peekLast());
                    dequeueClass.appendEnter(sb);
                    break;
            }
            N--;
        }
        System.out.println(sb);
    }

    public static class DequeueClass{

        private Deque<Integer> deque;
        public DequeueClass(){
            this.deque = new ArrayDeque<>();
        }

        public void pushFront(Integer X){
            deque.addFirst(X);
        }
        public void pushBack(Integer X){
            deque.addLast(X);
        }

        public Integer popFront(){
            Integer frontValue = deque.pollFirst();
            return frontValue == null ? -1 : frontValue;
        }
       public Integer popBack(){
           Integer lastvalue = deque.pollLast();
            return lastvalue == null ? -1 : lastvalue;
        }

        public Integer size(){
            return deque.size();
        }

        public Integer isEmpty(){
            return deque.isEmpty() ? 1 : 0;
        }
        public Integer peekFirst(){
           return deque.peekFirst() == null ? -1 : deque.peekFirst();
        }
        public Integer peekLast(){
            return deque.peekLast() == null ? -1 : deque.peekLast();
        }


        public void appendEnter(StringBuilder st){
            st.append("\n");
        }


    }
}