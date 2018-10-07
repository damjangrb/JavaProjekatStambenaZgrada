/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

/**
 *
 * @author Gospodin D
 */
class Stanar {
    String ime;
    String prezime;
    short godina_rodjenja;
    String mail;
    String korisnicko_ime;
    String lozinka;
    short broj_stana;
    String nosilac;

    public Stanar(String ime, String prezime, short godina_rodjenja, String mail, String korisnicko_ime, String lozinka, short broj_stana, String nosilac) {
        this.ime = ime;
        this.prezime = prezime;
        this.godina_rodjenja = godina_rodjenja;
        this.mail = mail;
        this.korisnicko_ime = korisnicko_ime;
        this.lozinka = lozinka;
        this.broj_stana = broj_stana;
        this.nosilac = nosilac;
    }
    
    
    public static boolean UnosPodatakaStanar() throws IOException
    {
        Scanner skener = new Scanner(System.in);
        System.out.println("Unesite podatke o stanaru");
        System.out.println("Ime:");
        String ime = skener.next();
        System.out.println("Prezime:");
        String prezime = skener.next();
        System.out.println("Godina rodjenja:");
        short godina = skener.nextShort();
        System.out.println("E-mail:");
        String mail = skener.next();
        System.out.println("Korisnicko ime:");
        String korisnicko_ime = skener.next();
        System.out.println("Lozinka:");
        String lozinka = skener.next();
        System.out.println("Broj stana:");
        short broj_stana = skener.nextShort();
        System.out.println("Da li je nosilac stana (da/ne)");
        String nosilac = skener.next();   
                       
                     
        Stanar novi = new Stanar(ime, prezime, godina, mail, korisnicko_ime, lozinka, broj_stana, nosilac);
                    
        try (Writer writer = new FileWriter("C:\\Users\\Gospodin D\\Documents\\NetBeansProjects\\projekat\\src\\nalozi\\" + korisnicko_ime+".json"))
         {
            Gson gson = new GsonBuilder().create();
            gson.toJson(novi, writer);
                              
         }
        
    
        return true;
    }
    
     public static boolean UnosPodatakaStanarZahtev() throws IOException
     {
     Scanner skener = new Scanner(System.in);
        System.out.println("Unesite podatke o stanaru");
        System.out.println("Ime:");
        String ime = skener.next();
        System.out.println("Prezime:");
        String prezime = skener.next();
        System.out.println("Godina rodjenja:");
        short godina = skener.nextShort();
        System.out.println("E-mail:");
        String mail = skener.next();
        System.out.println("Korisnicko ime:");
        String korisnicko_ime = skener.next();
        System.out.println("Lozinka:");
        String lozinka = skener.next();
        System.out.println("Broj stana:");
        short broj_stana = skener.nextShort();
        System.out.println("Da li je nosilac stana (da/ne)");
        String nosilac = skener.next();   
                       
                     
        Stanar novi = new Stanar(ime, prezime, godina, mail, korisnicko_ime, lozinka, broj_stana, nosilac);
                    
        try (Writer writer = new FileWriter("C:\\Users\\Gospodin D\\Documents\\NetBeansProjects\\projekat\\src\\nalozi\\" + korisnicko_ime+ "_zahtev"+".json"))
         {
            Gson gson = new GsonBuilder().create();
            gson.toJson(novi, writer);
                              
         }
     return true;
     }
    
   
    @Override
    public String toString()
    {
    
        return "Ime stanara je  " + this.ime + " , prezime je " + this.prezime + " , godina rodjenja " + this.godina_rodjenja + " , mail je " + this.mail + " , broj stana je " + this.broj_stana + " , stanar je nosila stana - "+ this.nosilac ; 
    
    }
    
}
