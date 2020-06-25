package pl.rynski.paymentsmodule.exception;

public class InvalidCostException extends Exception{
    private static final long serialVersionUID = -3154618962130084535L;
    private static final String MESSAGE = "Cost must be bigger than 0";

    public InvalidCostException() {
        super(MESSAGE);
    }
}
