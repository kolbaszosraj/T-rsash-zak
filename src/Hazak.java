
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Balog Zsolt
 */
public class Hazak extends javax.swing.JDialog {

    private DbConnection dbConnection = null;
    public static DefaultTableModel tm1;

    public Hazak(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        dbConnection = DbConnection.getInstance();
        Show_UsersList_In_JTable();
        dbConnection.Fillcombo();
    }

    public void Show_UsersList_In_JTable() {

        ArrayList<DbConnection.User> list = dbConnection.getUsersList();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[7];
        model.setRowCount(0);
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).Kerulet();
            row[2] = list.get(i).Varos();
            row[3] = list.get(i).Haz();
            row[4] = list.get(i).Utca();
            row[5] = list.get(i).Hazszam();
            row[6] = list.get(i).Nev();
            model.addRow(row);
        }
        
        

    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hazhozz = new javax.swing.JButton();
        Jkerulet = new javax.swing.JTextField();
        Jvaros = new javax.swing.JTextField();
        Jhaz = new javax.swing.JTextField();
        Jutca = new javax.swing.JTextField();
        Jhazszam = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        JTazonosit = new javax.swing.JTextField();
        JLAzonosit = new javax.swing.JLabel();
        JBmodosit = new javax.swing.JButton();
        JBHaztorles = new javax.swing.JButton();
        Combobox = new javax.swing.JComboBox<>();
        JLAzonosit2 = new javax.swing.JLabel();
        TK_ID = new javax.swing.JTextField();
        JLAzonosit3 = new javax.swing.JLabel();
        JBHaztorles1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lakások kezelése");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        hazhozz.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        hazhozz.setText("Ház hozzáadása");
        hazhozz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hazhozzActionPerformed(evt);
            }
        });

        Jkerulet.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Jvaros.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Jhaz.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Jutca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Jhazszam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Kerület:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Város:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ház:");

        JLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabel.setText("Utca:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Házszám:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Kerület", "Város", "Ház", "Utca", "Házszám", "Házkezelő neve"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        JTazonosit.setEditable(false);
        JTazonosit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTazonosit.setFocusable(false);

        JLAzonosit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JLAzonosit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLAzonosit.setText("ID:");

        JBmodosit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JBmodosit.setText("Módositás");
        JBmodosit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBmodositActionPerformed(evt);
            }
        });

        JBHaztorles.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JBHaztorles.setText("Ház Törlése");
        JBHaztorles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBHaztorlesActionPerformed(evt);
            }
        });

        Combobox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboboxMouseClicked(evt);
            }
        });
        Combobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboboxActionPerformed(evt);
            }
        });

        JLAzonosit2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JLAzonosit2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLAzonosit2.setText("TK_ID:");

        TK_ID.setEditable(false);
        TK_ID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        JLAzonosit3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JLAzonosit3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLAzonosit3.setText("Házkezelő neve:");

        JBHaztorles1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JBHaztorles1.setText("Reset");
        JBHaztorles1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBHaztorles1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(JLAzonosit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JTazonosit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JLabel)
                                        .addComponent(jLabel5))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Jvaros, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Jhaz, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Jutca, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Jhazszam, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Jkerulet, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLAzonosit2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLAzonosit3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Combobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TK_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(hazhozz, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JBmodosit, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JBHaztorles)
                                .addGap(18, 18, 18)
                                .addComponent(JBHaztorles1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {JLabel, Jhaz, Jhazszam, Jkerulet, Jutca, Jvaros, jLabel1, jLabel2, jLabel3, jLabel5});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLAzonosit3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLAzonosit2)
                    .addComponent(TK_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTazonosit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLAzonosit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jkerulet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jvaros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jhaz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jutca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jhazszam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hazhozz)
                    .addComponent(JBmodosit)
                    .addComponent(JBHaztorles)
                    .addComponent(JBHaztorles1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Jhaz, Jhazszam, Jkerulet, Jutca, Jvaros});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void hazhozzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hazhozzActionPerformed
        dbConnection.ujhaz(Integer.parseInt(Jkerulet.getText()), Jvaros.getText(), Jhaz.getText(), Jutca.getText(), Integer.parseInt(Jhazszam.getText()), Integer.parseInt(TK_ID.getText()));
        Show_UsersList_In_JTable();
    }//GEN-LAST:event_hazhozzActionPerformed

    private void JBmodositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBmodositActionPerformed
        if (JBmodosit.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Kérem Válaszon Házat", "Üres Mező", JOptionPane.INFORMATION_MESSAGE);

        } else {
            dbConnection.Hazakfriss(Jkerulet.getText(), Jvaros.getText(), Jhaz.getText(), Jutca.getText(), Jhazszam.getText(), JTazonosit.getText());
            Jkerulet.setText("");
            Jvaros.setText("");
            Jhaz.setText("");
            Jutca.setText("");
            Jhazszam.setText("");
            JTazonosit.setText("");
            TK_ID.setText("");
            
        }
        Show_UsersList_In_JTable();
    }//GEN-LAST:event_JBmodositActionPerformed

    private void JBHaztorlesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBHaztorlesActionPerformed
        if (JTazonosit.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Kérem Válaszon Házat", "Üres Mező", JOptionPane.INFORMATION_MESSAGE);
        } else {
            dbConnection.Haztorlese(JTazonosit.getText());

            Jkerulet.setText("");
            Jvaros.setText("");
            Jhaz.setText("");
            Jutca.setText("");
            Jhazszam.setText("");
            JTazonosit.setText("");
            TK_ID.setText("");
        }  //Meghivjuk a Tábla methodust hogy lásuk mi van benne
        Show_UsersList_In_JTable();
    }//GEN-LAST:event_JBHaztorlesActionPerformed

    private void ComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboboxActionPerformed
        String nev = Combobox.getSelectedItem().toString();
            TK_ID.setText(nev.substring(nev.lastIndexOf(" ")+1,nev.length())); //Balog Zsolt 1 
    }//GEN-LAST:event_ComboboxActionPerformed

    private void ComboboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboboxMouseClicked
        
    }//GEN-LAST:event_ComboboxMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
int i = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        JTazonosit.setText(model.getValueAt(i, 0).toString());
        Jkerulet.setText(model.getValueAt(i, 1).toString());
        Jvaros.setText(model.getValueAt(i, 2).toString());
        Jhaz.setText(model.getValueAt(i, 3).toString());
        Jutca.setText(model.getValueAt(i, 4).toString());
        Jhazszam.setText(model.getValueAt(i, 5).toString());        
    }//GEN-LAST:event_jTable1MouseClicked

    private void JBHaztorles1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBHaztorles1ActionPerformed
TK_ID.setText("");    
JTazonosit.setText("");
Jkerulet.setText("");
Jvaros.setText("");
Jhaz.setText("");
Jutca.setText("");
Jhazszam.setText("");
    }//GEN-LAST:event_JBHaztorles1ActionPerformed

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
            java.util.logging.Logger.getLogger(kozoskepviselo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(kozoskepviselo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(kozoskepviselo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(kozoskepviselo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                kozoskepviselo dialog = new kozoskepviselo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> Combobox;
    private javax.swing.JButton JBHaztorles;
    private javax.swing.JButton JBHaztorles1;
    private javax.swing.JButton JBmodosit;
    private javax.swing.JLabel JLAzonosit;
    private javax.swing.JLabel JLAzonosit2;
    private javax.swing.JLabel JLAzonosit3;
    private javax.swing.JLabel JLabel;
    private javax.swing.JTextField JTazonosit;
    private javax.swing.JTextField Jhaz;
    private javax.swing.JTextField Jhazszam;
    private javax.swing.JTextField Jkerulet;
    private javax.swing.JTextField Jutca;
    private javax.swing.JTextField Jvaros;
    private javax.swing.JTextField TK_ID;
    private javax.swing.JButton hazhozz;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
