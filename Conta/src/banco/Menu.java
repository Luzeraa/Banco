package banco;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Gerenciar lista = new Gerenciar();

        int opcao = 0, opcaoConta = 0;
        int numeroConta = 0, numeroContaOrigem = 0, numeroContaDestino = 0;
        String nomeCliente, cpf, gerenteResponsavel;
        float limite = 0, valorTransferencia = 0, valorSacado, valorDepositado = 0;

        do {

            System.out.println("Digite a opção desejada: \n"
                    + "(1)  Adicionar conta \n"
                    + "(2)  Remover Conta\n"
                    + "(3)  Buscar Contas Especiais\n"
                    + "(4)  Buscar clientes utilizando o limite\n"
                    + "(5)  Buscar Contas \n"
                    + "(6)  Transferir valor \n"
                    + "(7)  Sacar\n"
                    + "(8)  Depositar\n"
                    + "(9)  Listar contas \n"
                    + "(10) Finalizar operação \n");

            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println(" ");
                    System.out.println("Que tipo de conta deseja adicionar? \n"
                            + "(1) Conta Corrente\n"
                            + "(2) Conta Especial\n"
                            + "(3) Conta Poupança\n");
                    opcaoConta = input.nextInt();
                    switch (opcaoConta) {
                        case 1:
                            System.out.println("Digite o numero da conta: ");
                            numeroConta = input.nextInt();
                            input.nextLine();

                            System.out.println("Digite o nome do titular: ");
                            nomeCliente = input.nextLine();

                            System.out.println("Digite o CPF do titular: ");
                            cpf = input.nextLine();

                            System.out.println("Digite o limite do titular");
                            limite = input.nextFloat();

                            System.out.println("Digite o nome do gerente responsavel");
                            input.nextLine();
                            gerenteResponsavel = input.nextLine();

                            ContaCorrente contaCorrente = new ContaCorrente(numeroConta, nomeCliente, cpf, limite,
                                    gerenteResponsavel);
                            lista.adicionarConta(contaCorrente);
                            break;
                        case 2:
                            System.out.println("Digite o numero da conta: ");
                            numeroConta = input.nextInt();
                            input.nextLine();

                            System.out.println("Digite o nome do titular: ");
                            nomeCliente = input.nextLine();

                            System.out.println("Digite o CPF do titular: ");
                            cpf = input.nextLine();

                            System.out.println("Digite o limite do titular");
                            limite = input.nextFloat();

                            System.out.println("Digite o nome do gerente responsavel");
                            input.nextLine();
                            gerenteResponsavel = input.nextLine();

                            ContaEspecial contaEspecial = new ContaEspecial(numeroConta, nomeCliente, cpf, limite,
                                    gerenteResponsavel);
                            lista.adicionarConta(contaEspecial);
                            break;
                        case 3:
                            System.out.println("Digite o numero da conta: ");
                            numeroConta = input.nextInt();
                            input.nextLine();

                            System.out.println("Digite o nome do titular: ");
                            nomeCliente = input.nextLine();

                            System.out.println("Digite o CPF do titular: ");
                            cpf = input.nextLine();

                            ContaPoupanca contaPoupanca = new ContaPoupanca(numeroConta, nomeCliente, cpf);
                            lista.adicionarConta(contaPoupanca);
                             break;
                    }
                    break;
                case 2:
                    System.out.println("Digite o numero da conta que deseja remover: ");
                    numeroConta = input.nextInt();
                    lista.removerConta(numeroConta);
                    break; 
                case 3:
                    System.out.println(lista.buscarContaEspecial());
                    
                    break;
                case 4:
                    System.out.println(lista.buscarClientesUsandoLimite());
                    break;
                case 5:
                    System.out.println("Digite o numero da conta que deseja buscar: ");
                    numeroConta = input.nextInt();
                    System.out.println(lista.buscarConta(numeroConta));
                    break;
                case 6:
                    System.out.println("Digite o numero da conta origem: ");
                    numeroContaOrigem = input.nextInt();
                    
                    System.out.println("Digite o numero da conta destino: ");
                    numeroContaDestino = input.nextInt();
                    
                    System.out.println("Digite o valor da transferencia: ");
                    valorTransferencia = input.nextFloat();
                    
                    lista.transferirValor(numeroContaOrigem, numeroContaDestino, limite);
                    break;
                case 7:
                    System.out.println("Digite o numero da conta: ");
                    numeroConta = input.nextInt();
                    
                    System.out.println("Digite o valor que deseja sacar: ");
                    valorSacado = input.nextFloat();
                    lista.sacar(numeroConta, valorSacado);
                    break;
                case 8: 
                    System.out.println("Digite o numero da conta: ");
                    numeroConta = input.nextInt();
                    
                    System.out.println("Digite o valor que deseja depositar: ");
                    valorDepositado = input.nextFloat();
                    
                    lista.depositar(numeroConta, valorDepositado);
                    break;
                case 9:
                    System.out.println(lista.listarContas());
                    System.out.println(" ");
                    break;
                case 10:   
                    break;
            }

        } while (opcao != 0);
    }
}