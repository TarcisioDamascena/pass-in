package Damascena.passin.domain.checkin.exceptions;

public class CheckInAlreadyExistsException extends RuntimeException{
    public CheckInAlreadyExistsException(String message)
    {
        super(message);
    }
}
