/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesjava.parcelas;

import entities.Contract;
import entities.Installment;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import services.ContractService;
import services.OnlinePaymentService;
import services.PayPalService;

/**
 *
 * @author Lucas Murilo
 */
public class InterfacesJavaParcelas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Informe os dados do contrato: ");
        System.out.print("Numero do contrato");
        int numContrato = teclado.nextInt();
        System.out.print("Data do contrato: ");
        Date data = sdf.parse(teclado.next());
        System.out.print("Valor do contrato: ");
        double valor = teclado.nextDouble();
        Contract contract = new Contract(numContrato, data, valor);
        System.out.println("Informe a quantidade de parcelas: ");
        int quantidadeParcelas = teclado.nextInt();
        
        ContractService cs = new ContractService(new PayPalService());
        
        cs.processContract(contract, quantidadeParcelas);
        
        System.out.println("Parcelas");
        for(Installment it: contract.getInstallments()){
            System.out.println(it);
        }
        
       
        
        
        
    }
    
}
