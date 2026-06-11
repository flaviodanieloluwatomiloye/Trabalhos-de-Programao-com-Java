import javax.swing.JOptionPane;

public class Aplicacao {

	public static void main(String[] args) {
		
        double valorProduto = Double.parseDouble(JOptionPane.showInputDialog(null, 
                "Digite o valor do produto/serviço:"));
        
        int menuEscolha = Integer.parseInt(JOptionPane.showInputDialog(null, 
                "O que você deseja calcular:\n"
                + "1 - Imposto para ICMS\n"
                + "2 - Imposto para ISS\n"
                + "3 - Imposto para IPI\n"));

        Imposto impostoSelecionado = null;

        switch (menuEscolha) {
            case 1:
                impostoSelecionado = new CalculoICMS();
                break;
            case 2:
                impostoSelecionado = new CalculoISS();
                break;
            case 3:
                impostoSelecionado = new CalculoIPI();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção Inválida!"); 
                break;
        }

        //Se a opção foi válida, roda o cálculo e mostra o JOptionPane da classe correspondente
        if (impostoSelecionado != null) {
            impostoSelecionado.CobrarImposto(valorProduto);
        }
	}

}
