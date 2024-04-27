public class Main {
    public static void main(String[] args) {
        Cliente[] arrayClientes = {
                new Cliente("Cliente 1", null),
                new Cliente("Cliente 2", null),
                new Cliente("Cliente 3", null),
                new Cliente("Cliente 4", null),
                new Cliente("Cliente 5", null)
        };

        Estabelecimento lojaUm = new Estabelecimento("Loja 1");
        Estabelecimento lojaDois = new Estabelecimento("Loja 2");

        Funcionario[] arrayFuncionariosLoja1 = {
                new Funcionario(new Conta(1400.00), new Conta(), "Funcionário 1"),
                new Funcionario(new Conta(1400.00), new Conta(), "Funcionário 2")
        };

        Funcionario[] arrayFuncionariosLoja2 = {
                new Funcionario(new Conta(1400.00), new Conta(), "Funcionário 3"),
                new Funcionario(new Conta(1400.00), new Conta(), "Funcionário 4")
        };

        for (Cliente cliente : arrayClientes) {
            cliente.start();
        }
        for (Funcionario funcionario : arrayFuncionariosLoja1) {
            funcionario.start();
        }

        for (Funcionario funcionario : arrayFuncionariosLoja2) {
            funcionario.start();
        }

        try {
            for (Cliente cliente : arrayClientes) {
                cliente.join();
            }

            for (Funcionario funcionario : arrayFuncionariosLoja1) {
                funcionario.join();
            }

            for (Funcionario funcionario : arrayFuncionariosLoja2) {
                funcionario.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Cliente cliente : arrayClientes) {
            cliente.getConta().subtrair(cliente.getConta().getSaldado());
        }

        Banco.mostrarSaldosFinais(new Estabelecimento[]{lojaUm, lojaDois}, new Funcionario[][]{arrayFuncionariosLoja1, arrayFuncionariosLoja2}, arrayClientes);
    }
}
