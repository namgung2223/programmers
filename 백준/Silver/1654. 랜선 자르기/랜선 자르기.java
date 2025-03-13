import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];
        int max = 0;

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] > max) max = arr[i]; // 가장 긴 랜선 찾기
        }

        long start = 1; // 최소 길이
        long end = max; // 최대 길이
        long result = 0; // 최적의 길이 저장

        while (start <= end) {
            long mid = (start + end) / 2; // 중간값 설정
            long sum = 0; // 잘린 랜선 개수 합

            for (int i = 0; i < K; i++) {
                sum += arr[i] / mid; // 현재 mid 길이로 잘랐을 때 나오는 랜선 개수
            }

            if (sum >= N) { // 충분히 많은 랜선을 만들 수 있는 경우
                result = mid;  // 최적의 길이 갱신
                start = mid + 1; // 더 긴 랜선을 만들 수 있는지 확인
            } else {
                end = mid - 1; // 길이가 너무 길면 줄이기
            }
        }

        System.out.println(result); // 최적의 길이 출력
    }
}
