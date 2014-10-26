package com.ptngaye.spocktutorial;

class OrderService {
    private PaymentService paymentService;
    private OrderDao orderDao;

    public void validateOrder(PaymentCard paymentCard, Order order) throws PaymentFailedException {
        PaymentTransactionResult transactionResult = paymentService.makePayment(
                paymentCard, order.getReference(), order.getAmount());
        if (!transactionResult.isFailed()) {
            orderDao.changeStatusToPyaid(order);
        }else {
            throw new PaymentFailedException();
        }
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
}
