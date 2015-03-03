package discountstrategy;

import javax.swing.JOptionPane;

/**
 * 
 * @author Dan
 */
public class Startup {
    
    
    public static void main(String[] args) {
        try {
        CashRegister sale = new CashRegister(new FakeDatabase());
        
        sale.startNewSale("00000001");
        sale.addLineItem("878841132", 3);  
        sale.addLineItem("008498255", 1);
        sale.completeSale();

        sale.startNewSale("00000002");
        sale.addLineItem("133562060", 1);
        sale.addLineItem("009270653", 4);
        sale.addLineItem("008498255", 1);
        sale.completeSale();
        
        } catch (IllegalArgumentException e) {
        
        JOptionPane.showMessageDialog(null, e);
    }
    }
}
