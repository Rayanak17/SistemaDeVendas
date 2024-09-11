public class Gerente extends Funcionario {
    // construtor da classe Gerente
    
    // recebe como parâmetros o nome, salário e turno do gerente
    public Gerente(String nome, double salario, String turno) {
        
        // chama o construtor da classe pai (Funcionario) passando o nome, salário e turno
        super(nome, salario, turno);
    }
}