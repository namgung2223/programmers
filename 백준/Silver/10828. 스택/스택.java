import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static   void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MyStack myStack = new MyStack();
        int N = Integer.parseInt(br.readLine());

        if(N < 1 || 10000 < N ){
            br.close();
            System.out.println("error");
        }else{
            StringBuilder sb = new StringBuilder();
           for(int i=0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String order = st.nextToken();

               switch (order) {
                   case "push":
                       int value = Integer.parseInt(st.nextToken());
                       myStack.push(value);
                       break;
                   case "pop":
                       sb.append(myStack.pop()).append("\n");
                       break;
                   case "size":
                       sb.append(myStack.size()).append("\n");
                       break;
                   case "empty":
                       sb.append(myStack.empty()).append("\n");
                       break;
                   case "top":
                       sb.append(myStack.top()).append("\n");
                       break;
                   default:
                       sb.append("Invalid command").append("\n");
                       break;
               }
            }
            br.close();
            System.out.print(sb.toString());
        }
    }


    static class MyStack {
        private Stack<Integer> mstack;

        public MyStack() {
            this.mstack = new Stack<>();
        }

        public void push(int value) {
            this.mstack.push(value);
        }

        public int pop() {
            if (this.mstack.isEmpty()) {
                return -1;
            }
            return this.mstack.pop();
        }

        public int size() {
            return this.mstack.size();
        }

        public int empty() {
            return this.mstack.isEmpty() ? 1 : 0;
        }

        public int top() {
            if (this.mstack.isEmpty()) {
                return -1;
            }
            return this.mstack.peek();
        }
    }
}