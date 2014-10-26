package com.ptngaye.spocktutorial;

public class OrderDao {
    public void changeStatusToPyaid(Order order) {
        order.setPaid(true);
    }
}
