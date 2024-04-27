class Funcionario extends Thread {
    private Conta contaSalario;
    private Conta InvestimentoBancario;
    private String nome;
    private double SalarioTotal;

    public Funcionario(Conta contaSalario, Conta InvestimentoBancario, String nome) {
        this.contaSalario = contaSalario;
        this.InvestimentoBancario = InvestimentoBancario;
        this.nome = nome;
        this.SalarioTotal = 1400.00;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (contaSalario) {
                if (contaSalario.getSaldado() >= SalarioTotal) {
                    double DinheiroInvestido = SalarioTotal * 0.20;
                    Banco.mover(contaSalario, InvestimentoBancario, DinheiroInvestido);
                    double ValorRemanescente00 = contaSalario.getSaldado();
                    double ValorRemanescente01 = SalarioTotal - DinheiroInvestido;
                    System.out.println("Saldo da conta de salário do funcionário " + nome + ": R$" + ValorRemanescente00);
                }
            }
            if (contaSalario.getSaldado() < SalarioTotal) break;
        }
    }

    public Conta getContaSalario() {
        return contaSalario;
    }

    public Conta getFundoDeInvestimento() {
        return InvestimentoBancario;
    }

    public String getNome() {
        return nome;
    }
}





// Saldo restante =  valor remanescente 
// contaInvestimento = InvestimentoBancario
//totalsalario = salario total