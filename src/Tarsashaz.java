/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Balog Zsolt
 */
public class Tarsashaz extends javax.swing.JFrame {

    private DbConnection dbConnection = null;

    public Tarsashaz() {
        initComponents();
//egyetlen egye példányos futtatás a kapcsolathoz
        dbConnection = DbConnection.getInstance();

    }

    public void lako() {
        Lakok l = new Lakok(this, true);
        l.setVisible(true);
    }
    
    
    public void sugo() {
        kozoskepviselo s = new kozoskepviselo(this, true);
        s.setVisible(true);
    }
    
    public void hazak(){
    Hazak h =new Hazak(this,true);
    h.setVisible(true);
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JBkepviselo = new javax.swing.JButton();
        JBHaz = new javax.swing.JButton();
        JBlako = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JBkepviselo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JBkepviselo.setText("Képviselők kezelése");
        JBkepviselo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBkepviseloActionPerformed(evt);
            }
        });

        JBHaz.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JBHaz.setText("Házak Kezelése");
        JBHaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBHazActionPerformed(evt);
            }
        });

        JBlako.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JBlako.setText("Lakók hozzáadása");
        JBlako.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBlakoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBkepviselo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JBHaz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JBlako, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JBkepviselo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBHaz)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBlako)
                .addContainerGap(207, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JBkepviseloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBkepviseloActionPerformed
        sugo();
    }//GEN-LAST:event_JBkepviseloActionPerformed

    private void JBHazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBHazActionPerformed
        hazak();        // TODO add your handling code here:
    }//GEN-LAST:event_JBHazActionPerformed

    private void JBlakoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBlakoActionPerformed
       lako();
    }//GEN-LAST:event_JBlakoActionPerformed

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
            java.util.logging.Logger.getLogger(Tarsashaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tarsashaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tarsashaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tarsashaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tarsashaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBHaz;
    private javax.swing.JButton JBkepviselo;
    private javax.swing.JButton JBlako;
    // End of variables declaration//GEN-END:variables
}
