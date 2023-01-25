/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stanic.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import stanic.model.Godisnji;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class GodisnjiTableModel extends AbstractTableModel {
    
    
    private String[] colNames = new String[]{"Početak GO", "Završetak GO", "Iskorišteno dana"};

    public Class[] m_colTypes = {Date.class, Date.class, Integer.class};

    private List<Godisnji> odmori;
    private SimpleDateFormat df;

    public GodisnjiTableModel(List<Godisnji> odmori) {
        this.odmori = odmori;
        df = new SimpleDateFormat("dd:MM:YYYY");

    }

    @Override
    public int getRowCount() {
        return odmori == null ? 0 : odmori.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        var p = odmori.get(rowIndex);
        switch (columnIndex) {
            case 0:
                
                if (p.getPocetak()!= null) {
                    return df.format(p.getPocetak());
                } else {
                    return "";
                }
            case 1:
                if (p.getKraj() != null) {
                    return df.format(p.getKraj());
                } else {
                    return "";
                }
            case 3:
                return p.getZaposlenik().getUkupanBrojDana();
         /*   case 4:
                return p.isRoditeljskaPratnja();
            case 5:
                return p.isGratis();
            case 6:
                return p.getOrmaric();*/
        }
        return "";
    }

    @Override
    public String getColumnName(int col) {
        return colNames[col];
    }

    public Class getColumnClass(int col) {
        return m_colTypes[col];
    }

    public Godisnji getGodisnji(int rowIndex) {
        return odmori.get(rowIndex);
    }
    
}
