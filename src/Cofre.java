import java.util.Scanner;

abstract class Cofre {
  protected String tipo;
  protected String metodoAbertura;

  public Cofre(String tipo, String metodoAbertura) {
    this.tipo = " Cofre " + tipo;
    this.metodoAbertura = metodoAbertura;
  }

  public void imprimirInformacoes() {
    System.out.println("Tipo: " + this.tipo);
    System.out.println("Metodo de abertura: " + this.metodoAbertura);
  }
}

class CofreDigital extends Cofre {

  private int senha;

  public CofreDigital(int senha) {
    super("Digital", "Senha");
    this.senha = senha;
  }

  public boolean validarSenha(int senhaDigitada) {
    return senhaDigitada == this.senha;
  }
}

class CofreFisico extends Cofre {

  public CofreFisico() {
    super("Fisico", "Chave");
  }

}

class Desafio {
  public static void main(String[] args) {
    // Lê o tipo de cofre (primeira linha da entrada)
    System.out.print("Digite o Tipo do Cofre:");
    Scanner scanner = new Scanner(System.in);
    String tipoCofre = scanner.nextLine();
    
    // Implementa a condição necessário para a verificação dos cofres seguros:
    if (tipoCofre.equalsIgnoreCase("digital")) {
      System.out.print("Senha: ");
      int senha = scanner.nextInt();
      scanner.nextLine(); // Consumir a quebra de linha
      System.out.print("Confirmação da senha: ");
      int confirmacaoSenha = scanner.nextInt();
      scanner.nextLine(); // Consumir a quebra de linha

      CofreDigital cofreDigital = new CofreDigital(senha);
      cofreDigital.imprimirInformacoes();
      if (cofreDigital.validarSenha(confirmacaoSenha)) {
        System.out.println("Cofre aberto!");
      } else {
        System.out.println("Senha incorreta!");
      }
    } else if (tipoCofre.equalsIgnoreCase("fisico")) {
      CofreFisico cofreFisico = new CofreFisico();
      cofreFisico.imprimirInformacoes();
    } else {
      System.out.println("Tipo de cofre inválido.");
    }

    scanner.close();
  }
}