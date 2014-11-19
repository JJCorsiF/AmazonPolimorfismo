package usuario;

import java.util.ArrayList;

public interface Listable {
    final public ArrayList<Listable> lista = new ArrayList<>();
    public void mostrarTodos();
}
