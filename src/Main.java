import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main  {

    public static void main(String[] args){

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int c = Integer.parseInt(br.readLine());    //테스트 케이스 ( [0,50] )

            for(int i=0; i<c ; i ++){

                int n = Integer.parseInt(br.readLine()); //수열의 원소 수( [0,500] )
                int[] array = new int[n];
                int[] check = new int[n];

                StringTokenizer st = new StringTokenizer(br.readLine());

                int index=0;
                while (st.hasMoreTokens()){
                    array[index] = Integer.parseInt(st.nextToken());
                    check[index] += 1;

                    int maxSum=0;
                    for(int j=index-1; j>=0; j--){
                        if(array[j] < array[index]){
                            if(maxSum < check[j]){
                                maxSum = check[j];
                            }
                        }
                    }

                    check[index] += maxSum;

                    index +=1;


                }


                int max=0;
                for(int r = 0; r < n; r++){
                    if(check[r] >= max){
                        max = check[r];
                    }


                }

                System.out.println(max);



            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
