import javax.swing.JOptionPane;

public class CalculoIPI implements Imposto {
	
    @Override
    public void CobrarImposto(double valor) {
        double resultado = valor * 0.10; // 10%
        JOptionPane.showMessageDialog(null, 
            "--- CÁLCULO IPI ---\n" +
            "Valor base: R$ " + valor + "\n" +
            "Imposto IPI (10%): R$ " + resultado + "\n" +
            "Total: R$ " + (valor + resultado));
    }
}
