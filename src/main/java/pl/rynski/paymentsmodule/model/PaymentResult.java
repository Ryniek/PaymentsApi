package pl.rynski.paymentsmodule.model;

public class PaymentResult {

    private Long reservationId;
    private boolean isPaid;

    public PaymentResult() {
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
