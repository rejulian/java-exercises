package com.amigoscode._3_oop._4_polymorphism.bank;

import java.util.List;

/**
 * Exercise: Polymorphism - Payment Processing
 *
 * Build a payment processing system using interfaces and polymorphism.
 * Multiple payment methods implement the same interface, allowing
 * the processor to handle any payment type without knowing the details.
 *
 * Key concepts:
 * - Defining interfaces
 * - Multiple classes implementing the same interface
 * - Runtime polymorphism (method dispatch)
 * - Programming to an interface, not an implementation
 * - Default methods in interfaces
 */

// TODO: 5 - Create a PaymentProcessor class with a method:
//   void processAllPayments(List<Payment> payments, double amount)
//   Iterate over the list and call processPayment(amount) on each.
//   After each payment, call printReceipt(amount).
class PaymentProcessor {
    public void processAllPayments(List<Payment> payments, double amount) {
        for(Payment payment: payments) {
            payment.processPayment(amount);
            payment.printReceipt(amount);
        }
    }
}



class PaymentDemo {
    public static void main(String[] args) {
        // TODO: 6 - Create a List<Payment> containing one of each payment type:
        //   CreditCardPayment, PayPalPayment, BankTransferPayment.
        //   Then create a PaymentProcessor and call processAllPayments().
        Payment creditCardPayment = new CreditCardPayment("4242 4242 4242 4242");
        Payment payPalPayment = new PayPalPayment("julian.re.dev@gmail.com");
        Payment bankTransferPayment = new BankTransferPayment("00009999124153");
        List<Payment> payments = List.of(creditCardPayment, payPalPayment, bankTransferPayment);

        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.processAllPayments(payments, 80.0);

    }
}
