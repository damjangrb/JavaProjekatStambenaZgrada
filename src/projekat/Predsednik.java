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
public class Predsednik extends Stanar {
    
    
    public Predsednik(String ime, String prezime, short godina_rodjenja, String mail, String korisnicko_ime, String lozinka, short broj_stana, String nosilac) {
        super(ime, prezime, godina_rodjenja, mail, korisnicko_ime, lozinka, broj_stana, nosilac);
        
    }
    
    
    
    public static boolean UnosPodatakaPredsednik() throws IOException
    {
        Scanner skener = new Scanner(System.in);
        
        
        System.out.println("Unesite podatke o predsedniku kucnog saveta");
        System.out.println("Ime:");
        String ime = skener.next();
        System.out.println("Prezime:");
        String prezime = skener.next();
        System.out.println("Godina rodjenja:");
        short godina = skener.nextShort();
        
        try{
             if( 2018-godina < 18) throw new Exception("nije punoletan");
           }
            catch(Exception e){
                System.err.println("LIce nije punolegno");
                System.out.println("Unesite novu osobu:");
                return false;
            }
        
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
        
        
        try{
              if( nosilac.equals("ne") ) throw new Exception("Nije nosilac");
                
            }
            catch(Exception e){
                System.err.println("LIce nije nosilac stana");
                System.out.println(" Unesite novo lice:");
                return false;
            }
            
        
           
        Predsednik predsednik = new Predsednik(ime, prezime, godina, mail, korisnicko_ime, lozinka, broj_stana, nosilac);
    
        try (Writer writer = new FileWriter("C:\\Users\\Gospodin D\\Documents\\NetBeansProjects\\projekat\\src\\config\\predsednik.json"))
        {
            Gson gson = new GsonBuilder().create();
            gson.toJson(predsednik, writer);
        }
     
         return true;
    
    }
    
}
