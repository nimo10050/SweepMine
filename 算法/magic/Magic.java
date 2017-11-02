import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while(sc.hasNext()) {
            int coinCount =  sc.nextInt();
            while(coinCount>0) {
                if(coinCount%2==0) {
                    coinCount = (coinCount-2)/2;
                    sb.append("2");
                }else {
                    coinCount = (coinCount-1)/2;
                    sb.append("1");
                }
            }
            System.out.print(sb.reverse());
        }
         
    }
}