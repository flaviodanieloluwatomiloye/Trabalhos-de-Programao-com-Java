import javax.swing.JOptionPane;

public class CalculoISS implements Imposto {
	
    @Override
    public void CobrarImposto(double valor) {
        double resultado = valor * 0.05; // 5%
        JOptionPane.showMessageDialog(null, 
            "--- CÁLCULO ISS ---\n" +
            "Valor base: R$ " + valor + "\n" +
            "Imposto ISS (5%): R$ " + resultado + "\n" +
            "Total: R$ " + (valor + resultado));
    }
}
