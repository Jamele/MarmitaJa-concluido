/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Classe_Cliente;
import model.bean.Classe_Pedido;
import model.bean.Classe_Refeicao;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author jamele
 */
public class DAO_PedidoTest {
    
    public DAO_PedidoTest() {
    }

//    @Test
//    //enviar objeto cliente no dao.save
//    public void Inserir() {
//        Classe_Cliente cliente = new Classe_Cliente();
//        cliente.setId(2);
//        Classe_Refeicao refeicao = new Classe_Refeicao();
//        refeicao.setId(1);
//        
//        DAO_Pedido dao = new DAO_Pedido();
//        
//        Classe_Pedido pedido = new Classe_Pedido();
//        pedido.setCliente(cliente);
//        pedido.setRefeicao(refeicao);
//        pedido.setQuantidade(1);
//        pedido.setObservacao("mais arroz");
//        
//        if(dao.save(pedido)){
//            System.out.println("Salvo com sucesso!");
//        }
//        else{
//            fail("Erro ao salvar!");
//        }
//    }
    
    @Test
    @Ignore
    public void listar(){
        DAO_Pedido dao = new DAO_Pedido();
        
        for (Classe_Pedido p : dao.findAll()) {
            System.out.println("Ordem: " +p.getId());
            System.out.println("Quantidade de quentinhas: " +p.getQuantidade());
            System.out.println("Observações: " +p.getObservacao());
            System.out.println("DADOS DO CLIENTE");
            System.out.println("Nome: " +p.getCliente().getNome());
            System.out.println("Rua: " +p.getCliente().getRua());
            System.out.println("Número: " +p.getCliente().getNumero());
            System.out.println("Bairro: " +p.getCliente().getBairro());
            System.out.println("Telefone: "+p.getCliente().getTelefone());
            System.out.println("\n");
        }
    }
    
    @Test
    @Ignore
    public void Atualizar() {
        Classe_Cliente cliente = new Classe_Cliente();
        cliente.setId(2);
        Classe_Refeicao refeicao = new Classe_Refeicao();
        refeicao.setId(1);
        
        DAO_Pedido dao = new DAO_Pedido();
        
        Classe_Pedido pedido = new Classe_Pedido();
        pedido.setCliente(cliente);
        pedido.setRefeicao(refeicao);
        pedido.setQuantidade(1);
        pedido.setObservacao("muito arroz");
        
        pedido.setId(4);
        
        if(dao.update(pedido)){
            System.out.println("Salvo com sucesso!");
        }
        else{
            fail("Erro ao salvar!");
        }
    }
    
    @Test
    @Ignore
    public void deletarRegistros(){
        Classe_Pedido pedido = new Classe_Pedido();
        
        DAO_Pedido dao = new DAO_Pedido();
        
        if(dao.deleteAll(pedido)){
            System.out.println("Todos os pedidos anteriores foram excluídos!");
        }
        else{
            fail("Erro ao deletar os registros!");
        }
    }
}
