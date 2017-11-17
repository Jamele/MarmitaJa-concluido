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
import model.bean.Classe_Pedido;
import model.bean.Classe_Refeicao;

/**
 *
 * @author jamele
 */
public class DAO_Pedido {

    private Connection con = null;

    public DAO_Pedido() {
        con = ConnectionFactory.getConnection();

    }

    public boolean save(Classe_Pedido Pedido) {
        String sql = "INSERT INTO Pedido (fk_cliente, fk_refeicao, quantidade, observacao) VALUES (?, ?, ?, ?)";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, Pedido.getCliente().getId());
            stmt.setInt(2, 1);                              //Setando 1 no fk_refeicao pois o id_refeicao é estático
            stmt.setInt(3, Pedido.getQuantidade());
            stmt.setString(4, Pedido.getObservacao());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("ERRO! " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Classe_Pedido> findAll() {
        String sql = "SELECT * FROM vw_dados_pedido";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Classe_Pedido> pedidos = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Classe_Pedido pedido = new Classe_Pedido();
                pedido.setId(rs.getInt("id_pedido"));
                pedido.setQuantidade(rs.getInt("quantidade"));
                pedido.setObservacao(rs.getString("observacao"));

                
                Classe_Cliente cliente = new Classe_Cliente();
                cliente.setId(rs.getInt("id_cliente"));
                cliente.setNome(rs.getString("nome_cliente"));
                cliente.setRua(rs.getString("rua"));
                cliente.setNumero(rs.getInt("numero"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setTelefone(rs.getInt("telefone"));
                pedido.setCliente(cliente);
                
                pedidos.add(pedido);
            }

        } catch (SQLException ex) {
            System.err.println("ERRO! " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return pedidos;
    }
    
    public boolean update(Classe_Pedido Pedido) {
        String sql = "UPDATE Pedido SET fk_cliente=?, fk_refeicao=?, quantidade=?, observacao=? WHERE id_pedido=?";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, Pedido.getCliente().getId());
            stmt.setInt(2, Pedido.getRefeicao().getId());
            stmt.setInt(3, Pedido.getQuantidade());
            stmt.setString(4, Pedido.getObservacao());
            stmt.setInt(5, Pedido.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("ERRO! " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean deleteAll(Classe_Pedido Pedido){
        String sql = "TRUNCATE TABLE Pedido";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("ERRO! "+ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    } 

}
