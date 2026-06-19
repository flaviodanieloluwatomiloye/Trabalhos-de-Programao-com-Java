import javax.swing.JOptionPane;

public class Aplicacao {
    public static void main(String[] args) {
    	
        ControleDeAumento controle = new ControleDeAumento();

        String salarioGerenteStr = JOptionPane.showInputDialog(null, 
        		"Digite o salário original do Gerente:", 
        		"Entrada de Dados", 
        		JOptionPane.QUESTION_MESSAGE);
        
        double salarioGerente = Double.parseDouble(salarioGerenteStr);
        Gerente gerente = new Gerente("Carlos", "420.453.654.65", salarioGerente, "F567");

        String salarioFuncionarioStr = JOptionPane.showInputDialog(null, 
        		"Digite o salário original do Funcionário:", 
        		"Entrada de Dados", 
        		JOptionPane.QUESTION_MESSAGE);
        
        double salarioFuncionario = Double.parseDouble(salarioFuncionarioStr);
        Funcionario funcionario = new Funcionario("Ana", "423.345.845-67", salarioFuncionario);

        controle.registrar(gerente);
        controle.registrar(funcionario);

        double salarioFinalGerente = 
        		gerente.getSalario() + gerente.aumentarSalario();
        double salarioFinalFuncionario = funcionario.getSalario() + funcionario.aumentarSalario();

        String mensagem = String.format(
                "--- GERENTE ---\n" +
                "Salário Original: R$ %.2f\n" +
                "Valor do Aumento (20%%): R$ %.2f\n" +
                "Salário Final: R$ %.2f\n\n" +
                
                "--- FUNCIONÁRIO ---\n" +
                "Salário Original: R$ %.2f\n" +
                "Valor do Aumento (10%%): R$ %.2f\n" +
                "Salário Final: R$ %.2f\n\n" +
                
                "-------------------------------------\n" +
                "Total acumulado de aumentos: R$ %.2f",
                
                gerente.getSalario(), gerente.aumentarSalario(), salarioFinalGerente,
                funcionario.getSalario(), funcionario.aumentarSalario(), salarioFinalFuncionario,
                controle.getTotalDeAumento()
            );

        JOptionPane.showMessageDialog(
            null, 
            mensagem, 
            "Relatório de Aumentos Salariais", 
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}