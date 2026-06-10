// classe generica basica restrita a Number
// o bound "T extends Number" garante que so tipos numericos podem ser usados
public class Calculadora<T extends Number> {
    T valor;
}