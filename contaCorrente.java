import java.util.Date;
public class contaCorrente {




        private String numeroConta;
        private String numeroAgencia;
        private String nomeCliente;
        private Date dataNascimento;
        private double saldo;


        public contaCorrente(String numeroConta, String numeroAgencia, String nomeCliente, Date dataNascimento, double saldoInicial) {
            this.numeroConta = numeroConta;
            this.numeroAgencia = numeroAgencia;
            this.nomeCliente = nomeCliente;
            this.dataNascimento = dataNascimento;
            this.saldo = saldoInicial;
        }


        public String getNumeroConta() {
            return numeroConta;
        }

        public void setNumeroConta(String numeroConta) {
            this.numeroConta = numeroConta;
        }

        public String getNumeroAgencia() {
            return numeroAgencia;
        }

        public void setNumeroAgencia(String numeroAgencia) {
            this.numeroAgencia = numeroAgencia;
        }

        public String getNomeCliente() {
            return nomeCliente;
        }

        public void setNomeCliente(String nomeCliente) {
            this.nomeCliente = nomeCliente;
        }

        public Date getDataNascimento() {
            return dataNascimento;
        }

        public void setDataNascimento(Date dataNascimento) {
            this.dataNascimento = dataNascimento;
        }

        public double getSaldo() {
            return saldo;
        }

        // Métodos
        public boolean sacar(double valor) {
            if (valor > 0 && valor <= saldo) {
                saldo -= valor;
                return true;
            }
            return false;
        }

        public boolean transferir(contaCorrente contaDestino, double valor) {
            if (sacar(valor)) {
                contaDestino.depositar(valor);
                return true;
            }
            return false;
        }

        public void depositar(double valor) {
            if (valor > 0) {
                saldo += valor;
            }
        }

        public void cancelarConta(String justificativa) {
            // Aqui você pode adicionar lógica para registrar a justificativa e realizar outras ações necessárias
            System.out.println("Conta cancelada. Justificativa: " + justificativa);
            saldo = 0;
        }

        public double consultarSaldo() {
            return saldo;
        }
    public static void main(String[] args) {

        contaCorrente conta1 = new contaCorrente("12345-6", "001", "João Silva", new Date(), 1000.0);
        contaCorrente conta2 = new contaCorrente("65432-1", "002", "Maria Oliveira", new Date(), 500.0);


        System.out.println("Saldo inicial de João: " + conta1.consultarSaldo());
        System.out.println("Saldo inicial de Maria: " + conta2.consultarSaldo());

        conta1.sacar(200.0);
        System.out.println("Saldo de João após saque: " + conta1.consultarSaldo());


        conta2.depositar(300.0);
        System.out.println("Saldo de Maria após depósito: " + conta2.consultarSaldo());


        conta1.transferir(conta2, 100.0);
        System.out.println("Saldo de João após transferência: " + conta1.consultarSaldo());
        System.out.println("Saldo de Maria após receber transferência: " + conta2.consultarSaldo());


        conta1.cancelarConta("Cliente solicitou encerramento.");
        System.out.println("Saldo de João após cancelamento: " + conta1.consultarSaldo());
    }
    }


