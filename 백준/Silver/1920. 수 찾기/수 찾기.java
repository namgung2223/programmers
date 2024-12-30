import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /*
    * 수 찾기
    * N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
    * 첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다.
    * 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다.
    * 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다.
    * 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다.
    * 모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.

    * 예제 입력
        5
        4 1 5 2 3
        5
        1 3 7 9 5
    *
    *
    * */
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        // 입력문
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 최대한 시간을 줄이기위해 StringBuilder사용

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 이진탐색은 정렬 후에 사용해야 하므로 선정렬

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < M; i++) {
            if (binarySearch(Integer.parseInt(st.nextToken())) >= 0 ) {
                sb.append(1).append("\n");
            } else sb.append(0).append("\n");
        }

        System.out.println(sb);
    }

    public static int binarySearch(int value){
        int start = 0;
        int end = arr.length-1;

        while(start <= end){
            int mid = (start + end) /2;
            if(value == arr[mid]){
                return 1;
            }else if(value < arr[mid]){
                end = mid -1;
            }else{
                start = mid +1;
            }
        }
        return -1;
    }
}