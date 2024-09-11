public class Fornecedor extends Usuario {
    private String nome;
    private String endereco;
    private String telefone;
    private String cnpj;

    // construtor
    public Fornecedor(String nome, String endereco, String telefone, String cnpj) {
        super(nome);
        this.endereco = endereco;
        this.telefone = telefone;
        this.cnpj = cnpj;
    }

    // métodos getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
