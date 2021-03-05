/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author Lucas Murilo
 */
public class PayPalService implements OnlinePaymentService{
    
    private static final double PAYMENT_FEE = 0.02;
    private static final double MONTHY_INTEREST = 0.01;
    
    @Override
    public double paymentFee(Double amount) {
        return amount * PAYMENT_FEE;
        
    }

    @Override
    public double interest(double amount, int month) {
        return amount * month * MONTHY_INTEREST;
    }
    
}
