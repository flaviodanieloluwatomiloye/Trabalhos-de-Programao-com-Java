package dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import model.Instrutor;
 
public class InstrutorDAO {
 
    // Salva um novo instrutor no banco
    public void salvar(Instrutor instrutor) {
        Connection conexao = new Conection().getConnection();
        String sql = "INSERT INTO tbInstrutor (nome, email, telefone, cpf, idade, endereco, sexo, senha, funcao) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
 
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, instrutor.getNome());
            stmt.setString(2, instrutor.getEmail());
            stmt.setString(3, instrutor.getTelefone());
            stmt.setString(4, instrutor.getCpf());
            stmt.setString(5, instrutor.getIdade());
            stmt.setString(6, instrutor.getEndereco());
            stmt.setString(7, instrutor.getSexo());
            stmt.setString(8, instrutor.getSenha());
            stmt.setString(9, instrutor.getFuncao());
            stmt.executeUpdate();
 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
 
    // Retorna todos os instrutores cadastrados
    public List<Instrutor> listar() {
        List<Instrutor> instrutores = new ArrayList<>();
        Connection conexao = new Conection().getConnection();
        String sql = "SELECT * FROM tbInstrutor";
 
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
 
            while (rs.next()) {
                Instrutor instrutor = new Instrutor(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getString("telefone"),
                        rs.getString("idade"),
                        rs.getString("endereco"),
                        rs.getString("sexo"),
                        rs.getString("senha"),
                        rs.getString("funcao")
                );
                instrutor.setId(rs.getInt("idInstrutor"));
                instrutores.add(instrutor);
            }
 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
 
        return instrutores;
    }
 
    // Busca um instrutor pelo id (usado pelo AlunoDAO)
    public Instrutor buscarPorId(int id) {
        Connection conexao = new Conection().getConnection();
        String sql = "SELECT * FROM tbInstrutor WHERE idInstrutor = ?";
 
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
 
            if (rs.next()) {
                Instrutor instrutor = new Instrutor(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getString("telefone"),
                        rs.getString("idade"),
                        rs.getString("endereco"),
                        rs.getString("sexo"),
                        rs.getString("senha"),
                        rs.getString("funcao")
                );
                instrutor.setId(id);
                return instrutor;
            }
 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
 
        return null;
    }
 
    // Busca um instrutor pelo cpf
    public Instrutor buscarPorCpf(String cpf) {
        Connection conexao = new Conection().getConnection();
        String sql = "SELECT * FROM tbInstrutor WHERE cpf = ?";
 
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
 
            if (rs.next()) {
                Instrutor instrutor = new Instrutor(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getString("telefone"),
                        rs.getString("idade"),
                        rs.getString("endereco"),
                        rs.getString("sexo"),
                        rs.getString("senha"),
                        rs.getString("funcao")
                );
                instrutor.setId(rs.getInt("idInstrutor"));
                return instrutor;
            }
 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
 
        return null;
    }
 
    // Busca um instrutor pelo email (usado no cadastro e no login)
    public Instrutor buscarPorEmail(String email) {
        Connection conexao = new Conection().getConnection();
        String sql = "SELECT * FROM tbInstrutor WHERE email = ?";
 
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
 
            if (rs.next()) {
                Instrutor instrutor = new Instrutor(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getString("telefone"),
                        rs.getString("idade"),
                        rs.getString("endereco"),
                        rs.getString("sexo"),
                        rs.getString("senha"),
                        rs.getString("funcao")
                );
                instrutor.setId(rs.getInt("idInstrutor"));
                return instrutor;
            }
 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
 
        return null;
    }
}