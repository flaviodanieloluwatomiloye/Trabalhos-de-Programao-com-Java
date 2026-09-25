package dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import model.Plano;
 
public class PlanoDAO {
 
    // Salva um novo plano no banco
    public void salvar(Plano plano) {
        Connection conexao = new Conection().getConnection();
        String sql = "INSERT INTO tbPlano (nome, valor, duracao, tipo) VALUES (?, ?, ?, ?)";
 
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, plano.getNomePlano());
            stmt.setDouble(2, plano.getPreco());
            stmt.setInt(3, plano.getDuracao());
            stmt.setString(4, plano.getIntervaloPagamento());
            stmt.executeUpdate();
 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
 
    // Retorna todos os planos cadastrados
    public List<Plano> listar() {
        List<Plano> planos = new ArrayList<>();
        Connection conexao = new Conection().getConnection();
        String sql = "SELECT * FROM tbPlano";
 
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
 
            while (rs.next()) {
                Plano plano = new Plano(
                        rs.getString("nome"),
                        rs.getDouble("valor"),
                        rs.getInt("duracao"),
                        rs.getString("tipo")
                );
                plano.setId(rs.getInt("idPlano"));
                planos.add(plano);
            }
 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
 
        return planos;
    }
 
    // Busca um plano pelo id (usado pelo AlunoDAO)
    public Plano buscarPorId(int id) {
        Connection conexao = new Conection().getConnection();
        String sql = "SELECT * FROM tbPlano WHERE idPlano = ?";
 
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
 
            if (rs.next()) {
                Plano plano = new Plano(
                        rs.getString("nome"),
                        rs.getDouble("valor"),
                        rs.getInt("duracao"),
                        rs.getString("tipo")
                );
                plano.setId(id);
                return plano;
            }
 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
 
        return null;
    }
}