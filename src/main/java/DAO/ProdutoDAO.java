
package DAO;

import BD.Conexao;
import Objetos.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ProdutoDAO {
    
    public List<Produto> read() {
        
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;    
        List<Produto> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tbl_produto");
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setDescrição(rs.getString("descricao"));
                p.setValor(rs.getDouble("valor"));
                p.setQuantidade(rs.getInt("quantidade"));;
                produtos.add(p);
            }
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao obter dados " + e);
            
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        
        
        return produtos;
        
    }
    
    public void create(Produto p) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO tbl_produto (descricao, valor, quantidade) VALUES (?, ?, ?)");
            stmt.setString(1, p.getDescrição());
            stmt.setDouble(2, p.getValor());
            stmt.setInt(3, p.getQuantidade());
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao obter dados " + e);
            
        } finally {
            Conexao.closeConnection(con, stmt);
        }
        
        
    }
        
        
        
        
        
    
        
    

   
    

}
