/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Classe_Refeicao;

/**
 *
 * @author jamele
 */
public class DAO_Refeicao {
    private Connection con = null;

    public DAO_Refeicao() {
        con = ConnectionFactory.getConnection();

    }
    
    public boolean update(Classe_Refeicao Refeicao) {
        String sql = "UPDATE Refeicao SET ingrediente1=?, ingrediente2=?, ingrediente3=?, ingrediente4=? WHERE id_refeicao=?";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, Refeicao.getIngrediente1());
            stmt.setString(2, Refeicao.getIngrediente2());
            stmt.setString(3, Refeicao.getIngrediente3());
            stmt.setString(4, Refeicao.getIngrediente4());
            stmt.setInt(5, Refeicao.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("ERRO! " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Classe_Refeicao> findAll(){
        String sql = "SELECT * FROM refeicao";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Classe_Refeicao> cardapio = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Classe_Refeicao refeicao = new Classe_Refeicao();
                refeicao.setIngrediente1(rs.getString("ingrediente1"));
                refeicao.setIngrediente2(rs.getString("ingrediente2"));
                refeicao.setIngrediente3(rs.getString("ingrediente3"));
                refeicao.setIngrediente4(rs.getString("ingrediente4"));
                
                cardapio.add(refeicao);
            }
            
        } catch (SQLException ex) {
            System.err.println("ERRO! "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return cardapio;
    }
    
//    public Classe_Refeicao selecionar_refeicao(){
//        String sql = "SELECT id_refeicao, ingrediente1, ingrediente2, ingrediente3, ingrediente4 FROM refeicao";
//        
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        Classe_Refeicao refeicao = new Classe_Refeicao();
//        
//        try {
//            stmt = con.prepareStatement(sql);
//            stmt.setInt(1, refeicao.getId());
//            stmt.setString(1, refeicao.getId());
//            stmt.set(1, refeicao.getId());
//            stmt.setInt(1, refeicao.getId());
//            stmt.setInt(1, refeicao.getId());
//            rs = stmt.executeQuery();
//            
//            while(rs.next()){
//                refeicao.setId(rs.getInt("id_refeicao"));
//            }
//            
//        } catch (SQLException ex) {
//            System.err.println("ERRO!" +ex);
//        } finally {
//            ConnectionFactory.closeConnection(con, stmt, rs);
//        }  
//        return refeicao;
//    }
}