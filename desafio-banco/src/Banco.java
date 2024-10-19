import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas = new ArrayList<>();

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void listarContas() {
        System.out.println("=== Listagem de Contas ===");
        for (Conta conta : contas) {
            conta.imprimirExtrato();
        }
    }

    public void listarClientes() {
        System.out.println("=== Listagem de Clientes ===");
        for (Conta conta : contas) {
            Cliente cliente = conta.cliente;
            System.out.println(cliente.getNome());
            System.out.println("Conta " + conta.tipoDeConta);
            System.out.println("===============================");
        }
    }

    public Conta buscarContaPorNumero(int numero) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        return null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }
}
