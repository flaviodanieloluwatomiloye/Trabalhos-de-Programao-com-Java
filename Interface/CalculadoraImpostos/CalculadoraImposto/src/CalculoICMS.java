import javax.swing.JOptionPane;

public class CalculoICMS implements Imposto{

	@Override
	public void CobrarImposto(double valor) {
        double resultado = valor * 0.18; // 18%
        JOptionPane.showMessageDialog(null, 
            "--- CÁLCULO ICMS ---\n" +
            "Valor base: R$ " + valor + "\n" +
            "Imposto ICMS (18%): R$ " + resultado + "\n" +
            "Total: R$ " + (valor + resultado));
    }
} 
