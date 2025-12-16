package hn.devsu.excersice.clientes.domain.exception;

public class NotCuentaFoundException extends RuntimeException {
    public NotCuentaFoundException(int id){
        super("No existe cuenta con el id: " + id);
    }
}
