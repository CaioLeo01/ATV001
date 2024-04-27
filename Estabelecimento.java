class Estabelecimento {
    private String nome;
    private Conta conta;

    public Estabelecimento(String nome) {
        this.nome = nome;
        this.conta = new Conta();
    }

    public String getname() {
        return nome;
    }

    public Conta getConta() {
        return conta;
    }
}