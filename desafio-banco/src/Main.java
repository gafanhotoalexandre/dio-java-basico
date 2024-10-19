public class Main {
    public static void main(String[] args) {
        Cliente marcio = new Cliente();
        marcio.setNome("Marcio Gomes");

        Conta cc = new ContaCorrente(marcio);
        cc.depositar(2000.0);
        Conta poupanca = new ContaPoupanca(marcio);
        poupanca.depositar(12000.5);

        Banco banco = new Banco();
        banco.setNome("Banco Sandesco");
        banco.adicionarConta(cc);
        banco.adicionarConta(poupanca);

        cc.transferir(500.0, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

        banco.listarContas();

        Conta contaEncontrada = banco.buscarContaPorNumero(cc.getNumero());
        if (contaEncontrada != null) {
            System.out.println("Conta encontrada:");
            contaEncontrada.imprimirExtrato();
        } else {
            System.out.println("Conta não encontrada.");
        }

        banco.listarClientes();
    }
}