package com.ptngaye.spocktutorial.mocks

import com.ptngaye.spocktutorial.*
import spock.lang.Specification

class OrderServiceSpec extends Specification {

    PaymentCard PAYMENT_CARD = buildPaymentCard()
    String CUSTOMER_REFERENCE = 'CUSTOMER-02'

    def 'should return transaction id and the updated order when payment succeed'() {
        given:
        String internalReference = 'azerty-17'
        float amount = 25f
        Order order = new Order(amount: amount, reference:internalReference, customerReference:CUSTOMER_REFERENCE)

        PaymentService paymentService = Mock() {
            _ * makePayment(PAYMENT_CARD, internalReference, amount) >> PAYMENT_RESULT_SUCCESS
        }

        OrderService orderService = new OrderService()
        orderService.paymentService = paymentService

        when:
        Order orderActual = orderService.validateOrder(PAYMENT_CARD, order)

        then:
        orderActual.reference == order.reference
        orderActual.customerReference == order.customerReference
        orderActual.amount == order.amount
        orderActual.status == OrderStatus.PAID
        orderActual.paymentTransactionId == PAYMENT_RESULT_SUCCESS.transactionId
    }

    def 'should throw an Exception when payment failed'() {
        given:
        String internalReference = 'azerty-17'
        float amount = 25f
        Order order = new Order(amount: amount, reference:internalReference, customerReference:CUSTOMER_REFERENCE)

        PaymentService paymentService = Mock()
        1 * paymentService.makePayment(PAYMENT_CARD, internalReference, amount) >> PAYMENT_RESULT_FAILED


        OrderService orderService = new OrderService()
        orderService.paymentService = paymentService

        when:
        Order orderActual = orderService.validateOrder(PAYMENT_CARD, order)

        then:
        thrown(PaymentFailedException)
    }

    PaymentCard buildPaymentCard() {
        new PaymentCard(
                type:'MASTER_CARD',
                number: '1111222233334444',
                expMonth: '12',
                expYear: '2014',
                cvv: '700'
        )
    }

    PaymentResult PAYMENT_RESULT_SUCCESS = new PaymentResult('MASTER CARD TRANSACTION ID')
    PaymentResult PAYMENT_RESULT_FAILED = new PaymentResult()

}

//1 * subscriber.receive("hello")      // exactly one call
//0 * subscriber.receive("hello")      // zero calls
//(1..3) * subscriber.receive("hello") // between one and three calls (inclusive)
//(1.._) * subscriber.receive("hello") // at least one call
//(_..3) * subscriber.receive("hello") // at most three calls
//_ * subscriber.receive("hello")      // any number of calls, including zero
//// (rarely needed; see 'Strict Mocking')