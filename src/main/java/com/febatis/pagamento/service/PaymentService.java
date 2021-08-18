package com.febatis.pagamento.service;

import com.febatis.pagamento.model.Payment;
import com.febatis.pagamento.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class PaymentService {

    private static final Logger LOGGER = Logger.getLogger(PaymentService.class.getName());

    @Autowired
    private PaymentRepository repository;

    public List<Payment> findAll() {
        LOGGER.log(Level.INFO, "FindAll");
        List<Payment> all = repository.findAll();
        all.forEach(it -> LOGGER.log(Level.INFO, it.toString()));
        return all;
    }

    public Payment doPayment(Payment payment) {
        LOGGER.log(Level.INFO, "doPayment");
        return repository.save(payment);
    }
}
