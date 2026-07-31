public class Main {
    interface Validador<T>{
        boolean validar(T valor);
    }

    static <T> Validador<T> combinar(Validador<T> v1, Validador<T> v2){
        return new Validador<T>(){
            @Override
            public boolean validar(T valor) {
                return v1.validar(valor) && v2.validar(valor);
            }
        };
    }

    public static void main(String[] args) {

        // forma explicita com classe anonima
        Validador<String> naoVazia = new Validador<String>(){
            @Override
            public boolean validar(String valor){
                return !valor.isEmpty();
            }
        };

        Validador<String> minimoCinco = new Validador<String>(){
            @Override
            public boolean validar(String valor){
                return valor.length() >= 5;
            }
        };

        Validador<String> ambos = combinar(naoVazia, minimoCinco);

        // forma reduzida com lambda
//        Validador<String> naoVazia = valor -> !valor.isEmpty();
//        Validador<String> minimoCinco = valor -> valor.length() >= 5;

        System.out.println(naoVazia.validar("")); // false
        System.out.println(minimoCinco.validar("Oi")); // false
        System.out.println(ambos.validar("Salve")); // true
    }
}