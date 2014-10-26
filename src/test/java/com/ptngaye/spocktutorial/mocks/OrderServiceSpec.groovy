package com.ptngaye.spocktutorial.mocks

import com.ptngaye.spocktutorial.PaymentCard
import com.ptngaye.spocktutorial.PaymentService
import spock.lang.Specification

import java.time.LocalDate

class OrderServiceSpec extends Specification {

    def 'easter day in 2014 is 20 aprilhh '() {
        given:
        PaymentCard paymentCard = new PaymentCard(
                cvv: '700',
                numCard: '1111222233334444',
                nameOnCard: 'Paterne Gaye',
                yearEndValidation: 2014,
                montEndValidation: 12
        )
        Pa
        String internalReference= 'ffff'
        float amount = 25f
        def paymentService = Mock(PaymentService)
        _ * paymentService.makePayment(paymentCard,internalReference,amount) >>
        when:
        LocalDate easterDayActual = holidaysHelper.identifyEasterDay(year)

        then:
        1 * component1.receive("hello")
    }
}

//1 * subscriber.receive("hello")      // exactly one call
//0 * subscriber.receive("hello")      // zero calls
//(1..3) * subscriber.receive("hello") // between one and three calls (inclusive)
//(1.._) * subscriber.receive("hello") // at least one call
//(_..3) * subscriber.receive("hello") // at most three calls
//_ * subscriber.receive("hello")      // any number of calls, including zero
//// (rarely needed; see 'Strict Mocking')