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
public class Classe_Pedido {
    private int id;
    private int quantidade;
    private String observacao;
    private Classe_Cliente cliente;
    private Classe_Refeicao refeicao;

    public Classe_Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Classe_Cliente cliente) {
        this.cliente = cliente;
    }

    public Classe_Refeicao getRefeicao() {
        return refeicao;
    }

    public void setRefeicao(Classe_Refeicao refeicao) {
        this.refeicao = refeicao;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    
    
}
