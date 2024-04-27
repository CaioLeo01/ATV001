import java.util.Random;

class Cliente extends Thread {
    private static final double INICIO_SALDO = 1000.00;
    private static final double[] COMPRA_VALORES = {100.00, 200.00};
    private String nomeCliente;
    private Conta contaCliente;
    private Estabelecimento[] arrayLojas;
    private Random randomizador;

    public Cliente(String nomeCliente, Estabelecimento[] arrayLojas) {
        this.nomeCliente = nomeCliente;
        this.contaCliente = new Conta(INICIO_SALDO);
        this.arrayLojas = arrayLojas;
        this.randomizador = new Random();
    }

    @Override
    public void run() {
     boolean comprou = false;
      while (true) {
     double valorCompra = COMPRA_VALORES[randomizador.nextInt(COMPRA_VALORES.length)]; 
     if (contaCliente.getSaldado() >= valorCompra) {
       comprou = true;
      for (Estabelecimento loja : arrayLojas) {
            synchronized (loja.getConta()) {
         if (contaCliente.getSaldado() >= valorCompra) {
          Banco.mover(contaCliente, loja.getConta(), valorCompra);
                System.out.println(nomeCliente + " realizou uma compra de R$" + valorCompra + " na loja " + loja.getname());
                        }
                    }
                }
            } else {
                break; 
            }
        }
        contaCliente.subtrair(contaCliente.getSaldado());
        System.out.println(nomeCliente + " encerrou suas compras. Saldo final: R$" + contaCliente.getSaldado());
    }

    public String getNome() {
        return nomeCliente;
    }

    public Conta getConta() {
        return contaCliente;
    }
}