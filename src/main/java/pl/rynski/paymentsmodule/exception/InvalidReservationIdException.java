package pl.rynski.paymentsmodule.exception;

public class InvalidReservationIdException extends Exception{
    private static final long serialVersionUID = -3154614213130084535L;
    private static final String MESSAGE = "Payment with given reservation id already exists";

    public InvalidReservationIdException() {
        super(MESSAGE);
    }
}
