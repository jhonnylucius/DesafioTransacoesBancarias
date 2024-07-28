import java.util.Scanner;

public class TransacoesBancaria {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lê a Entrada que informa o saldo inicial da conta
        System.out.print("Informe o saldo inicial: ");
        double saldoInicial = scanner.nextDouble();

        // Cria uma nova conta bancária com o saldo inicial
        ContaBancaria conta = new ContaBancaria(saldoInicial); 

        // Lê a Entrada com o valor do deposito e aciona o método "depositar"
        System.out.print("Informe o valor do depósito: ");
        double valorDeposito = scanner.nextDouble();
        conta.depositar(valorDeposito);

        // Lê a Entrada com o valor do saque e aciona o método "sacar"
        System.out.print("Informe o valor do saque: ");
        double valorSaque = scanner.nextDouble();
        conta.sacar(valorSaque);

        // Fechar o scanner para evitar vazamentos de recursos
        scanner.close();
    }
}

class TransacoesBancarias {
    private double saldo;

    // O saldo inicial é definido no construtor
    public void TransacoesBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Deposito feito.");
        imprimirSaldo();
    }

    public void sacar(double valor) {
        if (saldo >= valor) {
            this.saldo -= valor;
            System.out.println("Saque feito.");
        } else {
            System.out.println("Saldo insuficiente. Saque não realizado.");
        }
        imprimirSaldo();
    }
    
    private void imprimirSaldo() {
        System.out.printf("Saldo atual: %.1f\n", this.saldo);
    }

}