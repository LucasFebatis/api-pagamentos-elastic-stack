package com.febatis.pagamento.model;

import com.febatis.pagamento.enums.PaymentType;

import javax.persistence.*;

@Entity
@Table(name = "Payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "PAYMENT_TYPE", nullable = false)
    private PaymentType paymentType;

    @Column(name = "VALUE", nullable = false)
    private double value;

    public Payment() {
    }

    public Payment(String description, PaymentType paymentType, double value) {
        this.description = description;
        this.paymentType = paymentType;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
