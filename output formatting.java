import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("================================");
            for(int i=0;i<3;i++){
                String s1=sc.next();
                int x=sc.nextInt();
                 int temp = x;
            int len = s1.length();

            System.out.print(s1);
            for(int j =1; j<= 15-len; j++ ){
               System.out.print(" "); 
            }
            int cnt =0;
            while(temp!= 0 ){
                  temp /= 10;
                  cnt ++;   
            }
                if(cnt == 3){
                  System.out.println(x);  
                }
                else if (cnt == 2){
                System.out.println("0"+x);}
                else
                    System.out.println("00"+x);
            }
            System.out.println("================================");
    }
}



