/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Contract;
import entities.Installment;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Lucas Murilo
 */
public class ContractService {
    
    private OnlinePaymentService onlinePaymentService;
    
    public ContractService(OnlinePaymentService onlinePaymentService){
        this.onlinePaymentService = onlinePaymentService;
        
    }
    
    public void processContract(Contract contract, int months){
        double basicQuota = contract.getTotalValue() / months;
        for(int i = 1; i < months; i++){
            double updatedQuota = basicQuota + onlinePaymentService.interest(basicQuota, i);
            double fullQuota = updatedQuota + onlinePaymentService.paymentFee(updatedQuota);
            Date dueDate = addMonths(contract.getDate(), i);
            contract.getInstallments().add(new Installment(dueDate, fullQuota));
            
        }
        
    }
   //acrescentando meses na data
    private Date addMonths(Date date, int N){
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, N);
        return calendar.getTime();
        
    }
    
}
