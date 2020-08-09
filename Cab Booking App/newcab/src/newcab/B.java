package newcab;


import java.io.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

class City implements Serializable{
	
	int n;
	int[][] isConnected;
	int[][] distance;
	
	/*City() {
		
		for(int i = 0; i < n; i++) {
			
			for(int j = 0; j < n; j++) {
				
				isConnected[i][j] = 0;
				
			}
			
		}
		
		for(int i = 0; i < n; i++) {
			
			for(int j = 0; j < n; j++) {
				
				distance[i][j] = -1;
				
			}
			
		}
		
	}*/
	
	void createCity() {
		
		//int n;
		String buffer;
		char bufferChar;
		
		Scanner in = new Scanner(System.in);
		
		int a, b, d;
		
		n = in.nextInt();
		
		isConnected = new int[n][n];
		
		distance = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			
			for(int j = 0; j < n; j++) {
				
				isConnected[i][j] = 0;
				
			}
			
		}
		
		for(int i = 0; i < n; i++) {
			
			for(int j = 0; j < n; j++) {
				
				distance[i][j] = -1;
				
			}
			
		}
		
		int q;
		
		q = in.nextInt();
		
		for(int i = 0; i < q; i++) {
			
			a = in.nextInt();
			
			b = in.nextInt();
			
			d = in.nextInt();
			
			isConnected[a][b] = 1;
			
			if(isConnected[a][b] == 1){
				
				isConnected[b][a] = 1;
				
			}
			
			distance [a][b] = distance[b][a] = d;
			
		}
		
		for(int i = 0 ; i < n ; i++) {
			
			for(int j = 0; j < n; j++) {
				
				System.out.println("isConnected[" + i + "][" + j + "] = " + isConnected[i][j]);
				
				if(distance[i][j] != -1) {
					
					System.out.println("distance = " + distance[i][j]);
					
				}
				
			}
			
		}
		
		in.close();
		
	}
	
	public String toString() {
		
		String temp = "";
		
		for(int i = 0 ; i < n ; i++) {
			
			for(int j = 0; j < n; j++) {
				
				temp = temp + "isConnected[" + i + "][" + j + "] = " + isConnected[i][j] + "\n";
				
				if(distance[i][j] != -1) {
					
					temp = temp + "distance = " + distance[i][j] + "\n";
					
				}
				
			}
			
		}
		
		return temp;
		
	}
	
	void dijkstra(int[] unvisited, int[] tent_dist, int init_node) {
		
		for(int i = 0; i < n; i++) {
			
			if(unvisited[i] == 1 && i != init_node && distance[init_node][i] != -1) {
				
				if(tent_dist[i] > (tent_dist[init_node] + distance[init_node][i])) {
					
					tent_dist[i] = tent_dist[init_node] + distance[init_node][i];
					
				}
				
			}
			
		}
		
		unvisited[init_node] = 0;
		
		int shortest = Integer.MAX_VALUE;
		
		int next_index = init_node;
		
		for(int i = 0; i < n; i++) {
			
			if(tent_dist[i] < shortest && tent_dist[i] != 0 && unvisited[i] == 1) {
				
				shortest = tent_dist[i];
				
				next_index = i;
				
			}
			
		}
		
		int counter = 0;
		
		for(int i = 0; i < n; i++) {
			
			if(unvisited[i] == 1 && tent_dist[i] < Integer.MAX_VALUE) {
				
				counter++;
				
			}
			
		}
		
		if(next_index != init_node && counter > 0) {
			
			dijkstra(unvisited, tent_dist, next_index);
			
		}
		
	}
	
	void sortIndices(int n, int[] ascending, int[] ascend) {
		
		for(int i = 0; i < n; i++) {
			
			for(int j = i + 1; j < n; j++) {
				
				if(ascend[i] > ascend[j]) {
					
					int temp = ascending[i];
					ascending[i] = ascending[j];
					ascending[j] = temp;
					
					temp = ascend[i];
					ascend[i] = ascend[j];
					ascend[j] = temp;
					
				}
				
			}
			
		}
		
	}
        
}


class Customers implements Serializable{
	
	List<String> userID = new ArrayList<String>();
	
	List<String> password = new ArrayList<String>();
	
	List<Integer> location = new ArrayList<Integer>();
	
	List<Integer> isAvailable = new ArrayList<Integer>();
	
	List<Integer> wallet = new ArrayList<Integer>();
        
        List<String> contact_number = new ArrayList<String>();
        
        List<String> emailID = new ArrayList<String>();
        
        String current_user;
        
	void addUser(String ID, String pass, int money, String contactnumber, String email_ID) {
		
		int valid = 1;
		
		for(int i = 0; i < userID.size(); i++) {
			
			if(userID.get(i) == ID) {
				
				valid = 0;
				
			}
			
		}
		
		if(valid == 1) {
			
			userID.add(ID);
			
			password.add(pass);
			
			isAvailable.add(1);
			
			wallet.add(money);
                        
                        contact_number.add(contactnumber);
                        
                        emailID.add(email_ID);
			
		}
		
		else {
			
			System.out.println("userID already exists.");
			
		}
		
		try {
			
			FileOutputStream f = new FileOutputStream(new File("Customers.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);
		
			o.writeObject(this);
		
			o.close();
			f.close();
		
		}
	
		catch(Exception e) {
		
			System.out.println(e.getStackTrace());
		
		}
		
	}
	
	public String toString() {
		
		int n = userID.size();
		
		String out = "";
		
		for(int i = 0; i < n; i++) {
			
			out = out + userID.get(i) + " " + password.get(i) + " " + contact_number.get(i) + " " + emailID.get(i) + " " + isAvailable.get(i) + "\n";
			
		}
		
		return out;
		
	}
	
	void deleteUser(int i) {
		
		userID.remove(i);
		
		password.remove(i);
		
		//location.remove(i);
                contact_number.remove(i);
                
                emailID.remove(i);
		
		isAvailable.remove(i);
		
		try {
			
			FileOutputStream f = new FileOutputStream(new File("Customers.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);
		
			o.writeObject(this);
		
			o.close();
			f.close();
		
		}
	
		catch(Exception e) {
		
			System.out.println(e.getStackTrace());
		
		}
		
	}

}

class Drivers implements Serializable{
	
	List<Integer> driverID = new ArrayList<Integer>();
	
	List<Double> rating = new ArrayList<Double>();
	
	List<Integer> location = new ArrayList<Integer>();
	
	List<Integer> isAvailable = new ArrayList<Integer>();
        
        List<String> name = new ArrayList<String>();
        
        List<String> contact_no = new ArrayList<String>();
	
	void addDriver(int ID, double rate, int place, String naam, String phone) {
		
		int valid = 1;
		
		for(int i = 0; i < driverID.size(); i++) {
			
			if(driverID.get(i) == ID) {
				
				valid = 0;
				
			}
			
		}
		
		if(valid == 1) {
			
			driverID.add(ID);
			
			rating.add(rate);
			
			location.add(place);
			
			isAvailable.add(1);
                        
                        name.add(naam);
                        
                        contact_no.add(phone);
			
		}
		
		else {
			
			System.out.println("Driver already exists in database");
			
		}
		
		try {
			
			FileOutputStream f = new FileOutputStream(new File("Drivers.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);
		
			o.writeObject(this);
		
			o.close();
			f.close();
		
		}
	
		catch(Exception e) {
		
			System.out.println(e.getStackTrace());
		
		}
		
	}
	
	public String toString() {
		
		int n = driverID.size();
		
		String out = "";
		
		for(int i = 0; i < n; i++) {
			
			out = out + driverID.get(i) + " " + rating.get(i) + " " + location.get(i) + " " + isAvailable.get(i) + " " + name.get(i) + " " + contact_no.get(i) + "\n";
			
		}
		
		return out;
		
	}
	
	void deleteDriver(int i) {
		
		driverID.remove(i);
		
		rating.remove(i);
		
		location.remove(i);
		
		isAvailable.remove(i);
                
                name.remove(i);
                
                contact_no.remove(i);
		
		try {
			
			FileOutputStream f = new FileOutputStream(new File("Drivers.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);
		
			o.writeObject(this);
		
			o.close();
			f.close();
		
		}
	
		catch(Exception e) {
		
			System.out.println(e.getStackTrace());
		
		}
		
	}
	
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thanooja Reddy
 */
public class B extends javax.swing.JFrame {
    
    Drivers driver = new Drivers();
    
    City city = new City();

    /**
     * Creates new form B
     */
    public B() {
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

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField_userid = new javax.swing.JTextField();
        jTextField_contact = new javax.swing.JTextField();
        jTextField_email = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPasswordField_password = new javax.swing.JPasswordField();
        jPasswordField_confpass = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jTextField_wallet = new javax.swing.JTextField();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("USER ID");

        jLabel2.setText("PASSCODE");

        jLabel3.setText("CONTACT NO");

        jLabel4.setText("EMAIL ID");

        jTextField_contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_contactActionPerformed(evt);
            }
        });

        jTextField_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_emailActionPerformed(evt);
            }
        });

        jButton2.setText("SIGN UP");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Confirm Password");

        jLabel7.setText("WALLET AMOUNT");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(156, 156, 156))
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_contact, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(jTextField_email))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(51, 51, 51)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_wallet, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField_userid)
                    .addComponent(jPasswordField_password, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPasswordField_confpass, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField_userid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordField_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField_confpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField_wallet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*public boolean checkUserId(String userid)
    {
        PreparedStatement ps;
        ResultSet rs;
        boolean checkUser = false;
        String query = "SELECT * FROM `users` WHERE `user_id` =?";
        
        try {
            ps = Database_Connector.getConnection().prepareStatement(query);
            ps.setString(1, userid);
            
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                checkUser = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(B.class.getName()).log(Level.SEVERE, null, ex);
        }
         return checkUser;
    }*/
    
    Customers user=new Customers();
    
               
    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        String userID=jTextField_userid.getText();
        String passcode=String.valueOf(jPasswordField_password.getPassword());
        String conf_pass = String.valueOf(jPasswordField_confpass.getPassword());
        String walletstr = jTextField_wallet.getText();
        String contact_number=jTextField_contact.getText();
        String emailID=jTextField_email.getText();
        
        int wallet_amount = Integer.parseInt(walletstr);
        
        
        
        
        if(userID.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Add A Username");
        }
        
        else if(passcode.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Add A Password");
        }
        else if(!passcode.equals(conf_pass))
        {
            JOptionPane.showMessageDialog(null, "Retype The Password Again");
        }
        
        else if(contact_number.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Add a contact number");
        }
        
        else if(emailID.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Add an email ID");
        }
        else{
            
             try {
			
			FileInputStream fi = new FileInputStream(new File("Customers.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);
			
			user = (Customers) oi.readObject();
			
			oi.close();
			fi.close();
			
		}
		
		catch(Exception e) {
			
			System.out.println(e.getStackTrace());
			
		}
            
             user.addUser(userID,passcode,wallet_amount,contact_number,emailID);
             new C().setVisible(true);
             this.setVisible(false);
            
            
        }
        
        System.out.println(user.toString());
       
        
        //we should allow a user to register with existing idokay
        /*else if(checkUserId(userID))
        {
            JOptionPane.showMessageDialog(null, "This Username Already Exist");
        }
        
        else{
            PreparedStatement ps;
        String query = "INSERT INTO `users`(`user_id`, `password`, `email`, `phone_number`) VALUES (?,?,?,?)";
        
        try {
            ps = Database_Connector.getConnection().prepareStatement(query);
            
            ps.setString(1, userID);
            ps.setString(2, passcode);
            ps.setString(3, emailID);
            ps.setString(4, contact_number);
                
            if(ps.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "New User Add");
                C rf = new C();
                rf.setVisible(true);
                rf.pack();
                rf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.dispose();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(B.class.getName()).log(Level.SEVERE, null, ex);
        }
        }*/
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_emailActionPerformed

    private void jTextField_contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_contactActionPerformed

    /**
     * @param args the command line arguments
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
            java.util.logging.Logger.getLogger(B.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(B.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(B.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(B.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new B().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField jPasswordField_confpass;
    private javax.swing.JPasswordField jPasswordField_password;
    private javax.swing.JTextField jTextField_contact;
    private javax.swing.JTextField jTextField_email;
    private javax.swing.JTextField jTextField_userid;
    private javax.swing.JTextField jTextField_wallet;
    // End of variables declaration//GEN-END:variables

    private void JOptionPaneMessageDialog(B aThis, String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
