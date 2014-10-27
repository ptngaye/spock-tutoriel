package com.ptngaye.spocktutorial;

class OrderService {
    private PaymentService paymentService;

    public Order validateOrder(final PaymentCard paymentCard, final Order order) throws PaymentFailedException {
        final String internalReference = order.getReference();
        final float amount = order.getAmount();

        //Appel du composant externe de paiement (exemple PAYBOX)
        PaymentResult transactionResult = paymentService.makePayment(paymentCard, internalReference, amount);

        //Si le paiement échoue, on arrête le processus
        if (transactionResult.isFailed()) {
            throw new PaymentFailedException();
        }

        //Si le paiement réussit, on met à jour la ccommande
        return updateOrderWhenPaymentIsdone(order);
    }

    private Order updateOrderWhenPaymentIsdone(Order order) {
        order.setStatus(OrderStatus.PAID);
        return order.save();
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
