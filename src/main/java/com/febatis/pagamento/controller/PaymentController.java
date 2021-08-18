package com.febatis.pagamento.controller;

import com.febatis.pagamento.model.Payment;
import com.febatis.pagamento.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static net.logstash.logback.argument.StructuredArguments.value;

@Controller
@RequestMapping("pay")
public class PaymentController {

    private static final Logger logger
            = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    PaymentService paymentService;


    @GetMapping("/search-faq")
    @ResponseBody
    public void searchFaq(@RequestParam String search) {
        logger.info("search: {}", value("search", search));
    }

    @GetMapping("/find-all")
    @ResponseBody
    public List<Payment> findAll() {
        return paymentService.findAll();
    }

    @PostMapping("/do-payment")
    @ResponseBody
    public Payment doPayment(@RequestBody Payment payment) {
        logger.info("Payment Type: {}", value("PaymentType", payment.getPaymentType()));
        return paymentService.doPayment(payment);
    }

}
