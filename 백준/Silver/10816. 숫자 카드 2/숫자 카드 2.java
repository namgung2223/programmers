
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< M; i++){
            int value = Integer.parseInt(st.nextToken());
            sb.append(endBound(value) - startBound(value)).append(" ");
        }
        System.out.println(sb);
    }

    public static int startBound(int value){
        int start = 0;
        int end = arr.length;

        while (start < end){
            int mid = (start + end)/2;
            if(value <= arr[mid]){
                end = mid;
            }else
                start = mid + 1;
        }
        return start;
    }

    public static int endBound(int value){
        int start = 0;
        int end = arr.length;

        while (start < end){
            int mid = (start + end)/2;
            if(value < arr[mid]){
                end = mid;
            }else
                start = mid + 1;
        }
        return start;
    }
}