import java.util.function.*;

public class Main{
    public static void main(String[] args) {

        Runnable r = () -> System.out.println("Ola");
        r.run();

        BiConsumer<Integer, Integer> bc = (a, b) -> System.out.println(a + b);
        bc.accept(1,2);

        Predicate<Integer> maiorQueDez = (x) -> x > 10;
        System.out.println(maiorQueDez.test(0));
    }
}