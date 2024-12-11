package labs.kpi.models;

import labs.kpi.annotations.*;

/**
 * Represents an order with an ID, quantity, and total amount.
 *
 * @author Oleksii Kyrychenko
 */
public class Order {

    @NotNull
    private String orderId;

    @MinValue(1)
    private int quantity;

    @MinValue(0)
    private int totalAmount;

    public Order(String orderId, int quantity, int totalAmount) {
        this.orderId = orderId;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
}