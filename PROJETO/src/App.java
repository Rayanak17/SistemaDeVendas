import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Produto> produtos = new ArrayList<>();
        List<Funcionario> funcionarios = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();
        List<Fornecedor> fornecedores = new ArrayList<>();
        List<Venda> vendas = new ArrayList<>();

        while (true) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarProduto(scanner, produtos);
                    break;

                case 2:
                    adicionarUsuario(scanner, funcionarios, clientes, fornecedores);
                    break;

                case 3:
                    registrarVenda(scanner, funcionarios, produtos, vendas);
                    break;

                case 4:
                    listarProdutos(produtos);
                    break;

                case 5:
                    listarVendas(vendas);
                    break;

                case 6:
                    System.out.println("Buscar produto:");
                    String nome = scanner.nextLine();
                    Produto produto = buscarProduto(produtos, nome);
                    if (produto != null){
                        System.out.println("Nome: " + produto.getNome());
                        System.out.println("Preço: " + produto.getPreco());
                        System.out.println("Quantidade: " + produto.getQuantidadeEstoque());
                    }
                    else{
                        System.out.println("Produto não encontrado");
                    }
                    break;

                case 7: 
                    System.out.println("Obrigado por utilizar nosso sistema. Programa encerrado.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\nMenu:");
        System.out.println("1 - Adicionar produto");
        System.out.println("2 - Adicionar usuário (Cliente, Funcionário, Fornecedor)");
        System.out.println("3 - Registrar venda");
        System.out.println("4 - Relatório de produtos em estoque");
        System.out.println("5 - Relatório de vendas");
        System.out.println("6 - Buscar produto");
        System.out.println("7 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void adicionarProduto(Scanner scanner, List<Produto> produtos) {
        System.out.print("Nome do produto: ");
        String nomeProduto = scanner.nextLine();
        System.out.print("Categoria do produto: ");
        String categoria = scanner.nextLine();
        System.out.print("Fornecedor do produto: ");
        String fornecedor = scanner.nextLine();
        System.out.print("Preço do produto: ");
        double preco = scanner.nextDouble();
        System.out.print("Quantidade em estoque: ");
        int quantidadeEstoque = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Descrição do produto: ");
        String descricao = scanner.nextLine();

        produtos.add(new Produto(nomeProduto, categoria, fornecedor, preco, quantidadeEstoque, descricao));
        System.out.println("Produto adicionado com sucesso!");
    }

    private static void adicionarUsuario(Scanner scanner, List<Funcionario> funcionarios, List<Cliente> clientes, List<Fornecedor> fornecedores) {
        System.out.println("Tipo de usuário (1 - Cliente, 2 - Funcionário, 3 - Fornecedor): ");
        int tipoUsuario = scanner.nextInt();
        scanner.nextLine();

        switch (tipoUsuario) {
            case 1:
                adicionarCliente(scanner, clientes);
                break;
        
            case 2:
                adicionarFuncionario(scanner, funcionarios);
                break;
            case 3:
                adicionarFornecedor(scanner, fornecedores);
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
                break;
        }
    }

    private static void adicionarFuncionario(Scanner scanner, List<Funcionario> funcionarios) {
        System.out.println("Tipo de funcionário (1 - Vendedor, 2 - Caixa, 3 - Gerente): ");
        int tipoFuncionario = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome do funcionário: ");
        String nomeFuncionario = scanner.nextLine();
        System.out.print("Salário do funcionário: ");
        double salario = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Turno do funcionário: ");
        String turno = scanner.nextLine();

        Funcionario funcionario = null; //polimorfismo
        switch (tipoFuncionario) {
            case 1:
                funcionario = new Vendedor(nomeFuncionario, salario, turno);
                break;
            case 2:
                funcionario = new Caixa(nomeFuncionario, salario, turno);
                break;
            case 3:
                funcionario = new Gerente(nomeFuncionario, salario, turno);
                break;
            default:
                System.out.println("Tipo de funcionário inválido! Tente novamente.");
                return;
        } //polimorfismo

        if (funcionario != null) {
            funcionarios.add(funcionario);
            Collections.sort(funcionarios, new Comparator<Funcionario>() {
                @Override
                public int compare(Funcionario f1, Funcionario f2) {
                    return f1.getNome().compareTo(f2.getNome()); //essa parte é interface
                }
            });
            System.out.println("Funcionário adicionado com sucesso!");
        }
    }

    private static void adicionarCliente(Scanner scanner, List<Cliente> clientes) {
        System.out.print("Nome do Cliente: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("Endereço do Cliente: ");
        String endereco = scanner.nextLine();
        System.out.print("Telefone do Cliente: ");
        String telefone = scanner.nextLine();
        System.out.print("CPF do Cliente: ");
        String cpf = scanner.nextLine();

        Cliente cliente = new Cliente(nomeCliente, endereco, telefone, cpf);
        clientes.add(cliente);
        System.out.println("Cliente adicionado com sucesso!");
    }

    private static void adicionarFornecedor(Scanner scanner, List<Fornecedor> fornecedores) {
        System.out.print("Nome do Fornecedor: ");
        String nomeFornecedor = scanner.nextLine();
        System.out.print("Endereço do Fornecedor: ");
        String endereco = scanner.nextLine();
        System.out.print("Telefone do Fornecedor: ");
        String telefone = scanner.nextLine();
        System.out.print("CNPJ do Fornecedor: ");
        String cnpj = scanner.nextLine();

        Fornecedor fornecedor = new Fornecedor(nomeFornecedor, endereco, telefone, cnpj);
        fornecedores.add(fornecedor);
        System.out.println("Fornecedor adicionado com sucesso!");
    }

    private static void registrarVenda(Scanner scanner, List<Funcionario> funcionarios, List<Produto> produtos, List<Venda> vendas) {
        System.out.print("Nome do cliente: ");
        String cliente = scanner.nextLine();
        System.out.println("Escolha um vendedor pelo índice:");
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i) instanceof Vendedor) {
                System.out.println((i + 1) + " - " + funcionarios.get(i).getNome());
            }
        }

        try { //exceção
            int vendedorIndex = scanner.nextInt();
            scanner.nextLine(); 

            Venda venda = new Venda(funcionarios.get(vendedorIndex - 1), cliente);
            System.out.println("Escolha produtos pelo índice (-1 para finalizar):");
            while (true) {
                for (int i = 0; i < produtos.size(); i++) {
                    System.out.println((i + 1) + " - " + produtos.get(i).getNome() + " (R$ " + produtos.get(i).getPreco() + ") - Estoque: " + produtos.get(i).getQuantidadeEstoque());
                }
                int produtoIndex = scanner.nextInt();
                if (produtoIndex == -1) break;
                System.out.print("Quantidade:");
                int quantidadeVendida = scanner.nextInt();
                scanner.nextLine();

                Produto produto = produtos.get(produtoIndex - 1);
                if (quantidadeVendida <= produto.getQuantidadeEstoque()) {
                    venda.adicionarProduto(produto, quantidadeVendida);
                    produto.removerEstoque(quantidadeVendida);
                    System.out.println("Produto adicionado à venda!");
                } else {
                    System.out.println("Quantidade insuficiente em estoque.");
                }
            }
            vendas.add(venda);
            System.out.println("Venda registrada com sucesso!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Opção inválida: " + e.getMessage());
        } //exceção
    }

    private static void listarProdutos(List<Produto> produtos) {
        System.out.println("Lista de produtos:");
        for (Produto p : produtos) {
            System.out.println(p.getNome() + " (" + p.getCategoria() + ") - R$ " + p.getPreco() + " - Estoque: " + p.getQuantidadeEstoque());
        }
    }

    private static void listarVendas(List<Venda> vendas) {
        System.out.println("Lista de vendas:");
        for (Venda v : vendas) {
            System.out.println("Data: " + v.getData() + " - Cliente: " + v.getCliente() + " - Vendedor: " + v.getVendedor().getNome() + " - Valor Total: R$ " + v.calcularValorTotal());
            System.out.println("Produtos:");
            for (Produto p : v.getProdutos()) {
                System.out.println(" - " + p.getNome() + " (R$ " + p.getPreco() + ")");
            }
        }
    }

    private static Produto buscarProduto(List<Produto> lista, String nome) {
        for (Produto produto : lista) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return produto;
            }
        }
        return null;
    }
 
}
