//package com.intelliguru.javalearning.beanscope.manager;
//
//import com.intelliguru.javalearning.beanscope.entity.PaymentDetails;
//import com.intelliguru.javalearning.beanscope.service.payment.PaymentService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Component;
//
//@Component
//@Slf4j
//public class OtherPaymentManager {
//    @Autowired
////    @Qualifier("creditCardPaymentService")
//    private PaymentService paymentService;
//
//    public void processPayment(PaymentDetails paymentDetails) {
//        boolean isPaymentProcessed = paymentService.processPayment(paymentDetails);
//        if (isPaymentProcessed) {
//            log.info("Payment processed successfully for userId: {}", paymentDetails.getUserId());
//        }
//    }
//}
