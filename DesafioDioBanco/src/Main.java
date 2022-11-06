public class Main {
    public static void main(String[] args) {

        Cliente c1 = new Cliente();
        c1.setNome("Jose");

        Conta cc = new ContaCorrente(c1);
        Conta cp = new ContaPoupanca(c1);

        cc.extratoBancario();
        cp.extratoBancario();

        cc.depositar(100);
        cc.tranferir(20, cp);

        cc.extratoBancario();
        cp.extratoBancario();



    }

}