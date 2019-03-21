import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main  {



    public static int jump(int[][] b, int y, int x){


        //기저 사례
        if(x >= b[0].length || y >= b.length ){
            return 0;
        }

        if( x ==(b[0].length - 1) && y == b.length-1){
            return 1;
        }

            int v = b[y][x];
            int right = jump(b,y,x+v);
            int down = jump(b,y+v,x);
            int count = right + down;

            return count;



    }


    public static void main(String[] args){

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int c = Integer.parseInt(br.readLine());


            for(int i=0; i<c ; i ++){

                int n = Integer.parseInt(br.readLine()); //격자 크기

                int[][] board = new int[n][n];

                //격자판 입력 배열에 저장
                for(int y=0; y<n; y++){

                    StringTokenizer st = new StringTokenizer(br.readLine());

                    for (int x=0; x<n; x++){
                        board[y][x] = Integer.parseInt(st.nextToken());
                    }
                }



                int result = jump(board,0,0);

                if(result >= 1 ){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }





            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
