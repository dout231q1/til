import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, List<Double>> alunos = new HashMap<>();
        alunos.put("John", List.of( 9.8, 5.3, 0.7));
        alunos.put("Harry", List.of(6.2, 3.5, 9.5));
        alunos.put("Robin", List.of(7.2, 1.5, 2.1));

        for(String aluno : alunos.keySet()) {
            System.out.println(aluno);
        }

        System.out.println(alunos.get("John"));
    }
}