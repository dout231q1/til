import java.util.*;

public class Main{

    public static class Produto{
        String nome;
        double preco;

        public Produto(String nome, double preco){
            this.nome = nome;
            this.preco = preco;
        }

        @Override
        public String toString(){
            return "Nome: " + nome + ", Preco: R$" + preco;
        }
    }

    public static void main(String[] args){
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Teclado Mecânico", 350.00));
        produtos.add(new Produto("Monitor Ultrawide", 1500.00));
        produtos.add(new Produto("Mouse Gamer", 120.00));
        produtos.add(new Produto("Webcam Full HD", 200.00));

        Produto maisCaro = produtos.get(0);

        System.out.println("===== Lista de Produtos =====\n");

        for(Produto produto : produtos){
            if(produto.preco > maisCaro.preco){
                maisCaro = produto;
            }
            System.out.println(produto);
        }
        System.out.println("\n===== Produto mais caro ===== \n" + maisCaro);
    }
}

