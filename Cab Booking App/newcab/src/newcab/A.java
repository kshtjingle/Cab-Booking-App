package newcab;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thanooja Reddy
 */
public class A extends javax.swing.JFrame {

    static Drivers driver = new Drivers();
    
    /**
     * Creates new form A
     */
    public A() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("NEW USER");

        jLabel2.setText("EXISTING USER");

        jButton1.setText("SIGN IN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("LOG IN");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 2, 24)); // NOI18N
        jLabel3.setText("WELCOME TO BITS CABS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel3)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         
         
         
        
        new B().setVisible(true);
         this.setVisible(false);
         // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         
          
          
        
         new C().setVisible(true);
          this.setVisible(false);
          
   // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args mand line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(A.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(A.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(A.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(A.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
       /* try {
			
			FileInputStream fi = new FileInputStream(new File("Drivers.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);
			
			driver = (Drivers) oi.readObject();
			
			oi.close();
			fi.close();
			
		}
		
		catch(Exception e) {
			
			System.out.println(e.getStackTrace());
			
		}
        
        System.out.println(driver.toString());

        Scanner in = new Scanner(System.in);
        
        char y = in.next().charAt(0);
        
        String buffer = in.nextLine();
        
        if(y == 'L' || y == 'l'){
            
            City city = new City();
        
        city.createCity();
        
        try {
			
			FileOutputStream f = new FileOutputStream(new File("City.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);
		
			o.writeObject(city);
		
			o.close();
			f.close();
		
		}
	
		catch(Exception e) {
		
			System.out.println(e.getStackTrace());
		
		}
            
        }
        
        else if(y == 'D' || y == 'd'){
            
            int id = in.nextInt();
            
            double rating = in.nextDouble();
            
            int place = in.nextInt();
            
            String buffer1 = in.nextLine();
            
            String name = in.nextLine();
            
            String phone = in.nextLine();
            
           
            
            driver.addDriver(id, rating, place, name, phone);
            
            try {
		
			FileOutputStream f = new FileOutputStream(new File("Drivers.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);
		
			o.writeObject(driver);
		
			o.close();
			f.close();
		
		}
	
		catch(Exception e) {
		
			System.out.println(e.getStackTrace());
		
		}

            
        }
        
        else if(y == 'r' || y == 'R'){
            
            int index = in.nextInt();
            
            driver.deleteDriver(index);
            
        }*/
        
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new A().setVisible(true);
            }
        });
        
        Timer t = new Timer();
        
        t.scheduleAtFixedRate(new TimerTask(){
            
            @Override
            public void run(){
                
                
                
                City city = new City();
                
                try {
			
			FileInputStream fi = new FileInputStream(new File("Drivers.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);
			
			driver = (Drivers) oi.readObject();
			
			oi.close();
			fi.close();
			
		}
		
		catch(Exception e) {
			
			System.out.println(e.getStackTrace());
			
		}
                
                try {
			
			FileInputStream fi = new FileInputStream(new File("City.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);
			
			city = (City) oi.readObject();
			
			oi.close();
			fi.close();
			
		}
		
		catch(Exception e) {
			
			System.out.println(e.getStackTrace());
			
		}
                
                Random r = new Random();
                
                int no = r.nextInt(10);
                
                for(int i = 0; i < no; i++){
                    
                    int rd = r.nextInt(10);
                    
                    if(driver.isAvailable.get(rd) == 1){
                        
                        int random = r.nextInt(8);
                        
                        int randi = r.nextInt(8);
                        
                        if(city.distance[driver.location.get(rd)][randi] != -1){
                            
                            driver.isAvailable.set(rd, 0);
                            
                            Timer ti = new Timer();
                            
                            ti.schedule(new TimerTask(){
                                
                                @Override
                                public void run(){
                                    
                                    driver.isAvailable.set(rd, 1);
                                    
                                    driver.location.set(rd, randi);
                                    
                                }
                                
                            }, 2 * city.distance[driver.location.get(rd)][randi]);
                            
                        }
                        
                    }
                    
                }
                
            }
            
        }, 0, 100000);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
