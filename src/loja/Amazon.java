package loja;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import usuario.Listable;
import static usuario.Listable.lista;

public class Amazon extends Loja {
    final private static String CNPJ = "30.245.907/0001-81";
    private static int quantidadeClientes = 0;
    protected static ArrayList<Conta> contas;
    protected static Conta contaLogada;

    public Amazon() {
        super();
        contas = new ArrayList<>();
        contaLogada = null;
    }

    public static boolean isLogado() {
        return contaLogada != null;
    }

    public static String getCNPJ() {
        return CNPJ;
    }

    public static int getQuantidadeClientes() {
        return quantidadeClientes;
    }

    public static void setQuantidadeClientes(int quantidadeClientes) {
        if (quantidadeClientes > 0) {
            Amazon.quantidadeClientes = quantidadeClientes;
        } else {
            JOptionPane.showMessageDialog(null, "Erro: A quantidade de clientes deve ser positiva.");
        }
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public Conta getContaLogada() {
        return contaLogada;
    }

    public ArrayList<Produto> getProdutos() {
        return produtosAVenda;
    }

    public static void mostrarProdutos() {
        if (!produtosAVenda.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Produtos a venda:\n"
                    + "Nº \tProduto\t\t\t\t\tPreço");
            int i = 0;
            double total = 0;
            for (Produto produto : produtosAVenda) {
                i++;
                JOptionPane.showMessageDialog(null, i + "\t" + produto.descricao + "\t" + produto.preco);
                total += produto.preco;
            }
            JOptionPane.showMessageDialog(null, "\nTotal:\t\t\t\t\t\t" + total);
        } else {
            JOptionPane.showMessageDialog(null, "Não há produtos cadastrados.");
        }
    }
    
    @Override
    public String toString(){
        return "Amazon\n";
    }
    
    public static void main(String[] args) {
        DVD dvd = new DVD(Categoria.FIC, "J. R. R. Tolkien", "The Lord of the Rings: The Return of the King", 300, 60.0);
        Livro livro = new Livro(Categoria.FIC, "J. K. Rowling", "Harry Potter and the Deathly Hallows", 600, 45.0);
        JOptionPane.showMessageDialog(null, "Bem vindo a loja do Amazon.\n"
                                          + "Loja: Amazon.\nCNPJ " + Amazon.CNPJ + ".\n");
        lista.add(dvd);
        lista.add(livro);
        for(Listable produto: lista){
            if(produto instanceof Livro){
                JOptionPane.showMessageDialog(null, "O " + ((Livro) produto).getDescricao() + " tem " + ((Livro) produto).getNumeroPaginas() + " páginas.");
            }
            if(produto instanceof DVD){
                JOptionPane.showMessageDialog(null, "O " + ((DVD) produto).getDescricao() + " tem duração de " + ((DVD) produto).getDuracao() + " minutos.");
            }
        }
        JOptionPane.showMessageDialog(null, "É necessário criar uma conta para realizar compras.");
        String nome = JOptionPane.showInputDialog("Digite seu nome:");
        String login = JOptionPane.showInputDialog("Digite seu login:");
        String senha = JOptionPane.showInputDialog("Digite sua senha:");
        Conta conta1 = new Conta(nome, login, senha);
        contas.add(conta1);
        setQuantidadeClientes(contas.size());
        mostrarProdutos();
        livro.mostrarInformacoes();
        dvd.mostrarInformacoes();
        JOptionPane.showMessageDialog(null, "Faça login:");
        login = JOptionPane.showInputDialog(null, "Username:");
        senha = JOptionPane.showInputDialog(null, "Senha:");
        conta1.login(login, senha);
        if(conta1.isAutenticado()){
            contaLogada.getCarrinho().add(livro);
            contaLogada.mostrarCarrinho();
        }
    }
}