package service;

import model.Conta;

public class ContaService {
    private static Integer numeroConta = 1;
    private static Integer numeroAgencia = 1;

    public Conta cadastrar(String nome) {
        Conta novaConta = new Conta(numeroConta, numeroAgencia, nome);
        numeroConta++;
        numeroAgencia++;

        return novaConta;
    }

    public void depositar(Conta conta, Double valor) {
        conta.setSaldo(conta.getSaldo() + valor);
    }

    public void sacar(Conta conta, Double valor) throws Exception {
        if(valor < 0) {
            throw new Exception("O valor do saque não pode ser negativo");
        }

        if(conta.getSaldo() >= valor) {
            conta.setSaldo(conta.getSaldo() - valor);
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public void transferir(Conta contaTransferindo, Conta contaRecebendo, Double valor) {
        if(contaTransferindo.getSaldo() >= valor) {
            contaTransferindo.setSaldo(contaTransferindo.getSaldo() - valor);
            contaRecebendo.setSaldo(contaRecebendo.getSaldo() + valor);
        }
    }
}
