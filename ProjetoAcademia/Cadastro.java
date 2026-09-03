import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class Cadastro extends JFrame {

	private JLabel lbNome, lbEmail, lbTelefone, lbCPF, lbIdade, lbEndereco, lbSexoF, lbSexoM, lbSexoO, lbSenha;
	private JTextField txNome, txEmail, txEndereco;
	private JFormattedTextField txCPF, txTelefone;
	private JComboBox cbIdade;
	private JCheckBox chbSexoF, chbSexoM, chbSexoO;
	private JPasswordField paSenha;
	private JButton btSalvar;
	
	public Cadastro() {
		setTitle("Registro de novo cliente");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLocationRelativeTo(null); //para centralizar o JFrame
		setResizable(false); //placa fica no tamanho fixo
		setLayout(null);
		
		//JLabel Nome
		lbNome = new JLabel();
		lbNome.setText("Nome: ");
		lbNome.setBounds(40,10,100,25); // X Y W H
		add(lbNome);
		
		//JTextField Nome
		txNome = new JTextField();
		txNome.setBounds(150,10,150,25); // X Y W H
		add(txNome);
		
		//JLabel Email
		lbEmail = new JLabel();
		lbEmail.setText("Email: ");
		lbEmail.setBounds(40,40,100,25); // X Y W H
		add(lbEmail);
		
		//JTextField Email
		txEmail = new JTextField();
		txEmail.setBounds(150,40,120,25); // X Y W H
		add(txEmail);
		
		//JFormattedTextField Telefone
		lbTelefone = new JLabel();
		lbTelefone.setText("Telefone: ");
		lbTelefone.setBounds(40,70,100,25); // X Y W H
		add(lbTelefone);
		
		// JFormattedTextField Telefone (com mascara) desisto de java
		try {
			MaskFormatter mascaraTelefone = new MaskFormatter("(##) #####-####");
			txTelefone = new JFormattedTextField(mascaraTelefone);
		} catch (ParseException e) {
			txTelefone = new JFormattedTextField();
		}
		txTelefone.setBounds(150, 70, 150, 25);
		add(txTelefone);
		
		//JLable CPF
		lbCPF = new JLabel();
		lbCPF.setText("CPF: ");
		lbCPF.setBounds(40,100,100,25); // X Y W H
		add(lbCPF);
		
		// JFormattedTextField CPF (com mascara)
		try {
			MaskFormatter mascaraCPF = new MaskFormatter("###.###.###-##");
			txCPF = new JFormattedTextField(mascaraCPF);
		} catch (ParseException e) {
			txCPF = new JFormattedTextField();
		}
		txCPF.setBounds(150, 100, 150, 25); // X Y W H
		add(txCPF);
		
		// JLabel Idade
		lbIdade = new JLabel("Idade: ");
		lbIdade.setBounds(40, 130, 100, 25); // X Y W H
		add(lbIdade);
		
		// JComboBox Idade
		String[] idades = new String[83];
		for (int i = 0; i <= 82; i++) {
			idades[i] = String.valueOf(i + 18);
		}
		cbIdade = new JComboBox<>(idades);
		cbIdade.setBounds(150, 130, 80, 25); // X Y W H
		add(cbIdade);
		
		// JLabel Endereço
		lbEndereco = new JLabel("Endereço: ");
		lbEndereco.setBounds(40, 160, 100, 25); // X Y W H
		add(lbEndereco);
		
		// JTextField Endereço
		txEndereco = new JTextField();
		txEndereco.setBounds(150, 160, 250, 25); // X Y W H
		add(txEndereco);
		
		// JLabel SexoF
		lbSexoF = new JLabel("Feminino");
		lbSexoF.setBounds(150, 190, 100, 25); // X Y W H
		add(lbSexoF); 
		
		// JCheckBox SexoF
		chbSexoF = new JCheckBox();
		chbSexoF.setBounds(170, 220, 25, 25); // X Y W N
		add(chbSexoF);
		
		// JLabel SexoM
		lbSexoM = new JLabel("Masculino");
		lbSexoM.setBounds(230, 190, 100, 25); // X Y W H
		add(lbSexoM);
		
		//JCheckBox SexoM
		chbSexoM = new JCheckBox();
		chbSexoM.setBounds(250, 220, 25, 25); // X Y W H
		add(chbSexoM);
		
		// JLabel SexoO
		lbSexoO = new JLabel("Outros");
		lbSexoO.setBounds(310, 190, 100, 25); // X Y W H
		add(lbSexoO);
		
		//JCheckBox SexoO
		chbSexoO = new JCheckBox();
		chbSexoO.setBounds(320, 220, 25, 25); // X Y W H
		add(chbSexoO);

		// JLabel Senha
		lbSenha = new JLabel("Senha: ");
		lbSenha.setBounds(40, 250, 100, 25); // X Y W H
		add(lbSenha);
		
		// JPasswordField Senha
		paSenha = new JPasswordField();
		paSenha.setBounds(150, 250, 150, 25); // X Y W H
		add(paSenha);
		
		// JButton Salvar
		btSalvar = new JButton("Salvar");
		btSalvar.setBounds(150, 280, 100, 30); // X Y W H
		add(btSalvar);
		
		
		// Ação do botão
				btSalvar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						String nome = txNome.getText();
						String email = txEmail.getText();
						String telefone = txTelefone.getText();
						String cpf = txCPF.getText();
						String endereco = txEndereco.getText();
						
						String sexo = "";
						if (chbSexoF.isSelected()) {
							sexo += " " + lbSexoF.getText();
						}
						if (chbSexoM.isSelected()) {
							sexo += " " + lbSexoM.getText();
						}
						if (chbSexoO.isSelected()) {
							sexo += " " + lbSexoO.getText(); 
						}
						
						String senha = new String(paSenha.getPassword());
						
						// Verifica se todos os campos foram preenchidos
						if (nome.trim().isEmpty() ||
							email.trim().isEmpty() ||
							telefone.trim().isEmpty() ||
							telefone.contains("_") ||
							cpf.trim().isEmpty() ||
							cpf.contains("_") ||
							endereco.trim().isEmpty() ||
							sexo.trim().isEmpty() ||
							senha.trim().isEmpty()) {
							
							JOptionPane.showMessageDialog(null,
									"Por favor, preencha todos os campos antes de continuar.",
									"Campos obrigatórios",
									JOptionPane.WARNING_MESSAGE);
							return;
						}

						// Todos os campos preenchidos: fecha o cadastro e abre o menu principal
						dispose();
						new Menu();
					}
				});

				// setVisible última linha do construtor
				setVisible(true);
	}
}