package usuario;

import java.util.Calendar;
import javax.swing.JOptionPane;

public class Pessoa implements Listable {

    protected String nome;
    private final Calendar dataNascimento = Calendar.getInstance();
    private String RG;
    private String CPF;

    public Pessoa(String nome, String data) {
        this.nome = nome;
        dataNascimento.set(Calendar.DATE, Integer.parseInt(data.substring(0, 2)));
        dataNascimento.set(Calendar.MONTH, Integer.parseInt(data.substring(3, 5)) - 1);
        dataNascimento.set(Calendar.YEAR, Integer.parseInt(data.substring(6)));
        RG = "000000";
        CPF = "00000000000";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(!nome.equals("")){
            this.nome = nome;
        }
        else{
            JOptionPane.showMessageDialog(null, "O nome não pode ser vazio.");
        }
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cPF) {
        if(cPF.length() == 11){
            CPF = cPF;
        }
        else{
            JOptionPane.showMessageDialog(null, "O CPF deve conter exatamente 11 caracteres.");
        }
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String rG) {
        if(rG.length() > 6){
            RG = rG;
        }
        else{
            JOptionPane.showMessageDialog(null, "O RG deve ter mais de 6 caracteres.");
        }
    }
    
    @Override
    public String toString(){
        return "Nome da pessoa: " + nome
             + "\nRG: " + RG
             + "\nCPF: " + CPF
             + "\nData de Nascimento: " + dataNascimento.toString()
             + "\n";
    }

    @Override
    public void mostrarTodos(){
        for(Listable elemento : lista){
            if(elemento instanceof Pessoa){
                System.out.println(((Pessoa) elemento).toString());
            }
        }
    }
}