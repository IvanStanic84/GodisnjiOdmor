/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stanic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.Date;

/**
 *
 * @author Korisnik
 */
@Entity
public class Godisnji extends Entitet {

    private Date pocetak;
    private Date kraj;

    @ManyToOne
    private Zaposlenik zaposlenik;

    public Godisnji() {
    }

    public Godisnji(Date pocetak, Date kraj, Zaposlenik zaposlenik, Integer sifra) {
        super(sifra);
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.zaposlenik = zaposlenik;
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

    public Zaposlenik getZaposlenik() {
        return zaposlenik;
    }

    public void setZaposlenik(Zaposlenik zaposlenik) {
        this.zaposlenik = zaposlenik;
    }

    @Override
    public String toString() {
        return zaposlenik.getIme() + " " + zaposlenik.getPrezime();
    }
}
