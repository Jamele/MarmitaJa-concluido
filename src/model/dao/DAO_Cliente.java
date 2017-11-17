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
import model.bean.Classe_Cliente;

/**
 *
 * @author jamele
 */
public class DAO_Cliente {
    private Connection con = null;

    public DAO_Cliente() {
        con = ConnectionFactory.getConnection();
    }
    
    public boolean save(Classe_Cliente Cliente){
        String sql = "INSERT INTO Cliente (nome_cliente, senha_cliente, login, telefone, bairro, rua, numero) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, Cliente.getNome());
            stmt.setString(2, Cliente.getSenha());
            stmt.setString(3, Cliente.getLogin());
            stmt.setInt(4, Cliente.getTelefone());
            stmt.setString(5, Cliente.getBairro());
            stmt.setString(6, Cliente.getRua());
            stmt.setInt(7, Cliente.getNumero());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("ERRO! "+ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }  
    
    public List<Classe_Cliente> findAll(){
        String sql = "SELECT * FROM cliente";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Classe_Cliente> clientes = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Classe_Cliente cliente = new Classe_Cliente();
                cliente.setId(rs.getInt("id_cliente"));
                cliente.setNome(rs.getString("nome_cliente"));
                cliente.setSenha(rs.getString("senha_cliente"));
                cliente.setLogin(rs.getString("login"));
                cliente.setRua(rs.getString("rua"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setNumero(rs.getInt("numero"));
                cliente.setTelefone(rs.getInt("telefone"));
                clientes.add(cliente);
            }
            
        } catch (SQLException ex) {
            System.err.println("ERRO! "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return clientes;
    }
    public List<Classe_Cliente> findONE(int id){
        String sql = "SELECT id_cliente, nome_cliente, rua, numero, bairro, telefone FROM cliente WHERE id_cliente = ?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Classe_Cliente> clientes = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                if (id == rs.getInt("id_cliente"));
                Classe_Cliente cliente = new Classe_Cliente();
                cliente.setNome(rs.getString("nome_cliente"));
                cliente.setRua(rs.getString("rua"));                
                cliente.setNumero(rs.getInt("numero"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setTelefone(rs.getInt("telefone"));
                clientes.add(cliente);
            }
            
        } catch (SQLException ex) {
            System.err.println("ERRO! "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return clientes;
    }
    
    public boolean updateNome(Classe_Cliente Cliente){
        String sql = "UPDATE Cliente SET nome_cliente = ? WHERE id_cliente = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, Cliente.getNome());
            stmt.setInt(2, Cliente.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("ERRO no update! "+ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    } 
    
    public boolean updateRua(Classe_Cliente Cliente){
        String sql = "UPDATE Cliente SET rua = ? WHERE id_cliente = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, Cliente.getRua());
            stmt.setInt(2, Cliente.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("ERRO no update! "+ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    } 
    
    public boolean updateNumero(Classe_Cliente Cliente){
        String sql = "UPDATE Cliente SET numero = ? WHERE id_cliente = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, Cliente.getNumero());
            stmt.setInt(2, Cliente.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("ERRO no update! "+ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    } 
    
    public boolean updateBairro(Classe_Cliente Cliente){
        String sql = "UPDATE Cliente SET bairro = ? WHERE id_cliente = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, Cliente.getBairro());
            stmt.setInt(2, Cliente.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("ERRO no update! "+ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    } 
    
    public boolean updateTelefone(Classe_Cliente Cliente){
        String sql = "UPDATE Cliente SET telefone = ? WHERE id_cliente = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, Cliente.getTelefone());
            stmt.setInt(2, Cliente.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("ERRO no update! "+ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    } 
    
    public boolean updateLogin(Classe_Cliente Cliente){
        String sql = "UPDATE Cliente SET login = ? WHERE id_cliente = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, Cliente.getLogin());
            stmt.setInt(2, Cliente.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("ERRO no update! "+ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    } 
    
    public boolean updateSenha(Classe_Cliente Cliente){
        String sql = "UPDATE Cliente SET senha_cliente = ? WHERE id_cliente = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, Cliente.getSenha());
            stmt.setInt(2, Cliente.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("ERRO no update! "+ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    } 
    
    public boolean delete(Classe_Cliente Cliente){
        String sql = "DELETE FROM Cliente WHERE id_cliente = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, Cliente.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("ERRO! "+ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    } 
    
    public boolean checkLogin(String Login, String Senha){
        String sql = "SELECT login, senha_cliente FROM cliente WHERE login = ? AND senha_cliente = ?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, Login);
            stmt.setString(2, Senha);
            rs = stmt.executeQuery();
            
            if (rs.first()){
                check = true;
            }
            
        } catch (SQLException ex) {
            System.err.println("ERRO!" +ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return check;
    }
    
    public boolean checkSenha(String Senha){
        String sql = "SELECT senha_cliente FROM cliente WHERE senha_cliente = ?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, Senha);
            rs = stmt.executeQuery();
            
            if (rs.first()){
                check = true;
            }
            
        } catch (SQLException ex) {
            System.err.println("ERRO!" +ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return check;
    }
    
    public Classe_Cliente pesquisar(String login){
        String sql = "SELECT id_cliente, login, nome_cliente, rua, numero, bairro, telefone FROM cliente WHERE login = ?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Classe_Cliente cliente = new Classe_Cliente();
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, login);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                if(rs.getString("login").equals(login)){
                    cliente.setId(rs.getInt("id_cliente"));
                    cliente.setLogin(rs.getString("login"));
                    cliente.setNome(rs.getString("nome_cliente"));
                    cliente.setRua(rs.getString("rua"));
                    cliente.setBairro(rs.getString("bairro"));
                    cliente.setNumero(rs.getInt("numero"));
                    cliente.setTelefone(rs.getInt("telefone"));
                }
            }
            
        } catch (SQLException ex) {
            System.err.println("ERRO na pesquisa!" +ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }  
        return cliente;
    }
}
