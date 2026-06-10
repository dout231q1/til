public class Main {

    // Operacao usando classe anonima implementando uma interface

    interface Operacao {
        int calcular(int a, int b);
    }

    public static void main(String[] args) {
        Operacao o = new Operacao(){
          public int calcular(int a, int b){
              return a+b;
          }
        };

        System.out.println(o.calcular(1, 3)); // output: 4
    }
}