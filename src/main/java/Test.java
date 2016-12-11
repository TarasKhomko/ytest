/**
 * Created by taras on 09.12.2016.
 */
public class Test {
    public static void main(String[] args) {
        int a = (int) (Math.random() * (20000 + 2)) - 10000;
       a = Math.abs(a);
        String s = String.valueOf(a);
        System.out.println("+380 96 749 "+s);
    }
}