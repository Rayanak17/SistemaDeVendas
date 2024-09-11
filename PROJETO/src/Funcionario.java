public abstract class Funcionario implements Comparable<Funcionario> { //interface
    private String nome;
    private double salario;
    private String turno;

    // construtor da classe Funcionario
    // recebe como parâmetros o nome, salário e turno do funcionário
    public Funcionario(String nome, double salario, String turno) {
        this.nome = nome;
        this.salario = salario;
        this.turno = turno;
    }

    // obter o nome do funcionário
    public String getNome() {
        return nome;
    }

    // definir o nome do funcionário
    public void setNome(String nome) {
        this.nome = nome;
    }

    // obter o salário do funcionário
    public double getSalario() {
        return salario;
    }

    // definir o salário do funcionário
    public void setSalario(double salario) {
        this.salario = salario;
    }

    // obter o turno do funcionário
    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Override //ordenar a lista de funcionário
    public int compareTo(Funcionario outroFuncionario) {
        return this.nome.compareTo(outroFuncionario.getNome());
    }
   
}