/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shdrealestate;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author bchar
 */
public class Property2 extends javax.swing.JFrame {

    Connection conn=null;
    ResultSet rs =null;
    PreparedStatement pst=null;
    /**
     * Creates new form Property2
     */
    public Property2() {
        initComponents();
        txtPropNum.setEnabled(false);
        Fill_StateCbo();
        Fill_TenantCbo();
        show_properties();
    }

    public void CmdEnter() {
        txtPropNum.setText(" ");
        txtAddr.setText(" ");
        txtZip.setText(" ");
        txtCity.setText(" ");
        //cboState.setText(" ");"
        cboState.setSelectedItem(0);
        txtPhone.setText(" ");
        txtBeds.setText(" ");
        txtBaths.setText(" ");
        chkWash.setSelected(false);
        chkDryr.setSelected(false);
        chkDeckPat.setSelected(false);
        chkBase.setSelected(false);
        //txtTenant.setText(" ");
        txtTotalTens.setText(" ");
    } 
                                                  
    public ArrayList<Prop> propertyList(){
        ArrayList<Prop> propList = new ArrayList<>();
        try {
             Class.forName("com.mysql.jdbc.Driver");
             String url = "jdbc:mysql://localhost:3306/mysql, root, passw";
             Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shd", "root", "passw"); 
             String sql = "Select * from shd.property";
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql);
             Prop prop;
             while(rs.next())
             {
                prop=new Prop(rs.getInt("propertyID"), rs.getString("streetAddress") ,rs.getString("city") ,rs.getString("state") ,rs.getString("zipCode") ,rs.getString("phoneNumber") ,rs.getString("numOfRooms") ,rs.getString("numberOfBaths") ,rs.getString("Tennant_ssn"), rs.getString("numOfTennants"), rs.getBoolean("washer"), rs.getBoolean("dryer"), rs.getBoolean("deckOrPatio"), rs.getBoolean("basement"));
                propList.add(prop);
                
             }  
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
         return propList;
        
    }
    
    public void show_properties() {
        ArrayList<Prop> list = propertyList();
        DefaultTableModel model = (DefaultTableModel)tblProp.getModel();
        Object[] row = new Object[14];
        for (int i=0;i<list.size();i++){
            row[0]=list.get(i).getpropertyID();
            row[1]=list.get(i).getstreetAddress();
            row[2]=list.get(i).getCity();
            row[3]=list.get(i).getState();
            row[4]=list.get(i).getZipCode();
            row[5]=list.get(i).getPhoneNumber();
            row[6]=list.get(i).getNumOfRooms();
            row[7]=list.get(i).getNumberOfBaths();
            row[8]=list.get(i).getWasher();
            row[9]=list.get(i).getDryer();
            row[10]=list.get(i).getDeckOrPatio();
            row[11]=list.get(i).getBasement();
            row[12]=list.get(i).getTennant_ssn();
            row[13]=list.get(i).getNoOfTennants();
            model.addRow(row);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblPropNum = new javax.swing.JLabel();
        lblAddr = new javax.swing.JLabel();
        lblCity = new javax.swing.JLabel();
        lblState = new javax.swing.JLabel();
        lblZip = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPropNum = new javax.swing.JTextField();
        txtAddr = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();
        cboState = new javax.swing.JComboBox<>();
        txtZip = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProp = new javax.swing.JTable();
        btnUpdate = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnDele = new javax.swing.JButton();
        chkWash = new javax.swing.JCheckBox();
        chkDryr = new javax.swing.JCheckBox();
        chkDeckPat = new javax.swing.JCheckBox();
        chkBase = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        txtBeds = new javax.swing.JTextField();
        txtBaths = new javax.swing.JTextField();
        lblTenant = new javax.swing.JLabel();
        lblTotalTens = new javax.swing.JLabel();
        txtTotalTens = new javax.swing.JTextField();
        chkBase1 = new javax.swing.JCheckBox();
        cboTenant = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        lblPropNum.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPropNum.setText("Property# : ");

        lblAddr.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblAddr.setText("Address : ");

        lblCity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCity.setText("City : ");

        lblState.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblState.setText("State :");

        lblZip.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblZip.setText("Zip :");

        lblPhone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPhone.setText("Contact# :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Bedrooms: ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Bathrooms :");

        txtPropNum.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPropNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPropNumActionPerformed(evt);
            }
        });

        txtAddr.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtCity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        cboState.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtZip.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtPhone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tblProp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblProp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Property#", "Address", "City", "State", "Zip", "Contact#", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13", "Title 14"
            }
        ));
        tblProp.setGridColor(new java.awt.Color(204, 204, 204));
        tblProp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPropMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProp);

        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnInsert.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Insert");

        btnDele.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDele.setText("Delete");

        chkWash.setBackground(new java.awt.Color(204, 204, 204));
        chkWash.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chkWash.setText("Washer");

        chkDryr.setBackground(new java.awt.Color(204, 204, 204));
        chkDryr.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chkDryr.setText("Dryer");

        chkDeckPat.setBackground(new java.awt.Color(204, 204, 204));
        chkDeckPat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chkDeckPat.setText("Deck/Patio");

        chkBase.setBackground(new java.awt.Color(204, 204, 204));
        chkBase.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chkBase.setText("Basement");

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Demi", 2, 14)); // NOI18N
        jLabel1.setText("features:");

        txtBeds.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtBaths.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblTenant.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTenant.setText("Tenant#");

        lblTotalTens.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTotalTens.setText("Total Tenants: ");

        txtTotalTens.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        chkBase1.setBackground(new java.awt.Color(204, 204, 204));
        chkBase1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chkBase1.setText("Off Street Parking");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDele, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblPropNum)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPropNum, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblAddr)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtAddr, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblCity)
                                            .addComponent(lblPhone)
                                            .addComponent(lblState)
                                            .addComponent(lblZip)
                                            .addComponent(lblTenant))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cboState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtZip, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cboTenant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8))
                                        .addGap(15, 15, 15)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtBeds, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtBaths, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(35, 35, 35)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(chkWash)
                                            .addComponent(chkDryr)
                                            .addComponent(chkDeckPat)
                                            .addComponent(chkBase)
                                            .addComponent(chkBase1))))))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblTotalTens)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalTens, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1001, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 518, Short.MAX_VALUE)
                    .addComponent(jButton3)
                    .addGap(0, 519, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblPropNum)
                                    .addComponent(txtPropNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblAddr)
                                    .addComponent(txtAddr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCity)
                                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblState)
                                    .addComponent(cboState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblZip)
                                    .addComponent(txtZip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(lblPhone))
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTenant)
                            .addComponent(cboTenant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotalTens)
                            .addComponent(txtTotalTens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(chkWash)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chkDryr)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkDeckPat))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(txtBeds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(txtBaths, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkBase)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkBase1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDele, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(576, Short.MAX_VALUE)
                    .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(43, 43, 43)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 317, Short.MAX_VALUE)
                    .addComponent(jButton3)
                    .addGap(0, 318, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPropNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPropNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPropNumActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // Add new property records
        try{
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/mysql, root, passw";
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shd", "root", "passw"); 
                String sql = "Insert into shd.property (streetAddress,city,state,zipCode,phoneNumber,numOfRooms,numberOfBaths,washer,dryer,deckOrPatio,basement,tennant_ssn,numOfTennants) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement pst = conn.prepareStatement(sql);
                
                pst.setString (1, txtAddr.getText());
                pst.setString (2, txtCity.getText());
                
                String cboStateValue = cboState.getSelectedItem().toString();
                pst.setString (3, cboStateValue);
                
                pst.setString (4, txtZip.getText());
                pst.setString (5, txtPhone.getText());
                pst.setString (6, txtBeds.getText());
                pst.setString (7, txtBaths.getText());
                
                boolean chkWashValue = chkWash.isSelected();
                pst.setBoolean (8, chkWashValue);

                boolean chkDryValue = chkDryr.isSelected();
                pst.setBoolean (9, chkDryValue);
                
                boolean chkDeckPatValue = chkDeckPat.isSelected();
                pst.setBoolean (10, chkDeckPatValue);

                boolean chkBaseValue = chkBase.isSelected();
                pst.setBoolean (11, chkBaseValue);
         
               // pst.setString (12, txtTenant.getText());
                pst.setString (12, txtTotalTens.getText());
        
                pst.execute();
         
                
                JOptionPane.showMessageDialog(null, "Entry Saved");
               
                CmdEnter();
            }
            
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            show_properties();
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void tblPropMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPropMouseClicked
        int i = tblProp.getSelectedRow();
        TableModel model = tblProp.getModel();
        txtPropNum.setText(model.getValueAt(i, 0).toString());
        txtAddr.setText(model.getValueAt(i, 1).toString());
        txtCity.setText(model.getValueAt(i, 2).toString());
        cboState.setSelectedItem(model.getValueAt(i, 3).toString());
        txtZip.setText(model.getValueAt(i, 4).toString());
        txtPhone.setText(model.getValueAt(i, 5).toString());
        txtBeds.setText(model.getValueAt(i, 6).toString());
        txtBaths.setText(model.getValueAt(i, 7).toString());
        //chkWash.setText(model.getValueAt(i, 8).toString());
        String chkWashVal = model.getValueAt(i, 8).toString();
            if(chkWashVal.equals("true")) {
                chkWash.setSelected(true);
            }
            else {
                chkWash.setSelected(false); 
            }
        String chkDryrVal = model.getValueAt(i, 9).toString();
            if(chkDryrVal.equals("true")) {
                chkDryr.setSelected(true);
            }  
            else {
                chkDryr.setSelected(false); 
            }
        String chkDeckPatVal = model.getValueAt(i, 10).toString();
            if(chkDeckPatVal.equals("true")) {
                chkDeckPat.setSelected(true);
            }
            else {
                chkDeckPat.setSelected(false); 
            }
        String chkBaseVal = model.getValueAt(i, 11).toString();
            if(chkBaseVal.equals("true")) {
                chkBase.setSelected(true);
            }
            else {
                chkBase.setSelected(false); 
            }
        txtTotalTens.setText(model.getValueAt(i, 12).toString());
        //txtTenant.setText(model.getValueAt(i, 13).toString());
    }//GEN-LAST:event_tblPropMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // Update existing property records
        try{
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/mysql, root, passw";
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shd", "root", "passw"); 
                int row = tblProp.getSelectedRow();
                String value = (tblProp.getModel().getValueAt(row, 0).toString());
                String sql = "UPDATE shd.property SET deckOrPatio=?,washer=?,dryer=?,numberOfBaths=?,phoneNumber=?,basement=?,numOfRooms=?,zipCode=?,streetAddress=?,city=?,state=?,numOfTennants=?,Tennant_ssn=? where propertyID="+value;
                PreparedStatement pst = conn.prepareStatement(sql);
                
                boolean chkDeckPatValue = chkDeckPat.isSelected();
                pst.setBoolean (1, chkDeckPatValue);
                
                boolean chkWashValue = chkWash.isSelected();
                pst.setBoolean (2, chkWashValue);
                
                boolean chkDryValue = chkDryr.isSelected();
                pst.setBoolean (3, chkDryValue);
                
                pst.setString (4, txtBaths.getText());
                
                pst.setString (5, txtPhone.getText());
                
                boolean chkBaseValue = chkBase.isSelected();
                pst.setBoolean (6, chkBaseValue);
                
                pst.setString (7, txtBeds.getText());

                pst.setString (8, txtZip.getText());
                
                pst.setString (9, txtAddr.getText());
                pst.setString (10, txtCity.getText());
                
                String cboStateValue = cboState.getSelectedItem().toString();
                pst.setString (11, cboStateValue);
                
                pst.setString (12, txtTotalTens.getText()); 

               // pst.setString (13, txtTenant.getText());
                
         
                pst.execute();
         
                DefaultTableModel model = (DefaultTableModel)tblProp.getModel();
                model.setRowCount(0);
                CmdEnter();
                
                JOptionPane.showMessageDialog(null, "Record successfully updated");
               
                show_properties();
            }
            
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            show_properties();
        }    
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void Fill_StateCbo() {
        try {
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shd", "root", "passw"); // Please use your database name here
            String sql="select * from shd.state";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst=conn.prepareStatement(sql);
             rs=pst.executeQuery();
            while(rs.next())
            {
                String name = rs.getString("state_abbr");
                cboState.addItem(name);
                
            }   

        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
     private void Fill_TenantCbo() {
        try {
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shd", "root", "passw"); // Please use your database name here
            String sql="select * from shd.tennant";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst=conn.prepareStatement(sql);
             rs=pst.executeQuery();
            while(rs.next())
            {
                String name = rs.getString("ssn");
                cboTenant.addItem(name);
                
            }   

        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
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
            java.util.logging.Logger.getLogger(Property2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Property2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Property2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Property2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Property2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDele;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboState;
    private javax.swing.JComboBox<String> cboTenant;
    private javax.swing.JCheckBox chkBase;
    private javax.swing.JCheckBox chkBase1;
    private javax.swing.JCheckBox chkDeckPat;
    private javax.swing.JCheckBox chkDryr;
    private javax.swing.JCheckBox chkWash;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAddr;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblPropNum;
    private javax.swing.JLabel lblState;
    private javax.swing.JLabel lblTenant;
    private javax.swing.JLabel lblTotalTens;
    private javax.swing.JLabel lblZip;
    private javax.swing.JTable tblProp;
    private javax.swing.JTextField txtAddr;
    private javax.swing.JTextField txtBaths;
    private javax.swing.JTextField txtBeds;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtPropNum;
    private javax.swing.JTextField txtTotalTens;
    private javax.swing.JTextField txtZip;
    // End of variables declaration//GEN-END:variables

}