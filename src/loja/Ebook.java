package loja;

public class Ebook extends Livro {

    private double tamanhoArquivo;

    public Ebook(String autor, String descricao, int numeroFolhas, double preco) {
        super(autor, descricao, numeroFolhas, preco);
        tamanhoArquivo = numeroFolhas * 1024;
    }

    public Ebook(Categoria categoria, String autor, String descricao, int numeroFolhas, double preco) {
        super(categoria, autor, descricao, numeroFolhas, preco);
        tamanhoArquivo = numeroFolhas * 1024;
    }
    
    @Override
    public String toString(){
        return super.toString() + tamanhoArquivo + "\n";
    }
}