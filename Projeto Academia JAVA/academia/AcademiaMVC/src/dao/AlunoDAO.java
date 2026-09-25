package dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
 
import model.AlunoCadastrado;
import model.Instrutor;
import model.Plano;
 
public class AlunoDAO {
 
    // Salva um novo aluno no banco. Plano e instrutor podem ser null
    // (aluno que se cadastrou sozinho e ainda vai escolher depois).
    public void salvar(AlunoCadastrado aluno) {
        Connection conexao = new Conection().getConnection();
        String sql = "INSERT INTO tbAluno (nome, email, telefone, cpf, idade, endereco, sexo, senha, idPlano, idInstrutor) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
 
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setString(3, aluno.getTelefone());
            stmt.setString(4, aluno.getCpf());
            stmt.setString(5, aluno.getIdade());
            stmt.setString(6, aluno.getEndereco());
            stmt.setString(7, aluno.getSexo());
            stmt.setString(8, aluno.getSenha());
 
            if (aluno.getPlanoEscolhido() != null) {
                stmt.setInt(9, aluno.getPlanoEscolhido().getId());
            } else {
                stmt.setNull(9, Types.INTEGER);
            }
 
            if (aluno.getInstrutorResponsavel() != null) {
                stmt.setInt(10, aluno.getInstrutorResponsavel().getId());
            } else {
                stmt.setNull(10, Types.INTEGER);
            }
 
            stmt.executeUpdate();
 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
 
    // Retorna todos os alunos cadastrados
    public List<AlunoCadastrado> listar() {
        List<AlunoCadastrado> alunos = new ArrayList<>();
        Connection conexao = new Conection().getConnection();
        String sql = "SELECT * FROM tbAluno";
 
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
 
            while (rs.next()) {
                alunos.add(montarAluno(rs));
            }
 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
 
        return alunos;
    }
 
    // Busca um aluno pelo cpf
    public AlunoCadastrado buscarPorCpf(String cpf) {
        Connection conexao = new Conection().getConnection();
        String sql = "SELECT * FROM tbAluno WHERE cpf = ?";
 
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
 
            if (rs.next()) {
                return montarAluno(rs);
            }
 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
 
        return null;
    }
 
    // Busca um aluno pelo email (usado no cadastro e no login)
    public AlunoCadastrado buscarPorEmail(String email) {
        Connection conexao = new Conection().getConnection();
        String sql = "SELECT * FROM tbAluno WHERE email = ?";
 
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
 
            if (rs.next()) {
                return montarAluno(rs);
            }
 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
 
        return null;
    }
 
    // Remove um aluno pelo cpf
    public boolean remover(String cpf) {
        Connection conexao = new Conection().getConnection();
        String sql = "DELETE FROM tbAluno WHERE cpf = ?";
 
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cpf);
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
 
    // Monta um objeto AlunoCadastrado a partir de uma linha do banco
    private AlunoCadastrado montarAluno(ResultSet rs) throws SQLException {
        Plano plano = new PlanoDAO().buscarPorId(rs.getInt("idPlano"));
        Instrutor instrutor = new InstrutorDAO().buscarPorId(rs.getInt("idInstrutor"));
 
        AlunoCadastrado aluno = new AlunoCadastrado(
                rs.getString("nome"),
                rs.getString("cpf"),
                rs.getString("email"),
                rs.getString("telefone"),
                rs.getString("idade"),
                rs.getString("endereco"),
                rs.getString("sexo"),
                rs.getString("senha"),
                plano,
                instrutor
        );
        aluno.setId(rs.getInt("idAluno"));
        return aluno;
    }
}
 