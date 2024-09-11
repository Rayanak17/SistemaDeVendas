public class Produto{
    private String nome;
    private String categoria;
    private double preco;
    private String descricao;
    private int quantidadeestoque;
    private String fornecedor;

public Produto(String nome, String categoria, String fornecedor, double preco, int quantidadeEstoque, String descricao) {
        this.nome = nome;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
        this.preco = preco;
        this.quantidadeestoque = quantidadeEstoque;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeestoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeestoque = quantidadeEstoque;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // aplica desconto ao preço do produto
    public void aplicarDesconto(double desconto) {
        this.preco -= desconto;
    }

    // adiciona quantidade ao estoque
    public void adicionarEstoque(int quantidade) {
        this.quantidadeestoque += quantidade;
    }

    //remove quantidade do estoque
    public void removerEstoque(int quantidade) {
        if (quantidade <= this.quantidadeestoque) {
            this.quantidadeestoque -= quantidade;
        } else {
            System.out.println("Quantidade insuficiente em estoque.");
        }
    }
}
