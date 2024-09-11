public class Vendedor extends Funcionario {

    // construtor da classe Vendedor
    // recebe como parâmetros o nome, salário e turno do vendedor
    public Vendedor(String nome, double salario, String turno) {
    
        // chama o construtor da classe pai (Funcionario) passando o nome, salário e turno
        super(nome, salario, turno);
    }
}