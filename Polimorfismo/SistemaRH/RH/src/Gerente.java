public class Gerente extends Funcionario {
    private String matricula;

    public Gerente(String nome, String cpf, double salario, String matricula) {
        super(nome, cpf, salario);
        this.matricula = matricula;
    }

    // Sobrescrita do método pra devolver 20%
    @Override
    public double aumentarSalario() {
        return this.getSalario() * 0.20;
    }

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}