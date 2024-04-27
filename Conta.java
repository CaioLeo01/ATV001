class Conta {
    private double saldo;

    public Conta() {
        this.saldo = 0.0;
    }

    public Conta(double Valorincipiente) {
        this.saldo = Valorincipiente;
    }

    public synchronized void abonar(double valor) {
        saldo += valor;
    }

    public synchronized void subtrair(double valor) {
        saldo -= valor;
    }

    public synchronized double getSaldado() {
        return saldo;
    }
}