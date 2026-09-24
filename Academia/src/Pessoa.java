
public abstract class Pessoa {
	private String Nome;
	private String Cpf;
	public String Idade;
	
	public String getIdade() {
		return Idade;
	}

	public void setIdade(String idade) {
		Idade = idade;
	}

	public Pessoa(String Nome, String Cpf){
		this.Nome = Nome;
		this.Cpf = Cpf;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCpf() {
		return Cpf;
	}

	public void setCpf(String cpf) {
		Cpf = cpf;
	}
}
