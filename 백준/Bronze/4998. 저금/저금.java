
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            double N = sc.nextDouble();  // 초기 저금액
            double B = sc.nextDouble();  // 이자율 (%)
            double M = sc.nextDouble();  // 목표 금액

            int months = 0;

            while (N < M) {
                N += N * (B / 100.0);
                months++;
            }

            System.out.println(months);
        }
        sc.close();
    }
}
