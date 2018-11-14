package banco;
   
public class ContaEspecial extends ContaCorrente {
    private String gerenteResponsavel; 
    
 
    public ContaEspecial(int numeroConta, String nomeCliente, String cpf, String gerenteResponsavel) {
        super(numeroConta, nomeCliente, cpf, gerenteResponsavel);      
        this.gerenteResponsavel = gerenteResponsavel;
    }
      
    public ContaEspecial(int numeroConta, String nomeCliente, String cpf,float limite, String gerenteResponsavel) {
        super(numeroConta, nomeCliente, cpf, limite, gerenteResponsavel);      
        this.gerenteResponsavel = gerenteResponsavel;
    }


    
    public String getGerenteResponsavel() {
        return gerenteResponsavel;
    }

    public void setGerenteResponsavel(String gerenteResponsavel) {
        this.gerenteResponsavel = gerenteResponsavel;
    }
    
    
    @Override
    public boolean sacar(float valor) {
        if ((super.getSaldo() - valor) >= 0) {
            super.sacar(valor);
            return true;
        } 
            return false;
    }

    @Override
    public boolean depositar(float valor) {
        if (valor >= 0) {
            super.depositar(valor);
            return true;
        } 
            return false;
    }
    
    @Override
    public String toString(){
        return "Titular: " + getNomeCliente() + "\nNº conta: " + getNumeroConta() +"\nCPF: " + getCpf() + "\nSaldo: " 
                        + getSaldo() + "\nLimite: " + getLimite() + "\nGerente responsável: " + gerenteResponsavel +"\n";
    }
    
    
}
