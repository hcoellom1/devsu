package hn.devsu.excersice.clientes.domain.exception;

public class NotSaldoException extends RuntimeException{
    public NotSaldoException(int idcuenta){
        super("La cuenta: " + idcuenta +  " no tiene saldo");
    }
}
