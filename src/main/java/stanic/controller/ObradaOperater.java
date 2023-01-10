/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stanic.controller;

import jakarta.persistence.NoResultException;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;
import stanic.model.Operater;
import stanic.util.GodisnjiException;

/**
 *
 * @author Korisnik
 */
public class ObradaOperater extends Obrada<Operater> {

    public Operater autoriziraj(String oib, char[] lozinka) {
        Operater o;
        try {
            o = session.createQuery("from Operater where oib=:oib",
                    Operater.class)
                    .setParameter("oib", oib)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

        if (BCrypt.checkpw(new String(lozinka), o.getLozinka())) {
            Operater vrati = new Operater();
            vrati.setSifra(o.getSifra());
            vrati.setIme(o.getIme());
            vrati.setPrezime(o.getPrezime());
            vrati.setOib(o.getOib());
          
            return vrati;
        }

        return null;
    }

    @Override
    public List read() {
        return session.createQuery("from Operater", Operater.class).list();
    }

    @Override
    protected String getNazivEntiteta() {
        return "Operater";
    }

    @Override
    protected void kontrolaCreate() throws GodisnjiException {
    }

    @Override
    protected void kontrolaUpdate() throws GodisnjiException {
    }

    @Override
    protected void kontrolaDelete() throws GodisnjiException {
    }
}
