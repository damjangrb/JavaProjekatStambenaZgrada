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
class Zgrada {
    private String adresa;
    private short broj;
    private String opstina;
    private String grad;
    private short broj_stanova;

    public Zgrada(String adresa, short broj, String opstina, String grad, short broj_stanova) {
        this.adresa = adresa;
        this.broj = broj;
        this.opstina = opstina;
        this.grad = grad;
        this.broj_stanova = broj_stanova;
    }

    public static void UnosZgrade() throws IOException
    {
        Scanner skener = new Scanner(System.in);
        System.out.println("Unesite podatke o zgradi:");
        System.out.println("Adresa:");
        String adresa = skener.nextLine();    
        System.out.println("Broj:");
        short broj = skener.nextShort();
        skener.nextLine();
        System.out.println("Opstina:");
        String opstina = skener.nextLine();
        System.out.println("Grad:");
        String grad = skener.nextLine();
        System.out.println("Broj stanova u zgradi:");
        short broj_stanova = skener.nextShort();
        skener.nextLine();
        
        Zgrada z = new Zgrada(adresa, broj, opstina, grad, broj_stanova);
        
        try (Writer writer = new FileWriter("C:\\Users\\Gospodin D\\Documents\\NetBeansProjects\\projekat\\src\\config\\zgrada.json"))
        {
            Gson gson = new GsonBuilder().create();
            gson.toJson(z, writer);
        }
    
    
    }
    
    

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public short getBroj() {
        return broj;
    }

    public void setBroj(short broj) {
        this.broj = broj;
    }

    public String getOpstina() {
        return opstina;
    }

    public void setOpstina(String opstina) {
        this.opstina = opstina;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public short getBroj_stanova() {
        return broj_stanova;
    }

    public void setBroj_stanova(short broj_stanova) {
        this.broj_stanova = broj_stanova;
    }
    
    
    
}
