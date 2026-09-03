import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JFrame{

	public Menu() {
		this.setSize(800,600);
    	this.setTitle("Menu");
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	this.setLocationRelativeTo(null);
    	this.setExtendedState(MAXIMIZED_BOTH);
    	
    	//Main menu
    	JMenu alunos = new JMenu("Alunos");
    	JMenu prof = new JMenu("Professores");
    	JMenu outros = new JMenu("Outros");
    	JMenu sair =  new JMenu("Sair");
    	
    	//items
    	JMenuItem aluCad = new JMenuItem("Alunos Cadastrados");
    	JMenuItem cadAluno = new JMenuItem("Cadastrar Aluno");
    	JMenuItem profCad = new JMenuItem("Professores Cadastrados");
    	JMenuItem cadProf = new JMenuItem("Cadastrar Professor");
    	JMenuItem planos = new JMenuItem("Planos");
    	JMenuItem aulas = new JMenuItem("Aulas");
    	JMenuItem confSair = new JMenuItem("Confirmar Saida");
    	
    	//Conectando itens
    	alunos.add(aluCad);
    	alunos.add(cadAluno);
    	prof.add(profCad);
    	prof.add(cadProf);
    	outros.add(planos);
    	outros.add(aulas);
    	sair.add(confSair);
    	
    	//Cadastrar Aluno
    	cadAluno.addActionListener(
				new ActionListener(){
						public void actionPerformed(ActionEvent event){
							new CadastrarAluno();
						}
				}
			);

    	//Alunos Cadastrados
    	aluCad.addActionListener(
				new ActionListener(){
						public void actionPerformed(ActionEvent event){
							new AlunosMatriculados();
						}
				}
			);
    	
    	//Barra menu 
    	JMenuBar bar = new JMenuBar();
    	setJMenuBar(bar);
    	bar.add(alunos);
    	bar.add(prof);
    	bar.add(outros);
    	bar.add(sair);
    	
    	//Sair
    	confSair.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						System.exit(0);
					}
				}
			);
    	
    	this.setVisible(true);
	}
}