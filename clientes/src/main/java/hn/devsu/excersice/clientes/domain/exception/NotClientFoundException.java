package hn.devsu.excersice.clientes.domain.exception;

public class NotClientFoundException extends RuntimeException{
    public NotClientFoundException(int id){
        super("Cliente con id: " + id + " no encontrado");
    }
    
}
