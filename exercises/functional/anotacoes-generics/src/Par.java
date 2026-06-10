// classe generica com dois parametros de tipo:
// A = tipo livre (qualquer coisa, ex: String)
// B = restrito a Number e suas subclasses (Integer, Double, etc.)
public class Par<A, B extends Number> {
    A primeiro;
    B segundo;

    public Par(A p, B s) {
        this.primeiro = p;
        this.segundo = s;
    }

    // usa intValue() de Number para verificar se o segundo valor é par
    // funciona para qualquer subclasse de Number graças ao bound "B extends Number"
    boolean eNumeroPar() {
        return segundo.intValue() % 2 == 0;
    }
}