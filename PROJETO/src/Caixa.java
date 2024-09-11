public class Caixa extends Funcionario {
    private String turno;

    // construtor da classe Caixa
    // recebe como parâmetros o nome, salário e turno do caixa
    public Caixa(String nome, double salario, String turno) {
       
        // chama o construtor da classe pai (Funcionario) passando o nome, salário e turno
        super(nome, salario, turno);
      
        // atribui o turno recebido como parâmetro ao atributo "turno" da classe Caixa
        this.turno = turno;
    }

    // obter o turno do caixa
    public String getTurno() {
        return turno;
    }

    // definir o turno do caixa
    public void setTurno(String turno) {
        this.turno = turno;
    }
}
