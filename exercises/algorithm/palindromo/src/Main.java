import java.util.Arrays;

public class Main {
    public static String inverter(String texto){

        // Palindromo usando ponteiros

        char[] caracteres = texto.toCharArray();
        int esquerdo = 0; int direito = texto.length()-1; // para pegar o ultimo index
        while(esquerdo < direito){
            char temp = caracteres[esquerdo];
            caracteres[esquerdo] = caracteres[direito];
            caracteres[direito] = temp;
            esquerdo++; // para mover o ponteiro pro centro
            direito--; // mesma coisa
        }
        return new String(caracteres); // converte a array de volta pra string
    }

    public static boolean verificaPalindromo(String texto){
        String textoInvertido = inverter(texto);
        return textoInvertido.equalsIgnoreCase(texto); // retorna true ou false
    }
    public static void main(String[] args) {
        System.out.println(inverter("Java"));
        System.out.println(verificaPalindromo("Ovo"));
    }
}