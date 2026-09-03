import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
 
public class AlunosMatriculados extends JFrame {
 
	private JLabel lbTitulo;
	private JTable tabela;
	private JScrollPane scroll;
 
	public AlunosMatriculados() {
		setTitle("Alunos Matriculados");
		setSize(800, 600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
 
		// Título
		lbTitulo = new JLabel("Lista de Alunos Matriculados");
		lbTitulo.setBounds(150, 15, 300, 25);
		add(lbTitulo);
 
		// Colunas da tabela
		String[] colunas = {"Nome", "CPF", "Plano", "Instrutor"};
 
		// Monta as linhas a partir dos alunos já cadastrados em Dados.alunos
		DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
		for (AlunoCadastrado aluno : Dados.alunos) {
			Object[] linha = {
					aluno.getNome(),
					aluno.getCpf(),
					aluno.getPlanoEscolhido(),
					aluno.getInstrutorResponsavel()
			};
			modelo.addRow(linha);
		}
 
		tabela = new JTable(modelo);
		scroll = new JScrollPane(tabela);
		scroll.setBounds(40, 55, 500, 280);
		add(scroll);
 
		setVisible(true);
	}
}