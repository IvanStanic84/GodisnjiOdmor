/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stanic.util;

/**
 *
 * @author Korisnik
 */
public class GodisnjiException extends Exception{


    private String poruka;

    public GodisnjiException(String poruka) {
        super(poruka);
        this.poruka=poruka;
    }

    public String getPoruka() {
        return poruka;
    }

}    

