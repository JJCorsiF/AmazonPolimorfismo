package loja;

import javax.swing.JOptionPane;
import usuario.Listable;

public class Livro extends Produto {

    private String autor;
    private int numeroPaginas;
    
    public Livro(Livro copia){
        super(copia);
        this.autor = copia.autor;
        this.numeroPaginas = copia.numeroPaginas;
    }

    public Livro(String autor, String descricao, int numeroFolhas, double preco) {
        super(descricao, preco);
        this.autor = autor;
        setCategoria(Categoria.OUT);
        this.numeroPaginas = numeroFolhas;
    }

    public Livro(Categoria categoria, String autor, String descricao, int numeroFolhas, double preco) {
        super(categoria, descricao, preco);
        this.autor = autor;
        setCategoria(Categoria.OUT);
        this.numeroPaginas = numeroFolhas;
    }

    @Override
    public String getDescricao() {
        return "Livro " + descricao;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        if(!autor.equals("")){
            this.autor = autor;
        }
        else{
            JOptionPane.showMessageDialog(null, "O nome do autor não pode ser uma string vazia.");
        }
    }
    
    public int getNumeroPaginas(){
        return numeroPaginas;
    }

    @Override
    public void mostrarInformacoes() {
        JOptionPane.showMessageDialog(null, "Descrição: " + getDescricao()
                + "\nCategoria: " + getCategoria()
                + "\nAutor: " + getAutor()
                + "\nPreço: " + getPreco()
                + "\n");
    }
    
    @Override
    public String toString(){
        return super.toString() + "Autor: " + getAutor()
                + "\nNúmero de páginas: " + numeroPaginas
                + "\n";
    }

    @Override
    public void mostrarTodos() {
        for(Listable elemento : lista){
            if(elemento instanceof Livro){
                System.out.println(((Livro) elemento).toString());
            }
        }
    }
}