package loja;

import javax.swing.JOptionPane;
import usuario.Listable;
import static usuario.Listable.lista;

public class DVD extends Produto {

    private String tipo;
    private int duracao; //em minutos
    
    public DVD(DVD copia){
        super(copia);
        this.tipo = copia.tipo;
        this.duracao = copia.duracao;
    }

    public DVD(String descricao, int duracao, double preco) {
        super(descricao, preco);
        this.tipo = "Filme";
        setCategoria(Categoria.OUT);
        this.duracao = duracao;
    }

    public DVD(String tipo, String descricao, int duracao, double preco) {
        super(descricao, preco);
        this.tipo = tipo;
        setCategoria(Categoria.OUT);
        this.duracao = duracao;
    }

    public DVD(Categoria categoria, String tipo, String descricao, int duracao, double preco) {
        super(categoria, descricao, preco);
        this.tipo = tipo;
        this.duracao = duracao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if(!tipo.equals("")){
            this.tipo = tipo;
        }
        else{
            JOptionPane.showMessageDialog(null, "O campo tipo não pode ser vazio.");
        }
    }

    @Override
    public String getDescricao() {
        return "DVD " + descricao;
    }
    
    public int getDuracao(){
        return duracao;
    }

    @Override
    public void mostrarInformacoes() {
        JOptionPane.showMessageDialog(null, "Descrição: " + getDescricao()
                + "\nCategoria: " + getCategoria()
                + "\nTipo: " + getTipo()
                + "\nPreço: " + getPreco()
                + "\n");
    }
    
    @Override
    public String toString(){
        return super.toString() + "Tipo: " + getTipo()
                + "\nDuração: " + duracao + " minutos"
                + "\n";
    }

    @Override
    public void mostrarTodos() {
        for(Listable elemento : lista){
            if(elemento instanceof DVD){
                System.out.println(((DVD) elemento).toString());
            }
        }
    }
}