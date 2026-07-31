public class Main {
    public static void main(String[] args) {
        String texto = "Java";
        System.out.println(inverter(texto));
    }

    public static String inverter(String texto){
        char[] caracteres = texto.toCharArray();
        int esquerdo = 0; int direito = caracteres.length-1; // -1 para pegarmos o ultimo indice
        while(esquerdo < direito){ // ponteiros caminham das pontas ao centro trocando os pares
            char temp = caracteres[esquerdo]; // variavel para guardar o valor do esquerdo
            caracteres[esquerdo] = caracteres[direito]; // esquerdo recebe direito
            caracteres[direito] = temp; // direito recebe o valor antigo do esquerdo
            esquerdo++; // soma mais um no valor do esquerdo para o ponteiro esquerdo mover para o centro
            direito--; // subtrai mais um no valor do direito para o ponteiro direito mover para o centro
        }
        return new String(caracteres); // converte a array de volta pra string
    }
}