import java.util.*;

public class Main{
    public static void main(String[] args){

        // LinkedHashSet para manter a ordem de insercao
        Set<String> primeirosVisitantes = new LinkedHashSet<>();

        primeirosVisitantes.add("John");
        primeirosVisitantes.add("Peter");
        primeirosVisitantes.add("Richard");
        primeirosVisitantes.add("Chuck");
        primeirosVisitantes.add("Garry");

        System.out.println(primeirosVisitantes);

        Set<String> segundosVisitantes = new LinkedHashSet<>();
        segundosVisitantes.add("John");
        segundosVisitantes.add("Peter");
        segundosVisitantes.add("William");
        segundosVisitantes.add("Connor");
        segundosVisitantes.add("Frederick");

        System.out.println(segundosVisitantes);

        Set<String> visitantes = new LinkedHashSet<>();

        // John e Peter de duplicata
        visitantes.addAll(primeirosVisitantes); visitantes.addAll(segundosVisitantes);
        
        System.out.println(visitantes); // output: John, Peter, Richard, Chuck, Garry, William, Connor, Frederick
    }
}