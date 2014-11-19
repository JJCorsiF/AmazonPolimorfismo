package loja;

public enum Categoria {
    
    MUS("Musical"),
    ROM("Romance"),
    COM("Comédia"),
    FIC("Ficção"),
    AVE("Aventura"),
    SUS("Suspense"),
    ACA("Ação"),
    OUT("Outros");

    private final String nome;

    Categoria(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    
    @Override
    public String toString(){
        return "Categoria " + Categoria.valueOf(nome) + "\n";
    }
}