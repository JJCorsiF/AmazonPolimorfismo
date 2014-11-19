package loja;

import javax.swing.JOptionPane;
import usuario.Listable;

public class Produto implements Listable, Sellable{

    protected Categoria categoria;
    protected String descricao;
    protected double preco;
    
    public Produto(Produto copia){
        this.categoria = copia.categoria;
        this.descricao = copia.descricao;
        this.preco = copia.preco;
    }

    public Produto(String descricao, double preco) {
        this.categoria = Categoria.OUT;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Produto(Categoria categoria, String descricao, double preco) {
        this.categoria = categoria;
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria.getNome();
    }

    public void setCategoria(Categoria categoria) {
        if(categoria != null){
            this.categoria = categoria;
        }
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public void setPreco(double preco) {
        if(preco > 0){
            this.preco = preco;
        }
        else{
            JOptionPane.showMessageDialog(null, "O preço deve ser positivo.");
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if(!descricao.equals("")){
            this.descricao = descricao;
        }
        else{
            JOptionPane.showMessageDialog(null, "A descrição não pode estar vazia.");
        }
    }

    public void mostrarInformacoes(){
        JOptionPane.showMessageDialog(null, "Descrição: " + getDescricao()
                + "\nCategoria: " + getCategoria()
                + "\nPreço: " + getPreco()
                + "\n");
    }
    
    @Override
    public String toString(){
        return "Produto: " + descricao
             + "\nCategoria: " + categoria.getNome()
             + "\nPreço: " + preco
             + "\n";
    }
    
    @Override
    public void mostrarTodos() {
        for(Listable elemento : lista){
            if(elemento instanceof Produto){
                System.out.println(((Produto) elemento).toString());
            }
        }
    }
}