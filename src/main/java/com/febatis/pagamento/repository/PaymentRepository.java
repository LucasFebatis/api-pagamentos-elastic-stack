package com.febatis.pagamento.repository;

import com.febatis.pagamento.model.Payment;
import com.febatis.pagamento.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
