package KlasyGlowne;


import Interfejsy.StworzNowaGreListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nogaz
 */
public class OknoGry extends javax.swing.JFrame implements StworzNowaGreListener{

    //Gra aktualnaGra;
    /**
     * Creates new form OknoGry
     */
    public OknoGry() {
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

        panelNawigacji = new javax.swing.JPanel();
        nowaGraButton = new javax.swing.JButton();
        gracz1Logo = new javax.swing.JPanel();
        gracz2Logo = new javax.swing.JPanel();
        gracz1Label = new javax.swing.JLabel();
        gracz2Label = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        goban1 = new Goban();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gomoku ver.1.0 by Paweł Nogański");
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(800, 640));
        setMinimumSize(new java.awt.Dimension(800, 640));
        setPreferredSize(new java.awt.Dimension(800, 640));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 640));

        panelNawigacji.setBackground(new java.awt.Color(102, 255, 102));
        panelNawigacji.setMaximumSize(new java.awt.Dimension(170, 600));
        panelNawigacji.setMinimumSize(new java.awt.Dimension(170, 600));
        panelNawigacji.setPreferredSize(new java.awt.Dimension(170, 600));

        nowaGraButton.setText("Nowa gra");
        nowaGraButton.setMaximumSize(new java.awt.Dimension(150, 60));
        nowaGraButton.setMinimumSize(new java.awt.Dimension(150, 60));
        nowaGraButton.setPreferredSize(new java.awt.Dimension(150, 60));
        nowaGraButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nowaGraButtonActionPerformed(evt);
            }
        });

        gracz1Logo.setBackground(new java.awt.Color(0, 0, 0));
        gracz1Logo.setMaximumSize(new java.awt.Dimension(50, 50));
        gracz1Logo.setMinimumSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout gracz1LogoLayout = new javax.swing.GroupLayout(gracz1Logo);
        gracz1Logo.setLayout(gracz1LogoLayout);
        gracz1LogoLayout.setHorizontalGroup(
            gracz1LogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        gracz1LogoLayout.setVerticalGroup(
            gracz1LogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gracz2Logo.setBackground(new java.awt.Color(255, 255, 255));
        gracz2Logo.setMaximumSize(new java.awt.Dimension(50, 50));
        gracz2Logo.setMinimumSize(new java.awt.Dimension(50, 50));
        gracz2Logo.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout gracz2LogoLayout = new javax.swing.GroupLayout(gracz2Logo);
        gracz2Logo.setLayout(gracz2LogoLayout);
        gracz2LogoLayout.setHorizontalGroup(
            gracz2LogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        gracz2LogoLayout.setVerticalGroup(
            gracz2LogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gracz1Label.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        gracz1Label.setText("Gracz 1");
        gracz1Label.setMaximumSize(new java.awt.Dimension(50, 50));
        gracz1Label.setMinimumSize(new java.awt.Dimension(50, 50));
        gracz1Label.setPreferredSize(new java.awt.Dimension(50, 50));

        gracz2Label.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        gracz2Label.setText("Gracz 2");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Czas gry:");
        jLabel1.setMaximumSize(new java.awt.Dimension(50, 100));
        jLabel1.setMinimumSize(new java.awt.Dimension(50, 100));
        jLabel1.setPreferredSize(new java.awt.Dimension(50, 100));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("00:00");
        jLabel2.setMaximumSize(new java.awt.Dimension(50, 100));
        jLabel2.setMinimumSize(new java.awt.Dimension(50, 100));
        jLabel2.setPreferredSize(new java.awt.Dimension(50, 100));

        javax.swing.GroupLayout panelNawigacjiLayout = new javax.swing.GroupLayout(panelNawigacji);
        panelNawigacji.setLayout(panelNawigacjiLayout);
        panelNawigacjiLayout.setHorizontalGroup(
            panelNawigacjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNawigacjiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelNawigacjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nowaGraButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelNawigacjiLayout.createSequentialGroup()
                        .addComponent(gracz2Logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(gracz2Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelNawigacjiLayout.createSequentialGroup()
                        .addComponent(gracz1Logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(gracz1Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelNawigacjiLayout.createSequentialGroup()
                        .addGroup(panelNawigacjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelNawigacjiLayout.setVerticalGroup(
            panelNawigacjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNawigacjiLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelNawigacjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(gracz1Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gracz1Logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelNawigacjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(gracz2Logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gracz2Label, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(68, 68, 68)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
                .addComponent(nowaGraButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        goban1.setBackground(new java.awt.Color(255, 255, 102));
        goban1.setMaximumSize(new java.awt.Dimension(600, 600));
        goban1.setMinimumSize(new java.awt.Dimension(600, 600));
        goban1.setPreferredSize(new java.awt.Dimension(600, 600));

        javax.swing.GroupLayout goban1Layout = new javax.swing.GroupLayout(goban1);
        goban1.setLayout(goban1Layout);
        goban1Layout.setHorizontalGroup(
            goban1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        goban1Layout.setVerticalGroup(
            goban1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(goban1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelNawigacji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(goban1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelNawigacji, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nowaGraButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nowaGraButtonActionPerformed
        // TODO add your handling code here:
        NowaGraDialog dialog = new NowaGraDialog(this, rootPaneCheckingEnabled);
        dialog.zarejestrujObserwatora(this);
        dialog.setVisible(true);
    }//GEN-LAST:event_nowaGraButtonActionPerformed

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
            java.util.logging.Logger.getLogger(OknoGry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OknoGry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OknoGry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OknoGry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OknoGry().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Goban goban1;
    private javax.swing.JLabel gracz1Label;
    private javax.swing.JPanel gracz1Logo;
    private javax.swing.JLabel gracz2Label;
    private javax.swing.JPanel gracz2Logo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton nowaGraButton;
    private javax.swing.JPanel panelNawigacji;
    // End of variables declaration//GEN-END:variables

    @Override
    public void stworzNowaGre(int trybGry, String gracz1, String gracz2) {
        
       // aktualnaGra = new Gra(trybGry, gracz1, gracz2, poleGry);
        /*
        if( trybGry == 49 ){
            aktualnaGra = new GraPvP(trybGry, gracz1, gracz2, poleGry);
        }else if( trybGry == 50 ){
            aktualnaGra = new GraPvC(trybGry, gracz1, gracz2, poleGry);
        }else if( trybGry == 51 ){
            aktualnaGra = new GraCvC(trybGry, gracz1, gracz2, poleGry);
        }*/
        System.out.println("SIEMANO");
        gracz1Label.setText(gracz1);
        gracz2Label.setText(gracz2);
        goban1.uruchomNowaGre(trybGry, gracz1, gracz2);
    }
}
