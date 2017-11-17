/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Classe_Cliente;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author jamele
 */
public class DAO_ClienteTest {
    
    public DAO_ClienteTest() {
    }

    @Test
    public void inserir(){
        Classe_Cliente cliente = new Classe_Cliente("Cli2", "senha", "cliente", "rua", 5, "bairro", 90909999);
        DAO_Cliente dao = new DAO_Cliente();
        
        assertEquals(dao.save(cliente), true);
        
    }
    
    @Test
    @Ignore
    public void listar(){
        DAO_Cliente dao = new DAO_Cliente();
        
        for (Classe_Cliente c : dao.findAll()) {
            System.out.println("Login: " +c.getLogin());
            System.out.println("Id: " +c.getId());
            System.out.println("Nome: " +c.getNome());
            System.out.println("Senha: " +c.getSenha());
            System.out.println("Rua: " +c.getRua());
            System.out.println("Bairro: " +c.getBairro());
            System.out.println("Número: " +c.getNumero());
            System.out.println("Telefone: " +c.getTelefone());
            System.out.println("\n");
        }
    }
    
    @Test
    @Ignore
    public void pesquisar(){
        DAO_Cliente dao = new DAO_Cliente();
        Classe_Cliente c = new Classe_Cliente();
        
        c = dao.pesquisar("jamele");
        System.out.println(c.getLogin());
        System.out.println(c.getNome());
        System.out.println(c.getRua());
        System.out.println(c.getNumero());
        System.out.println(c.getBairro());
        System.out.println(c.getTelefone());
    }
    
    @Test
    @Ignore
    public void atualizar(){
        Classe_Cliente cliente = new Classe_Cliente();
        cliente.setNome("jamele2");
        cliente.setId(1);
        DAO_Cliente dao = new DAO_Cliente();
        if(dao.updateNome(cliente)){
            System.out.println("Atualização relizada com sucesso!");
        }
        else{
            fail("Erro ao atualizar!");
        }
    }
    
    @Test
    @Ignore
    public void deletar(){
        Classe_Cliente cliente = new Classe_Cliente();
        cliente.setId(8);
        
        DAO_Cliente dao = new DAO_Cliente();
        
        if(dao.delete(cliente)){
            System.out.println("Registro removido com sucesso!");
        }
        else{
            fail("Erro ao remover registro!");
        }
    }
}
