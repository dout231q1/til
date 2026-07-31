import java.util.*;

public class Main{
    static void listaDeMedias(){
        class Aluno{
            String nome;
            double notaUm;
            double notaDois;

            public Aluno(String nome, double notaUm, double notaDois){
                this.nome = nome;
                this.notaUm = notaUm;
                this.notaDois = notaDois;
            }
        }
            List<Aluno> lista = new ArrayList<>();
            lista.add(new Aluno("John", 9.8, 5.3));
            lista.add(new Aluno("Harry", 6.2, 3.5));
            lista.add(new Aluno("Robin", 7.2, 1.5));

            for(Aluno aluno : lista){
                double mediaDoAluno = (aluno.notaUm + aluno.notaDois)/2;
                String situacaoDoAluno;
                if(mediaDoAluno > 7.0){
                    situacaoDoAluno = "Aprovado";
                } else{
                    situacaoDoAluno = "Reprovado";
                }
                System.out.println("Nome do aluno: " + aluno.nome
                        + "\nNotas do aluno: " + aluno.notaUm + " | " + aluno.notaDois
                        + "\nMedia do aluno: " + String.format("%.2f", mediaDoAluno)
                        + "\nSituacao final do aluno: " + situacaoDoAluno
                        + "\n=================================="
                );

            }
    }

    public static void main(String[] args){
        listaDeMedias();
    }
}