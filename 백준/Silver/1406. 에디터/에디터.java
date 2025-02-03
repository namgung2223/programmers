
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String defalutTxt = br.readLine();
        LinkedList<Character> list = new LinkedList<>();

        for(int i = 0; i < defalutTxt.length(); i++) {
            list.add(defalutTxt.charAt(i));
        }

        ListIterator<Character> iter = list.listIterator(list.size());

        int M = Integer.parseInt(br.readLine());
        while(M --> 0){
            String command = br.readLine();
            char c = command.charAt(0);
            switch (c) {
                case 'L':
                    if (iter.hasPrevious()) iter.previous();
                    break;
                case 'D':
                    if (iter.hasNext()) iter.next();
                    break;
                case 'B':
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case 'P':
                    char t = command.charAt(2);
                    iter.add(t);
                    break;
            }
        }

        print(list);
    }

    private static void print(LinkedList<Character> list) {
        StringBuilder bw = new StringBuilder();
        for (char chr : list) {
            bw.append(chr);
        }
        System.out.println(bw);
    }
}
