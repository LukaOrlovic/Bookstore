package niti;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author orlov
 */
public class NitSat extends Thread{
    JLabel lblSat;

    public NitSat(JLabel lblSat) {
        this.lblSat = lblSat;
    }

    @Override
    public void run() {
         
        Date date;
        SimpleDateFormat sdf= new SimpleDateFormat("hh:mm:ss");
        while(true){
            date= new Date();
            
            lblSat.setText(sdf.format(date));
        }
        
        
    }
    
    
}
