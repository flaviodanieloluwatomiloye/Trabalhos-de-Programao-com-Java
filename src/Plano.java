public class Plano {
    private String nomePlano; 
    private double preco;
    private int duracao; 
    private String intervaloPagamento; //anal mensal etc...

   public Plano (String nomePlano, double preco, int duracao, String intervaloPagamento) {
	   this.duracao = duracao;
	   this.intervaloPagamento = intervaloPagamento;
	   this.duracao = duracao;
	   this.nomePlano = nomePlano;
	   
 }

   public String getNomePlano() {
	return nomePlano;
   }

   public void setNomePlano(String nomePlano) {
	this.nomePlano = nomePlano;
   }

   public double getPreco() {
	return preco;
   }

   public void setPreco(double preco) {
	this.preco = preco;
   }

   public int getDuracao() {
	return duracao;
   }

   public void setDuracao(int duracao) {
	this.duracao = duracao;
   }

   public String getIntervaloPagamento() {
	return intervaloPagamento;
   }

   public void setIntervaloPagamento(String intervaloPagamento) {
	this.intervaloPagamento = intervaloPagamento;
   }

   @Override
   public String toString() {
	   return nomePlano + " (R$ " + preco + " - " + intervaloPagamento + ")";
   }

}