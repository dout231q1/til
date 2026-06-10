import java.util.*;

// Pipeline de pedidos com validador, processador e relator usando classes anônimas.

public class Pipeline {
    public static class Pedido {
        private static int contador = 0;
        private int id;
        private String cliente;
        private double valor;
        private String cupom;
        private boolean pago;

        public Pedido(String cliente, double valor, String cupom, boolean pago){
            this.cliente = cliente;
            this.valor = valor;
            this.cupom = cupom;
            this.pago = pago;
            id = ++contador;
        }

        public int getId(){return id;}
        public String getCliente(){return cliente;}
        public double getValor(){return valor;}
        public String getCupom(){return cupom;}
        public boolean isPago(){return pago;}
        public void setValor(double v){this.valor = v;}
        public void setPago(boolean p){this.pago = p;}

        @Override
        public String toString(){
            return String.format("Pedido %d | Cliente %s | Valor R$ %.2f | pago = %b", id, cliente, valor, pago);
        }
    }

    interface Validador {
        void validar(Pedido p) throws Exception;
    }

    interface Processador {
        void processar(Pedido p);
    }

    interface Relator {
        String relatar(Pedido p);
    }

    // estrutura interna da pipeline e metodos de execucao

    private List<Validador> validadores = new ArrayList<>();
    private List<Processador> processadores = new ArrayList<>();
    private List<Relator> relatores = new ArrayList<>();

    public Pipeline addValidador(Validador v){validadores.add(v); return this;}
    public Pipeline addProcessador(Processador pr){processadores.add(pr); return this;}
    public Pipeline addRelator(Relator r){relatores.add(r); return this;}

    public void executar(Pedido p)throws Exception {
        for (Validador v : validadores) v.validar(p);
        for (Processador pr : processadores) pr.processar(p);
        for (Relator r : relatores) System.out.println(r.relatar(p));
    }

    public static void main(String[] args) {

        // instanciacao da pipeline e dos pedidos

        Pipeline pipeline = new Pipeline();
        Pedido p1 = new Pedido("Pedro", 150.0, "PROMO10", false);
        Pedido p2 = new Pedido("Nathan", 530.0, "promo10", false);
        Pedido p3 = new Pedido("Joao", 0, "PROMO10", false);

        // configuracao da pipeline (validadores, processadores, relatores)

        pipeline
            .addValidador(new Validador(){
                @Override
                public void validar(Pedido p) throws Exception{
                    if(p.getValor() <= 0 || p.getCliente().isBlank()) {
                        throw new Exception("Pedido " + p.getId() + " cancelado por valor insuficiente e/ou cliente sem nome.");
                    }
                }
            })
            .addValidador(new Validador(){
                @Override
                public void validar(Pedido p) throws Exception{
                    if(p.isPago()){
                        throw new Exception("Pedido " + p.getId() + " ja esta marcado como pago.");
                    }
                }
            })
            .addProcessador(new Processador(){
                @Override
                public void processar(Pedido p){
                    if(p.getCupom().equals("PROMO10")){
                        System.out.println("Aplicando cupom 'PROMO10'..");
                        System.out.println("Cupom aplicado!");
                        p.setValor(p.getValor() - (p.getValor() * 0.1));
                    }
                    if(p.getCupom().isBlank()){
                        System.out.println("Nenhum cupom aplicado.");
                    }
                    else if(!p.getCupom().equals("PROMO10")){
                        System.out.println("Cupom invalido!");
                    }
                }
            })
            .addProcessador(new Processador(){
                @Override
                public void processar(Pedido p){
                    p.setPago(true);
                }
            })
            .addRelator(new Relator(){
                @Override
                public String relatar(Pedido p){
                    System.out.println("========================================================");
                    return p.toString();
                }
            }
        );

        // lista para executar todos os pedidos
        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(p1);
        pedidos.add(p2);
        pedidos.add(p3);
        for(Pedido p : pedidos){
            // execucao + tratamento de erro
            try {
                System.out.println("Processando pedido...");
                pipeline.executar(p);
                System.out.println("========================================================");
            } catch (Exception e){
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}
