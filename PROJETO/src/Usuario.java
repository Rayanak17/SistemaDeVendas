public abstract class Usuario {
    protected String nome;

    // construtor da classe Usuario
    // recebe como parâmetro o nome do usuário
    public Usuario(String nome) {
        this.nome = nome; // atribui o nome recebido como parâmetro ao atributo "nome" da classe Usuario
    }

    // obter o nome do usuário
    public String getNome() {
        return nome;
    }

    // definir o nome do usuário
    public void setNome(String nome) {
        this.nome = nome;
    }
}
