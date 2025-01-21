
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        br.close();
        int bongGi = 0;
        while(X>0){
            if(X % 5 == 0){
                bongGi += X/5;
                break;
            } else {
                X -= 3;
                bongGi += 1;
            }
            if(X < 0){
                System.out.println(-1);
                return;
            }
        }
        System.out.println(bongGi);
    }
}

