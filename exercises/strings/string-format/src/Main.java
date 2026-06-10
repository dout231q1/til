public class Main {
    public static void main(String[] args){
        String minhaString = "Helicoptero";
        boolean meuBoolean = true;
        char meuChar = 'C';
        int meuInt = 50;
        double meuDouble = 1000;
        double meuSegundoDouble = -1000;
        System.out.printf("%b\n", meuBoolean);
        System.out.printf("%c\n", meuChar);
        System.out.printf("%d\n", meuInt);
        System.out.printf("%+3f\n", meuDouble); // .valorf limita os numeros depois da virgula
        System.out.printf("%+3f\n", meuSegundoDouble); // + ativa a flag de valor negativo e positivo, + como padrao porem se a variavel conter valor negativo, sera mostrado negativo
        System.out.printf("hello %100s", minhaString); // controla a largura de uma string, aqui sera escrito 100 vezes um espaco em branco

        String str = Integer.toString(meuInt);

        System.out.println("\n" + str+3);

    }
}