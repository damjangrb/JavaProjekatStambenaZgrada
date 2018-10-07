/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekat;

/**
 *
 * @author Gospodin D
 */
public class Menu {
    
    
    public static void PrviMeni()
    {
     System.out.println("IZABERI OPCIJU (1/2) \n");
     System.out.println("1. Prijava na sistem");
     System.out.println("2. Ugasi aplikaciju");
    }
    
    public static void PredsednikovMeni()
    {
                        System.out.println("Dobrodsli ");
                        System.out.println("Izaberite opciju ");
                        System.out.println("1. Zapisnik sa saveta stanara ");
                        System.out.println("2. Informacije o stanarima ");
                        System.out.println("3. Odjava ");
                        System.out.println("4. Registracija novog stanara");
                        System.out.println("5. Kreiranje zapisnika saveta");
    
    }
    public static void PredsednikMeniZaReg()
    {
                                System.out.println("Izaberi opciju");
                                System.out.println("1. Unesi zahtev");
                                System.out.println("2. Unesi podatke rucno");
    }
    public static void StanarMeni()
    {
                        System.out.println("Dobrodsli ");
                        System.out.println("Izaberite opciju ");
                        System.out.println("1. Zapisnik sa saveta stanara ");
                        System.out.println("2. Informacije o stanarima ");
                        System.out.println("3. Odjava ");
    }
    public static void StanarNijeKreiranMeni()
    {
                    System.out.println("Nalog vam jos uvek nije kreiran");
                    System.out.println("Da li zelite da posaljete zahtev za kreiranje naloga(da/ne)");
    }
}
