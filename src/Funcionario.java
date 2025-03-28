import java.time.LocalDate;  // Importa a classe LocalDate para lidar com datas
import java.time.Period;     // Importa a classe Period para calcular a diferença entre datas

public class Funcionario {
    private String nome, cargo;
    private LocalDate anoContratacao;
    private float salarioMensal;

    public Funcionario(String nome, String cargo, LocalDate anoContratacao, float salarioMensal) {
        this.nome = nome;
        this.cargo = cargo;
        this.anoContratacao = anoContratacao;
        this.salarioMensal = salarioMensal;
    }

    public int anosTrabalhados(){
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(anoContratacao, dataAtual);
        return periodo.getYears();
    }

    public void exibirInformacoes(){
        System.out.println("\nNome: "+ nome);
        System.out.println("Cargo: "+ cargo);
        System.out.println("Anos trabalhados na empresa: " + anosTrabalhados()+"\n");
        System.out.println("Salário atual: " + salarioMensal + "\n");
    }

    public void reajusteSalario(String tipoReajuste, int percentual) {
        if (tipoReajuste.equalsIgnoreCase("Aumento")) {
            salarioMensal += salarioMensal * (percentual / 100.0);
            System.out.println("Salário atualizado!");
        } else if (tipoReajuste.equalsIgnoreCase("Decréscimo")) {
            salarioMensal -= salarioMensal * (percentual / 100.0);
            System.out.println("Salário atualizado!");
        } else {
            System.out.println("Tipo de reajuste inválido.");
        }
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public LocalDate getAnoContratacao() {
        return anoContratacao;
    }
    public void setAnoContratacao(LocalDate anoContratacao) {
        this.anoContratacao = anoContratacao;
    }
    public float getSalarioMensal() {
        return salarioMensal;
    }
    public void setSalarioMensal(float salarioMensal) {
        this.salarioMensal = salarioMensal;
    }
    @Override
    public String toString() {
        return "Funcionario [nome=" + nome + ", cargo=" + cargo + ", anoContratacao=" + anoContratacao
                + ", salarioMensal=" + salarioMensal + "]";
    }
}