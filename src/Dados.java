import java.util.ArrayList;
import java.util.List;
 
public class Dados {
 
	public static List<Plano> planos = new ArrayList<>();
	public static List<Instrutor> instrutores = new ArrayList<>();
	public static List<AlunoCadastrado> alunos = new ArrayList<>();
 
	// Dados iniciais de exemplo
	static {
		Plano planoMensal = new Plano("Plano Mensal", 100, 1, "Mensal");
		Plano planoTrimestral = new Plano("Plano Trimestral", 250, 3, "Trimestral");
		planos.add(planoMensal);
		planos.add(planoTrimestral);
 
		Instrutor instrutorAlfredo = new Instrutor("Alfredo", "111.222.333-44", "Musculação");
		instrutores.add(instrutorAlfredo);
 
		// Aluno 1 com o plano mensal
		AlunoCadastrado aluno1 = new AlunoCadastrado("Cassio", "555.666.777-88", planoMensal, instrutorAlfredo);
		alunos.add(aluno1);
 
		// Aluno 2 com o plano trimestral
		AlunoCadastrado aluno2 = new AlunoCadastrado("Lacerdao", "999.888.777-66", planoTrimestral, instrutorAlfredo);
		alunos.add(aluno2);
	}
}
