public class Instrutor extends Pessoa {
    private String funcao; 

    public Instrutor(String nome, String cpf, String funcao) {
        super(nome, cpf);
        this.funcao = funcao;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return getNome() + " (" + funcao + ")";
    }
}