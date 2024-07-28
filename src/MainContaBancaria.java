import java.util.Scanner;

public class MainContaBancaria {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lê as informações da conta poupança
        System.out.print("Nome do titular: ");
        String nomeTitular = scanner.nextLine();
        System.out.print("Número da conta: ");
        int numeroConta = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha restante
        System.out.print("Saldo inicial: ");
        double saldoInicial = scanner.nextDouble();
        scanner.nextLine(); // Consumir a quebra de linha restante
        System.out.print("Taxa de juros: ");
        double taxaJuros = scanner.nextDouble();

        // Cria uma conta poupança
        ContaPoupanca contaPoupanca = new ContaPoupanca(nomeTitular, numeroConta, saldoInicial, taxaJuros);

        // Exibe as informações da conta poupança
        contaPoupanca.exibirInformacoes();

        scanner.close();
    }
}

class ContaBancaria {
    protected double saldo;

    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Depósito feito.");
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

    protected void imprimirSaldo() {
        System.out.printf("Saldo atual: %.1f\n", this.saldo);
    }
}

class ContaPoupanca extends ContaBancaria {
    private String nomeTitular;
    private int numeroConta;
    private double taxaJuros;

    public ContaPoupanca(String nomeTitular, int numeroConta, double saldoInicial, double taxaJuros) {
        super(saldoInicial);
        this.nomeTitular = nomeTitular;
        this.numeroConta = numeroConta;
        this.taxaJuros = taxaJuros;
    }

    public void exibirInformacoes() {
        System.out.println("Conta Poupanca:");
        System.out.println(nomeTitular);
        System.out.println(numeroConta);
        System.out.printf("Saldo: R$ %.1f\n", saldo);
        System.out.printf("Taxa de juros: %.1f%%\n", taxaJuros);
    }
}