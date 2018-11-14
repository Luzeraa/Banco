package banco;

import java.util.ArrayList;

public class Gerenciar {

    private ArrayList<Contas> lista = new ArrayList<>();

    public void adicionarConta(Contas c) {
        lista.add(c);
    }

    public boolean removerConta(int numeroConta) {
        for (int i = 0; i < lista.size(); i++) {
            Contas c = lista.get(i);
            if (c.getNumeroConta() == numeroConta) {
                lista.remove(c);
                return true;
            }
        }
        return false;
    }

    public String buscarContaEspecial() {
        String saida = "";
        for (Contas conta : lista) {
            if(conta instanceof ContaEspecial){
            saida += conta.toString() + "\n";
            return saida;
            }     
        }
        return "Nao encontrado";
    }

    public String buscarClientesUsandoLimite() {
        String saida = " ";
        for (Contas conta : lista) {
            if(conta instanceof ContaCorrente && conta.getSaldo() < 0){
            saida += conta.toString() + "\n";
            return saida;       
            }       
        }
        return "Nao encontrado";
    }

    public Contas buscarConta(int numeroConta) {
        for (Contas conta : lista) {
            if (conta.getNumeroConta() == numeroConta) {
                conta.toString();
                return conta;
            }
        }
        return null;
    }

    public boolean transferirValor(int numeroContaOrigem, int numeroContaDestino,
            float valor) {

        Contas c1 = buscarConta(numeroContaOrigem);
        Contas c2 = buscarConta(numeroContaDestino);
        if (c1 != null && c2 != null) {
            if (c1.getSaldo() >= valor) {
                if (c1 instanceof ContaCorrente) {
                    c1.sacar(valor);
                    c2.depositar(valor);
                } else {
                    c1.sacar(valor);
                    c2.depositar(valor);
                }
                return true;
            }

        }
        return false;
    }

    public boolean sacar(int numeroConta, float valorSacado) {
        Contas c = buscarConta(numeroConta);
        if (c != null) {
            c.sacar(valorSacado);
            return true;
        }
        return false;

    }

    public boolean depositar(int numeroConta, float valorDepositado) {
        Contas c = buscarConta(numeroConta);
        if (c != null) {
            c.depositar(valorDepositado);
            return true;
        }
        return false;
    }

    public String listarContas() {
        String saida = "";
        for (Contas conta : lista) {
            saida += conta.toString() + "\n";
        }
        return saida;
    }

}
