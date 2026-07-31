public class Main {
    public static void main(String[] args) {

        Carro c = () -> System.out.println("acelerar");
        c.acelerar();
        CarroAbstrato c2 = new CarroAbstrato(){
            @Override
            public void acelerar(){
                System.out.println("acelerar2");
            }
        };
        c2.acelerar();
        CarroClasse c3 = new CarroClasse(){
            @Override
            public void acelerar(){
                System.out.println("acelerar3");
            }
        };
        c3.acelerar();
        CarroClasseSegunda c4 = new CarroClasseSegunda(){};
        c4.acelerar();

    }
}