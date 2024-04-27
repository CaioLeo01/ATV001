class Banco {
    public static void mover(Conta de, Conta para, double quantia) {
        de.subtrair(quantia);
        para.abonar(quantia);
    }

    public static void mostrarSaldosFinais(Estabelecimento[] lojas, Funcionario[][] equipe, Cliente[] clientela) {
        System.out.println("\n--------------------------------\n");
        System.out.println("Saldo final das lojas:");
        System.out.println("\n--------------------------------\n");
        for (Estabelecimento loja : lojas) {
            System.out.println("Saldo na conta da " + loja.getname() + " : " + loja.getConta().getSaldado());
        }
        
        System.out.println("\n--------------------------------\n");
        System.out.println("Saldo final dos funcionários:");
        System.out.println("\n--------------------------------\n");
        for (Funcionario[] equipeLoja : equipe) {
            for (Funcionario funcionario : equipeLoja) {
                System.out.println("Saldo da conta salário do funcionário " + funcionario.getNome() + " : " + funcionario.getContaSalario().getSaldado());
                System.out.println("Saldo da conta investimento do funcionário " + funcionario.getNome() + " : \n" + funcionario.getFundoDeInvestimento().getSaldado()); 
            }
        }
        System.out.println("\n--------------------------------\n");
        System.out.println("Saldo final dos clientes:");
        System.out.println("\n--------------------------------\n");
        for (Cliente cliente : clientela) {
            System.out.println("Saldo da conta do cliente " + cliente.getNome() + ": " + cliente.getConta().getSaldado());
        }
    }
}
