
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) { // 입력이 있는 동안 반복
            BigDecimal N = sc.nextBigDecimal();  // 초기 저금액
            BigDecimal B = sc.nextBigDecimal();  // 이자율 (%)
            BigDecimal M = sc.nextBigDecimal();  // 목표 금액

            double months = Math.ceil(
                    Math.log(M.divide(N, 10, RoundingMode.HALF_UP).doubleValue()) /
                            Math.log(1 + B.divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP).doubleValue())
            );

            // 결과 출력
            System.out.printf("%.0f%n", months);
        }

        sc.close();
    }
}