package com.ptngaye.spocktutorial.mocks

import com.ptngaye.spocktutorial.Order
import com.ptngaye.spocktutorial.OrderService
import com.ptngaye.spocktutorial.PaymentCard
import com.ptngaye.spocktutorial.PaymentService
import com.ptngaye.spocktutorial.PaymentResult
import spock.lang.Specification

import java.time.LocalDate


class OrderServiceSpec extends Specification {

    def 'should sa day in 2014 is 20 aprilhh '() {
        given:
        PaymentCard paymentCard = buildPaymentCard()
        String internalReference= 'azerty-17'
        float amount = 25f
        PaymentResult paymentResultExpected = PAYMENT_RESULT_SUCCESS

        PaymentService paymentService = Mock(){
            _ * makePayment(paymentCard,internalReference,amount) >> paymentResultExpected
        }

        OrderService orderService = new OrderService()
        orderService.paymentService = paymentService


        when:
        Order orderActual = orderService.validateOrder(paymentCard, order)

        then:
        orderActual.reference==
                orderActual.customerReference==
                orderActual.amount==
                orderActual.status==
    }

    PaymentCard buildPaymentCard(){
        new PaymentCard(
                type:'MASTER_CARD',
                number: '1111222233334444',
                expMonth: '12',
                expYear: '2014',
                cvv: '700'
        )
    }
    PaymentResult PAYMENT_RESULT_SUCCESS = new PaymentResult(failed:false)
    PaymentResult PAYMENT_RESULT_FAILED = new PaymentResult(failed:true)

}

//1 * subscriber.receive("hello")      // exactly one call
//0 * subscriber.receive("hello")      // zero calls
//(1..3) * subscriber.receive("hello") // between one and three calls (inclusive)
//(1.._) * subscriber.receive("hello") // at least one call
//(_..3) * subscriber.receive("hello") // at most three calls
//_ * subscriber.receive("hello")      // any number of calls, including zero
//// (rarely needed; see 'Strict Mocking')