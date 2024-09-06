import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Por favor, digite o número da Agência: ");
        String branchNumber = scanner.nextLine();

        System.out.print("Por favor, digite o número da Conta: ");
        int accountNumber = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Por favor, digite o nome do Cliente: ");
        String clientName = scanner.nextLine();

        System.out.print("Por favor, digite o saldo inicial: ");
        double balance = scanner.nextDouble();

        String formattedBalance = String.format("%.2f", balance);

        String message = "Olá " + clientName + ", obrigado por criar uma conta em nosso banco, " +
                "sua agência é " + branchNumber + ", conta " + accountNumber +
                " e seu saldo R$" + formattedBalance + " já está disponível para saque.";

        System.out.println(message);

        scanner.close();
    }
}