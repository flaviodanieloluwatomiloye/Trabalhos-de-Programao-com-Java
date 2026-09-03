import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login1 extends JFrame {

	private JLabel lbUsuario, lbSenha, lbTitulo;
	private JTextField txUsuario;
	private JPasswordField paSenha;
	private JButton btEntrar, btCadastrar;

	// Usuário e senha fixos apenas para fins acadêmicos (não há banco de dados)
	private static final String USUARIO_VALIDO = "admin";
	private static final String SENHA_VALIDA = "1234";

	public Login1() {
		setTitle("Login - Academia");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);

		// Título
		lbTitulo = new JLabel("Acesso ao Sistema");
		lbTitulo.setBounds(100, 20, 250, 30);
		add(lbTitulo);

		// Usuário
		lbUsuario = new JLabel("Usuário: ");
		lbUsuario.setBounds(40, 80, 100, 25);
		add(lbUsuario);

		txUsuario = new JTextField();
		txUsuario.setBounds(140, 80, 180, 25);
		add(txUsuario);

		// Senha
		lbSenha = new JLabel("Senha: ");
		lbSenha.setBounds(40, 120, 100, 25);
		add(lbSenha);

		paSenha = new JPasswordField();
		paSenha.setBounds(140, 120, 180, 25);
		add(paSenha);

		// Botão Entrar
		btEntrar = new JButton("Entrar");
		btEntrar.setBounds(80, 170, 100, 30);
		add(btEntrar);

		// Botão Cadastrar (abre a tela de cadastro para quem ainda não tem conta)
		btCadastrar = new JButton("Cadastrar");
		btCadastrar.setBounds(200, 170, 110, 30);
		add(btCadastrar);

		// Ação do botão Entrar
		btEntrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String usuario = txUsuario.getText();
				String senha = new String(paSenha.getPassword());

				// Não deixa continuar sem colocar todos os dados
				if (usuario.trim().isEmpty() || senha.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Por favor, preencha usuário e senha.",
							"Campos obrigatórios",
							JOptionPane.WARNING_MESSAGE);
					return;
				}

				// Verifica as credenciais
				if (usuario.equals(USUARIO_VALIDO) && senha.equals(SENHA_VALIDA)) {
					dispose();
					new Menu();
				} else {
					JOptionPane.showMessageDialog(null,
							"Usuário ou senha inválidos.",
							"Erro de autenticação",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		// Ação do botão Cadastrar
		btCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Cadastro();
			}
		});

		setVisible(true);
	}
}