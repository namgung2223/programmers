
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arrayInput = br.readLine();

            Deque<Integer> deque = new LinkedList<>();
            arrayInput = arrayInput.substring(1, arrayInput.length() - 1);
            if (!arrayInput.isEmpty()) {
                StringTokenizer st = new StringTokenizer(arrayInput, ",");
                while (st.hasMoreTokens()) {
                    deque.add(Integer.parseInt(st.nextToken()));
                }
            }

            boolean isReversed = false;
            boolean hasError = false;

            for (char cmd : command.toCharArray()) {
                if (cmd == 'R') {
                    isReversed = !isReversed;
                } else {
                    if (deque.isEmpty()) {
                        hasError = true;
                        break;
                    }
                    if (isReversed) {
                        deque.pollLast();
                    } else {
                        deque.pollFirst();
                    }
                }
            }

            if (hasError) {
                sb.append("error\n");
            } else {
                sb.append("[");
                while (!deque.isEmpty()) {
                    sb.append(isReversed ? deque.pollLast() : deque.pollFirst());
                    if (!deque.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]\n");
            }
        }
        System.out.print(sb);
    }
}
