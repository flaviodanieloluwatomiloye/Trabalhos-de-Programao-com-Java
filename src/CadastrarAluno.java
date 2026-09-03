import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
 
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
 
public class CadastrarAluno extends JFrame {
 
	private JLabel lbTitulo, lbNome, lbCPF, lbPlano, lbInstrutor;
	private JTextField txNome;
	private JFormattedTextField txCPF;
	private JComboBox<Plano> cbPlano;
	private JComboBox<Instrutor> cbInstrutor;
	private JButton btSalvar;
 
	public CadastrarAluno() {
		setTitle("Cadastrar Aluno");
		setSize(800, 600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
 
		// Título
		lbTitulo = new JLabel("Cadastro de Aluno");
		lbTitulo.setBounds(140, 15, 250, 25);
		add(lbTitulo);
 
		// Nome
		lbNome = new JLabel("Nome: ");
		lbNome.setBounds(40, 60, 100, 25);
		add(lbNome);
 
		txNome = new JTextField();
		txNome.setBounds(150, 60, 220, 25);
		add(txNome);
 
		// CPF
		lbCPF = new JLabel("CPF: ");
		lbCPF.setBounds(40, 100, 100, 25);
		add(lbCPF);
 
		try {
			MaskFormatter mascaraCPF = new MaskFormatter("###.###.###-##");
			txCPF = new JFormattedTextField(mascaraCPF);
		} catch (ParseException e) {
			txCPF = new JFormattedTextField();
		}
		txCPF.setBounds(150, 100, 150, 25);
		add(txCPF);
 
		// Plano
		lbPlano = new JLabel("Plano: ");
		lbPlano.setBounds(40, 140, 100, 25);
		add(lbPlano);
 
		cbPlano = new JComboBox<>(Dados.planos.toArray(new Plano[0]));
		cbPlano.setBounds(150, 140, 220, 25);
		add(cbPlano);
 
		// Instrutor
		lbInstrutor = new JLabel("Instrutor: ");
		lbInstrutor.setBounds(40, 180, 100, 25);
		add(lbInstrutor);
 
		cbInstrutor = new JComboBox<>(Dados.instrutores.toArray(new Instrutor[0]));
		cbInstrutor.setBounds(150, 180, 220, 25);
		add(cbInstrutor);
 
		// Botão Salvar
		btSalvar = new JButton("Salvar");
		btSalvar.setBounds(150, 240, 120, 30);
		add(btSalvar);
 
		btSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nome = txNome.getText();
				String cpf = txCPF.getText();
 
				// Não deixa prosseguir sem preencher nome e CPF
				if (nome.trim().isEmpty() || cpf.trim().isEmpty() || cpf.contains("_")) {
					JOptionPane.showMessageDialog(null,
							"Por favor, preencha nome e CPF corretamente.",
							"Campos obrigatórios",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
 
				if (cbPlano.getSelectedItem() == null || cbInstrutor.getSelectedItem() == null) {
					JOptionPane.showMessageDialog(null,
							"Cadastre ao menos um Plano e um Instrutor antes de continuar.",
							"Dados indisponíveis",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
 
				JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
				dispose();
			}
		});
 
		setVisible(true);
	}
}