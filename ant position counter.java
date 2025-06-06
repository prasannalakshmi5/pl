import java.util.Scanner;
public class Main{
    public static int countReturnsToStart(int N,int[]A){
        int position=0;
        int count=0;
        for(int move:A){
        position +=move;
        if(position==0){
            count++;
        }
    }
    return count;
}
public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    System.out.print("enter the number moves:");
    int N=sc.nextInt();
    System.out.println("enter the moves separated by space(1 or -1:");
    int[]A=new int[N];
    for(int i=0;i<N;i++){
        A[i]=sc.nextInt();
    }
    int result=countReturnsToStart(N,A);
    System.out.println("Number of times ant returned to starting position:"+result);
    sc.close();
   }
}