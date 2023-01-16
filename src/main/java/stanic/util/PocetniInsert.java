/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stanic.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.hibernate.Session;
import org.mindrot.jbcrypt.BCrypt;
import stanic.model.Godisnji;
import stanic.model.Operater;
import stanic.model.Zaposlenik;

/**
 *
 * @author Korisnik
 */
public class PocetniInsert {

    private List<Godisnji> odmori;
    private List<Zaposlenik> zaposlenici;
    private Session sess;

    public PocetniInsert() {

        odmori = new ArrayList<>();
        zaposlenici = new ArrayList<>();

        sess = HibernateUtil.getSession();

        sess.beginTransaction();

        kreirajGodisnjeOdmore();
        kreirajZaposlenike();

        kreirajOperatera();
        sess.getTransaction().commit();
        HibernateUtil.reset();
    }

    private void kreirajOperatera() {
        Operater o = new Operater();
        o.setIme("Ivan");
        o.setPrezime("Stanić");
        o.setOib("70515566734");
        o.setLozinka(BCrypt.hashpw("stamba", BCrypt.gensalt()));
        sess.persist(o);

    }

    private Date createDate(int godina, int mjesec,
            int dan, int sat, int minute) {
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.set(Calendar.YEAR, godina);
        gc.set(Calendar.MONTH, mjesec - 1);
        gc.set(Calendar.DAY_OF_MONTH, dan);
        gc.set(Calendar.HOUR_OF_DAY, sat);
        gc.set(Calendar.MINUTE, minute);
        gc.set(Calendar.SECOND, 0);
        gc.set((Calendar.MILLISECOND), 0);
        return gc.getTime();
    }

    private void kreirajGodisnjeOdmore() {
        odmori.add(prviOdmor());
    }

    private Godisnji prviOdmor() {
        Godisnji go = new Godisnji();

        go.setPocetak(createDate(2022, 10, 03, 9, 0));
        go.setKraj(createDate(2022, 10, 03, 12, 0));

        sess.persist(go);
        return go;
    }
    
    
    private void kreirajZaposlenike() {
        zaposlenici.add(prviZaposlenik());
    }

    private Zaposlenik prviZaposlenik() {
        Zaposlenik z = new Zaposlenik();

       z.setIme("Pero");
       z.setPrezime("Perić");
       z.setOib("76734269357");
       z.setUkupniBrojDana(30);
     

        sess.persist(z);
        return z;
    }

}
