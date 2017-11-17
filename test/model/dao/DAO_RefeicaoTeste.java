/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Classe_Refeicao;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author jamele
 */
public class DAO_RefeicaoTeste {
    
    @Test
    @Ignore
    public void Atualizar() {
        Classe_Refeicao refeicao = new Classe_Refeicao();
        refeicao.setId(1);
        
        DAO_Refeicao dao = new DAO_Refeicao();
        
        refeicao.setIngrediente1("Arroz negro");
        refeicao.setIngrediente2("Feijão preto");
        refeicao.setIngrediente3("Frango");
        refeicao.setIngrediente4("Macarrão");
        
        if(dao.update(refeicao)){
            System.out.println("Cardápio salvo com sucesso!");
        }
        else{
            fail("Erro ao salvar o cardápio!");
        }
    }
    
    @Test
    public void listar(){
        DAO_Refeicao dao = new DAO_Refeicao();
        
        for (Classe_Refeicao r : dao.findAll()) {
            System.out.println("INGREDIENTES: ");
            System.out.println(r.getIngrediente1());
            System.out.println(r.getIngrediente2());
            System.out.println(r.getIngrediente3());
            System.out.println(r.getIngrediente4());
        }
    }
}
