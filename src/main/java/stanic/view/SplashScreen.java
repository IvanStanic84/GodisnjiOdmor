/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package stanic.view;

import javax.swing.JOptionPane;
import org.hibernate.Session;
import stanic.controller.ObradaOperater;
import stanic.util.HibernateUtil;
import stanic.util.PocetniInsert;

/**
 *
 * @author Korisnik
 */
public class SplashScreen extends javax.swing.JFrame {

    /**
     * Creates new form SplashScreen
     */
    public SplashScreen() {
        initComponents();

        ucitaj();
    }

    private void ucitaj() {
        Ucitanje u = new Ucitanje();
        u.start();
    }

    private class Ucitanje extends Thread {

        @Override
        public void run() {

            Session s = HibernateUtil.getSession();
            if (!s.getMetamodel().getEntities().isEmpty()) {
                ObradaOperater op = new ObradaOperater();
                if (op.read().isEmpty()) {
                    new PocetniInsert();
                }

                new Login().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Problem s bazom podataka");
            }

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
