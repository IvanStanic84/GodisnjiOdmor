/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package stanic.view;

import javax.swing.DefaultListModel;
import stanic.controller.ObradaGodisnji;
import stanic.controller.ObradaZaposlenik;
import stanic.util.Pomocno;
import stanic.model.Zaposlenik;

/**
 *
 * @author Korisnik
 */
public class ProzorGlavni extends javax.swing.JFrame {

    /**
     * Creates new form ProzorGlavni
     */
    private ObradaZaposlenik obrada;
  
   
    private int selectedIndex;

    public ProzorGlavni(Izbornik izbornik) {
        initComponents();
        
        obrada = new ObradaZaposlenik();
       
        selectedIndex = 0;
        postavke();
        ucitaj();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstEntiteti = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstEntiteti.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstEntiteti.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstEntitetiValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstEntiteti);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(252, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstEntitetiValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstEntitetiValueChanged
        if (evt.getValueIsAdjusting()
                || lstEntiteti.getSelectedValue() == null) {
            return;
        }
        obrada.setEntitet(lstEntiteti.getSelectedValue());
        popuniView();
       
//        popuniView();
        // pocistiMasuIVrstu();    }//GEN-LAST:event_lstEntitetiValueChanged

        /**
         * @param args the command line arguments
         */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Zaposlenik> lstEntiteti;
    // End of variables declaration//GEN-END:variables

    private void ucitaj() {
        lstEntiteti.setModel(new GodisnjiListModel<>(obrada.read()));
        if (lstEntiteti.getModel().getSize() > 0) {
            lstEntiteti.setSelectedIndex(selectedIndex);
        }
    }

    private void postavke() {
        setTitle(Pomocno.NAZIV_APLIKACIJE + " "
                + " Glavni");
        // ucitajZaposlenike();
        //prilagodiDatePicker();

           
    }

    private void ucitajZaposlenike() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void popuniView() {
var s = obrada.getEntitet();
        //txtIme.setText(s.getIme());
      //  txtPrezime.setText(s.getPrezime());
      //  txtOib.setText(s.getOib());
      //  txtUkupanBrojDana.setText(String.valueOf(s.getUkupanBrojDana()));    }
}}
