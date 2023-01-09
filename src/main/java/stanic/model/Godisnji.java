/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stanic.model;

import jakarta.persistence.ManyToOne;
import java.util.Date;

/**
 *
 * @author Korisnik
 */
public class Godisnji extends Entitet{
    
    private Date pocetak;
    private Date kraj;
    
    @ManyToOne
    private Zaposlenik zaposlenik;

    public Godisnji(Date pocetak, Date kraj) {
        this.pocetak = pocetak;
        this.kraj = kraj;
    }

    public Godisnji(Date pocetak, Date kraj, Integer sifra) {
        super(sifra);
        this.pocetak = pocetak;
        this.kraj = kraj;
    }

    public Godisnji() {
    }

    public Date getPocetak() {
        return pocetak;
    }

    public void setPocetak(Date pocetak) {
        this.pocetak = pocetak;
    }

    public Date getKraj() {
        return kraj;
    }

    public void setKraj(Date kraj) {
        this.kraj = kraj;
    }
@Override
    public String toString() {
        return zaposlenik.getIme() + " " + zaposlenik.getPrezime();
    }    
}
