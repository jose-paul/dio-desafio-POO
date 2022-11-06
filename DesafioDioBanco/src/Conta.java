public abstract class Conta implements IConta{

    //Variaveis
    private static final int Agencia_Padrao = 1;
    private static int Sequencial =1;
    protected int agencia;
    protected int numero;
    private double saldo;

    private Cliente cliente;

    //Construtor
    public Conta(Cliente cliente) {
        this.agencia = Conta.Agencia_Padrao;
        this.numero = Sequencial++;
        this.cliente = cliente;
    }


    //Metodos

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void sacar(double valor) {
        if(saldo > valor){
            saldo -= valor;
            System.out.println("Valor retirado - R$" + valor);
        }else System.out.println("Não é possivel retirar o valor, não tem saldo suficiente!");

    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Valor depositado R$ " + valor + "\nValor disponivel atual R$" + saldo);
    }

    @Override
    public void tranferir(double valor, Conta contaDestino) {
        if(this.getSaldo() > valor){
            this.sacar(valor);
            contaDestino.depositar(valor);
            System.out.println("Valor retirado - R$" + valor);
        }else System.out.println("Não é possivel retirar o valor, não tem saldo suficiente!");
    }

    @Override
    public void extratoBancario() {
        System.out.println(String.format("Agencia %d" , this.agencia));
        System.out.println(String.format("Numero %d" , this.numero));
        System.out.println(String.format("Cliente: %s", this.cliente.getNome()));
        System.out.println("Saldo Disponivel " + this.saldo);
    }

}
