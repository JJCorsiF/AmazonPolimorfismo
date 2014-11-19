package loja;

import java.util.ArrayList;
import usuario.Listable;
import static usuario.Listable.lista;

public abstract class Loja {

    protected static ArrayList<Produto> produtosAVenda = new ArrayList<>();

    public Loja() {
        for(Listable elemento : lista){
            if(elemento instanceof Produto){
                produtosAVenda.add((Produto) elemento);
            }
        }
    }
}