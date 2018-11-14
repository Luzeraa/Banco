package banco;
  
public class ContaCorrente extends Contas {
 
    private float limite;
    
    public ContaCorrente(int numeroConta, String nomeCliente, String cpf,
            String gerenteResponsavel) {
        super(numeroConta, nomeCliente, cpf);       
    } 
    
    public ContaCorrente(int numeroConta, String nomeCliente, String cpf, float limite,
                String gerenteResponsavel) {
        super(numeroConta, nomeCliente, cpf);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }
 
    public void setLimite(float limite) {
        this.limite = limite;
    }
     
    @Override
    public boolean sacar(float valor){ 
       if((valor <= (getSaldo()+ limite) ) ){
            super.sacar(valor);
            return true;
       }else{
           return false;
       }
    }
        
    @Override
    public String toString(){
        return "Titular: " + getNomeCliente() + "\nNº conta: " + getNumeroConta() + "\nCPF: " 
                + getCpf() + "\nSaldo: " + getSaldo() + "\nLimite: " + limite + "\n";
    }
    
    public boolean usandoLimite(float saque){
        if(sacar(saque) == true){
            return true;
        }else{
            return false;
        }
    }
    
   
 
    
}
