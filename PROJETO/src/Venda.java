import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venda {
    private Date data;
    private List<Produto> produtos;
    private Funcionario vendedor;
    private String cliente;
    private double valorTotal;
    private double desconto;

    public Venda(Funcionario vendedor, String cliente) {
        this.data = new Date(); // data da venda como a data atual
        this.produtos = new ArrayList<>(); // inicia a lista de produtos da venda
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.valorTotal = 0.0; // inicia o valor total da venda como 0.0
        this.desconto = 20.0; // inicia o desconto como 0.0
    }

      public void adicionarProduto(Produto produto, int quantidade) {
        produtos.add(produto); // adiciona o produto à lista de produtos da venda
        valorTotal += produto.getPreco() * quantidade; // incrementa o valor total considerando a quantidade
    }


    // calcula o valor total da venda após desconto
    public double calcularValorTotal() {
        // verifica se o valor total é maior ou igual a 150 para aplicar desconto
        if (valorTotal >= 150.0) {
            return valorTotal - this.desconto;
        } else {
            return valorTotal; // sem desconto se valor total for menor que 150
        }
    }
    
    // getters e setters para os atributos da classe Venda
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Funcionario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Funcionario vendedor) {
        this.vendedor = vendedor;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
}
