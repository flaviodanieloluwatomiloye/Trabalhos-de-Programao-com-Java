public class ControleDeAumento {
    private double totalDeAumento = 0;

    // Aqui ta a logica do Polimorfismo, aceita Funcionario e qualquer subclasse tipo a dp gerente
    public void registrar(Funcionario funcionario) {
        this.totalDeAumento += funcionario.aumentarSalario();
    }

    public double getTotalDeAumento() {
        return totalDeAumento;
    }
}