package loja;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import usuario.Usuario;

public class Conta implements Logable, Comparable<Conta> {
    
    private int idConta = 0;
    private static int numeroContas = 0;
    private Usuario usuario;
    private String login = "";
    private String senha = "";
    private boolean autenticado = false;
    private ArrayList<Produto> carrinho;

    public Conta() {
        usuario = new Usuario();
        login = "Convidado000" + usuario.getID();
        senha = "123456";
        autenticado = false;
        carrinho = new ArrayList<>();
        idConta = ++numeroContas;
    }

    public Conta(String login, String senha) {
        usuario = new Usuario();
        this.login = login;
        this.senha = senha;
        autenticado = false;
        carrinho = new ArrayList<>();
        idConta = ++numeroContas;
    }

    public Conta(String nome, String login, String senha) {
        usuario = new Usuario(nome);
        this.login = login;
        this.senha = senha;
        autenticado = false;
        carrinho = new ArrayList<>();
        idConta = ++numeroContas;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (isAutenticado() || this.login.equals("")) {
            if ((login.length() > 5 && login.length() < 21)) {
                this.login = login;
            } else {
                JOptionPane.showMessageDialog(null, "O login deve ter no mínimo 6 e no máximo 20 caracteres.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Você deve estar logado para isso!");
        }
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if (isAutenticado() || this.senha.equals("")) {
            if (senha.length() > 5 && senha.length() < 16) {
                this.senha = senha;
            } else {
                JOptionPane.showMessageDialog(null, "A senha deve ter no mínimo 6 e no máximo 15 caracteres.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Você deve estar logado para isso!");
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario user) {
        this.usuario = user;
    }

    public boolean isAutenticado() {
        return autenticado;
    }

    public void setAutenticado(boolean autenticado) {
        this.autenticado = autenticado;
    }

    public ArrayList<Produto> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(ArrayList<Produto> carrinho) {
        this.carrinho = carrinho;
    }

    @Override
    public boolean login(String login, String senha) {
        if (this.login.equals(login)) {
            if (this.senha.equals(senha)) {
                setAutenticado(true);
                Amazon.contaLogada = this;
                JOptionPane.showMessageDialog(null, "Logado como " + this.usuario.getNome() + ".\n");
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "Falha na autenticação: login e/ou senha incorretos.\n");
        return false;
    }

    @Override
    public void logout() {
        if (isAutenticado()) {
            Amazon.contaLogada.setAutenticado(false);
            Amazon.contaLogada = null;
        }
    }

    @Override
    public int compareTo(Conta outra) {
        if (this.login.equals(outra.login) && this.senha.equals(outra.senha)) {
            return 0;
        } else {
            if (this.login.length() > outra.login.length()) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public void mostrarCarrinho() {
        if (!carrinho.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Carrinho:\n"
                    + "Nº \tProduto\t\t\t\t\tPreço");
            int i = 0;
            double total = 0;
            for (Produto produto : carrinho) {
                i++;
                JOptionPane.showMessageDialog(null, i + "\t" + produto.descricao + "\t" + produto.preco);
                total += produto.preco;
            }
            JOptionPane.showMessageDialog(null, "\nTotal:\t\t\t\t\t\t" + total);
        } else {
            JOptionPane.showMessageDialog(null, "Não há produtos no carrinho.");
        }
        //System.out.println();
    }
    
    @Override
    public String toString(){
        return "Conta " + idConta + ":\n"
             + "Login: " + login + "\n"
             + "Usuario: " + usuario.getNome() + "\n";
    }
}