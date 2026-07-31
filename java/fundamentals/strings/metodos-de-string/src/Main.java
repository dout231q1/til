public class Main{
    public static void main(String[] args) {
        String nome = "Luiz";
        System.out.println(nome.charAt(0)); // L

        System.out.println(nome.indexOf("z")); // 3

        String nome2 = "Gabriel";

        System.out.println(nome.concat(nome2)); // LuizGabriel

        String nome3 = "     Gabriel";

        System.out.println(nome3); //      Gabriel
        System.out.println(nome3.trim()); // Gabriel

        String nomeCompleto = "Luiz Gabriel";
        System.out.println(nomeCompleto.replace("i", "1")); // Lu1z Gabr1el

        System.out.println(nomeCompleto.substring(0,4)); // Luiz
        System.out.println(nomeCompleto.substring(5, 12)); // Gabriel

        System.out.println(nomeCompleto.startsWith("L")); // true

        System.out.println(nomeCompleto.endsWith("i")); // false

        System.out.println(nomeCompleto.trim().length()); // 12

        System.out.println(nome + " " + nome2); // Luiz Gabriel

        System.out.println(nome.toLowerCase()); // luiz
        System.out.println(nome.toUpperCase()); // LUIZ
    }
}