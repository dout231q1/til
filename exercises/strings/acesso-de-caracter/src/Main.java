public class Main {
    public static void main(String[] args) {
        String texto = "Java";

        // Acesso de caracter

        for(int i = 0; i < texto.length(); i++){
            System.out.printf("Indice: %d, Caracter: %s%n", i, texto.charAt(i));
        }
    }
}