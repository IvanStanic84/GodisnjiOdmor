/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package stanic.view;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.DateTimePicker;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import stanic.controller.ObradaGodisnji;
import stanic.controller.ObradaZaposlenik;
import stanic.util.Pomocno;
import stanic.model.Zaposlenik;
import stanic.model.ZaposlenikGodisnji;
import stanic.util.GodisnjiException;

/**
 *
 * @author Korisnik
 */
public class ProzorGlavni extends javax.swing.JFrame {

    /**
     * Creates new form ProzorGlavni
     */
    private ObradaZaposlenik obrada;
    private ObradaGodisnji obradaGodisnji;
    private SimpleDateFormat df;

    private int selectedIndex;

    public ProzorGlavni(Izbornik izbornik) {
        initComponents();

        obrada = new ObradaZaposlenik();
        obradaGodisnji = new ObradaGodisnji();
df = new SimpleDateFormat("dd. MMMM yyyy.");
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
        dpPocetak = new com.github.lgooddatepicker.components.DatePicker();
        dpZavrsetak = new com.github.lgooddatepicker.components.DatePicker();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPreostaloDana = new javax.swing.JTextField();
        btnPromjeni = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtDanaGO = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstOdmori = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstEntiteti.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstEntiteti.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstEntitetiValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstEntiteti);

        jLabel1.setText("Datum početka GO");

        jLabel2.setText("Datum završetka GO");

        jLabel3.setText("Preostalo dana GO");

        btnPromjeni.setText("Promjeni");
        btnPromjeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjeniActionPerformed(evt);
            }
        });

        jLabel4.setText("Dana GO");

        lstOdmori.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstOdmori.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstOdmoriValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstOdmori);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dpPocetak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dpZavrsetak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPreostaloDana)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDanaGO))
                        .addGap(65, 65, 65)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(btnPromjeni, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(10, 10, 10)
                            .addComponent(dpPocetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel2)
                            .addGap(7, 7, 7)
                            .addComponent(dpZavrsetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtDanaGO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPreostaloDana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(btnPromjeni)
                .addGap(21, 21, 21))
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
    }
//        popuniView();
    // pocistiMasuIVrstu();    }//GEN-LAST:event_lstEntitetiValueChanged

    private void btnPromjeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniActionPerformed
        if (obrada.getEntitet() == null) {
            JOptionPane.showMessageDialog(rootPane,
                    "Prvo odaberite posjetu");
            return;
        }
        popuniModel();

        try {
            obrada.update();
            ucitaj();
        } catch (GodisnjiException e) {
            obrada.refresh();
            JOptionPane.showMessageDialog(rootPane,
                    e.getPoruka());
        }
    }//GEN-LAST:event_btnPromjeniActionPerformed

    private void lstOdmoriValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstOdmoriValueChanged
 if (evt.getValueIsAdjusting()
         
         //upitno!!!!!
                || lstOdmori.getSelectedValue() == null) {
            return;
        }

        txtVrstaRibe.setText(lstRibiciNaNatjecanju.getSelectedValue().getVrstaRibe());
        txtMasa.setText(lstRibiciNaNatjecanju.getSelectedValue().getMasa());
    }//GEN-LAST:event_lstOdmoriValueChanged

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPromjeni;
    private com.github.lgooddatepicker.components.DatePicker dpPocetak;
    private com.github.lgooddatepicker.components.DatePicker dpZavrsetak;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<Zaposlenik> lstEntiteti;
    private javax.swing.JList<ZaposlenikGodisnji> lstOdmori;
    private javax.swing.JTextField txtDanaGO;
    private javax.swing.JTextField txtPreostaloDana;
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
        dpPocetak.setDateToToday();
        

    }

    private void ucitajZaposlenike() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void prilagodiDatePicker() {
        DatePickerSettings dps
                = new DatePickerSettings(new Locale("hr", "HR"));
        dps.setFormatForDatesCommonEra(Pomocno.FORMAT_DATUMA);
        dps.setTranslationClear("Očisti");
        dps.setTranslationToday("Danas");
        dpPocetak.setSettings(dps);
        dpZavrsetak.setSettings(dps);
    }

    

    private void popuniView() {
        var s = obrada.getEntitet();
        
        
        txtDanaGO.setText(String.valueOf(s.getUkupanBrojDana()));
        //txtIme.setText(s.getIme());
        //  txtPrezime.setText(s.getPrezime());
        //  txtOib.setText(s.getOib());
        //  txtUkupanBrojDana.setText(String.valueOf(s.getUkupanBrojDana()));    }
    }

    private void popuniModel() {

        var s = obradaGodisnji.getEntitet();

        if (dpPocetak.getDate() != null) {
            LocalDate ldt = LocalDate.from(dpPocetak.getDate());
            s.setPocetak(Date.from(ldt.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        } else {
            s.setPocetak(null);
        }

        if (dpZavrsetak.getDate() != null) {
            LocalDateTime ldt = LocalDateTime.from(dpZavrsetak.getDate()
            );
            s.setKraj(Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant()));
        } else {
            s.setPocetak(null);
        }

    }

    private ZaposlenikGodisnji kreirajOdmore(Zaposlenik z, Date po, Date zv, int dana, int preDana) {
        ZaposlenikGodisnji zg = new ZaposlenikGodisnji();
        zg.setZaposlenik(z);
        zg.setPocetak(po);
        zg.setZavrsetak(zv);
        zg.setPreostaloDana(preDana);

        return zg;

    }
    
    
}
