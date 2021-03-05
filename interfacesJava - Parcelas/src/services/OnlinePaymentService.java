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
public interface OnlinePaymentService {
    
    double paymentFee(Double amount);
    double interest(double amount, int month);
    
}
