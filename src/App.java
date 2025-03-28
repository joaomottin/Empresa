import java.util.Scanner;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
         /* Funcionario funcionario1 = new Funcionario("João", "Estagiário", LocalDate.parse("2010-07-31"), 5000);*/
        Funcionario[] funcionarios = {
            new Funcionario("João", "Gerente", LocalDate.parse("2010-07-31"), 5000),
            new Funcionario("Maria", "Analista", LocalDate.parse("2015-05-20"), 4500)
        };

        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n---MENU---");
            System.out.println("1. Informações do funcionário");
            System.out.println("2. Reajustar salário");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    for (int i = 0; i < funcionarios.length; i++) {
                        funcionarios[i].exibirInformacoes();
                    }
                    break;

                case 2:
                    System.out.print("Digite o nome do funcionário que deseja alterar o salário: ");
                    String nomeFuncionario = scanner.nextLine();
                    boolean encontrado = false;

                    for (int i = 0; i < funcionarios.length; i++) {
                        if (funcionarios[i].getNome().equalsIgnoreCase(nomeFuncionario)) {
                            System.out.print("Aumento ou Decréscimo? ");
                            String tipoReajuste = scanner.nextLine();
                            System.out.print("Qual será o percentual? ");
                            int percentual = scanner.nextInt();
                            scanner.nextLine(); // Limpar buffer

                            funcionarios[i].reajusteSalario(tipoReajuste, percentual);
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Funcionário não encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
