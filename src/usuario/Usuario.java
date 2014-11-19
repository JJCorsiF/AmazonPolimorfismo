package usuario;

import javax.swing.JOptionPane;

public class Usuario extends Pessoa {
    private int id = 0;
    private static int numeroUsuarios = 0;

    public Usuario() {
        super("Convidado000", "01.01.1991");
        nome = nome + id;
        id = ++numeroUsuarios;
    }

    public Usuario(String nome) {
        super(nome, "01.01.1991");
        id = ++numeroUsuarios;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        if (!nome.equals("")) {
            this.nome = nome;
        } else {
            JOptionPane.showMessageDialog(null, "O nome não pode ser vazio.");
        }
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            JOptionPane.showMessageDialog(null, "O ID deve ser positivo.");
        }
    }

    @Override
    public boolean equals(Object outro) {
        Usuario user;
        if (outro instanceof Usuario) {
            user = (Usuario) outro;
            if (user.id == this.id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.id;
        return hash;
    }
    
    @Override
    public String toString(){
        return "ID do usuario: " + id
             + "\n" + super.toString();
    }
}