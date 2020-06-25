package pl.rynski.paymentsmodule.model;


public class Payment {

    private Long user_id;
    private Long reservation_id;
    private double cost;

    public Payment() {
    }

    public Payment(Long user_id, Long reservation_id, double cost) {
        this.user_id = user_id;
        this.reservation_id = reservation_id;
        this.cost = cost;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(Long reservation_id) {
        this.reservation_id = reservation_id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "user_id=" + user_id +
                ", reservation_id=" + reservation_id +
                ", cost=" + cost +
                '}';
    }
}
