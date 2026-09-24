import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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

	    int larguraJanela = 800;
	    int larguraCampo = 220;
	    int xCampo = (larguraJanela - larguraCampo) / 2;

	    //Uso de IA
	    // Logo (centralizada no topo)
	    int larguraLogo = 140;
	    int alturaLogo = 140;
	    ImageIcon iconeOriginal = new ImageIcon("1.png");
	    Image imagemRedimensionada = iconeOriginal.getImage()
	            .getScaledInstance(larguraLogo, alturaLogo, Image.SCALE_SMOOTH);
	    lbTitulo = new JLabel(new ImageIcon(imagemRedimensionada), SwingConstants.CENTER);
	    lbTitulo.setBounds((larguraJanela - larguraLogo) / 2, 15, larguraLogo, alturaLogo);
	    add(lbTitulo);

	    
	    // Também usa a mesma imagem como ícone da janela
	    setIconImage(iconeOriginal.getImage());
	    // Usuário
	    lbUsuario = new JLabel("Usuário:", SwingConstants.LEFT);
	    lbUsuario.setBounds(xCampo, 100, larguraCampo, 20); // X Y W H
	    add(lbUsuario);

	    txUsuario = new JTextField();
	    txUsuario.setBounds(xCampo, 122, larguraCampo, 25); // X Y W H
	    add(txUsuario);

	    // Senha
	    lbSenha = new JLabel("Senha:", SwingConstants.LEFT);
	    lbSenha.setBounds(xCampo, 160, larguraCampo, 20); // X Y W H
	    add(lbSenha);

	    paSenha = new JPasswordField();
	    paSenha.setBounds(xCampo, 182, larguraCampo, 25); // X Y W H
	    add(paSenha);

	    // Botão Entrar
	    btEntrar = new JButton("Entrar");
	    btEntrar.setBounds((larguraJanela - 220) / 2, 230, 100, 30); // X Y W H
	    add(btEntrar);

	    // Botão Cadastrar
	    btCadastrar = new JButton("Cadastrar");
	    btCadastrar.setBounds((larguraJanela - 220) / 2 + 110, 230, 110, 30); // X Y W H
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