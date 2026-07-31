public class Main {
    public static void main(String[] args) {

        // Comparacao de strings

        String texto = "Java";
        String texto2 = "java";

        if(texto.equals(texto2)){
            System.out.println("Os textos sao exatamente iguais.");
        } else if(texto.equalsIgnoreCase(texto2)){
            System.out.println("Se ignorarmos as cases, os textos sao iguais.");
        } else{
            System.out.println("Os textos nao sao iguais");
        }
    }
}