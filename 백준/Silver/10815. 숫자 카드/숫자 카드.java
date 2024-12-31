
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arrn;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arrn = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arrn[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrn);

        int X = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < X; i++){
            int num = Integer.parseInt(st.nextToken());

            bw.write(BinarySeach(num) + " ");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    public static int BinarySeach(int num){
        int left = 0;
        int right = N-1;

        while(left <= right){
            int middle = (left + right)/2;
            int middleValue = arrn[middle];

            if(num > middleValue){
                left = middle +1;
            }else if(num < middleValue){
                right = middle -1;
            }else return 1;
        }
        return 0;
    }
}
