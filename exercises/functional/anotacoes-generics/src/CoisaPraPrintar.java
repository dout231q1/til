// classe generica restrita a tipos numericos (T extends Number)
// isso impede uso com String ou outros tipos nao numericos
public class CoisaPraPrintar<T extends Number> {
    T coisaPraPrintar;

    public CoisaPraPrintar(T c) {
        this.coisaPraPrintar = c;
    }

    // impressao com tratamento especial para Double: usa printf para 2 casas decimais
    // para outros tipos numericos, usa println normalmente
    public void print() {
        if (coisaPraPrintar instanceof Double) {
            System.out.printf("%.2f", coisaPraPrintar);
        } else {
            System.out.println(coisaPraPrintar);
        }
    }
}