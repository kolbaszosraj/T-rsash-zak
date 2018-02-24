/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Balog Zsolt
 * @version 1.0
 *
 */
public class Tarsashaz extends javax.swing.JFrame {

    private DbConnection dbConnection = null;

    /**
     * meghivjuk dbConnectiun methodust
     * a társashaz indulásakor és castlakozunk az adatbázishoz
     * majd a szingelton programozás elvet követve adunk neki 1 példányt
     */
    public Tarsashaz() {
        initComponents();
//egyetlen egye példányos futtatás a kapcsolathoz
        dbConnection = DbConnection.getInstance();

    }

    /**
     * megjelniti a lekerdezés nevü ablakot
     */
    public void Lekerdezes() {
        lekerdez le = new lekerdez(this, true);
        le.setVisible(true);
    }

    /**
     * megjelniti a lako nevü ablakot
     */
    public void lako() {
        Lakok l = new Lakok(this, true);
        l.setVisible(true);
    }

    /**
     * megjelniti a lekerdezés (teszt ablak volt a sugó) megjelniti a közösképviselők ablakát ablakot
     */
    public void sugo() {
        kozoskepviselo s = new kozoskepviselo(this, true);
        s.setVisible(true);
    }

    /**
     *megjelniti a hazak kezelésére szolgáló ablakot
     */
    public void hazak() {
        Hazak h = new Hazak(this, true);
        h.setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JBkepviselo = new javax.swing.JButton();
        JBHaz = new javax.swing.JButton();
        JBlako = new javax.swing.JButton();
        JBlekerdez = new javax.swing.JButton();

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
        JBlako.setText("Lakók Kezelése");
        JBlako.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBlakoActionPerformed(evt);
            }
        });

        JBlekerdez.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JBlekerdez.setText("Lekérdezés");
        JBlekerdez.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBlekerdezActionPerformed(evt);
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
                    .addComponent(JBlako, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JBlekerdez, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBlekerdez)
                .addContainerGap(176, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JBkepviseloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBkepviseloActionPerformed

        sugo();
    }//GEN-LAST:event_JBkepviseloActionPerformed

    private void JBHazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBHazActionPerformed
        hazak();
    }//GEN-LAST:event_JBHazActionPerformed

    private void JBlakoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBlakoActionPerformed
        lako();
    }//GEN-LAST:event_JBlakoActionPerformed

    private void JBlekerdezActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBlekerdezActionPerformed
        Lekerdezes();
    }//GEN-LAST:event_JBlekerdezActionPerformed

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
    private javax.swing.JButton JBlekerdez;
    // End of variables declaration//GEN-END:variables
}
