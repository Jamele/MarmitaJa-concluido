/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author jamele
 */
public class Classe_Cliente extends Classe_Usuario{
    private String login;
    private String rua;
    private int numero;
    private String bairro;
    private int telefone;

    public Classe_Cliente(String nome, String senha, String login, String rua, int numero, String bairro, int telefone) {
        super(nome, senha);
        this.bairro = bairro;
        this.rua = rua;
        this.login = login;
    }

    public Classe_Cliente() {
    }
    
    public Classe_Cliente(String nome) {
        super (nome);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public void setRua(int num) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    
}
