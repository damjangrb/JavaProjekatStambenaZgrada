/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.text.html.HTMLDocument;

/**
 *
 * @author Gospodin D
 */
public class Projekat {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        String [] listaDatoteka ;
        String [] listaStanara ;
        
        File folder = new File("C:\\Users\\Gospodin D\\Documents\\NetBeansProjects\\projekat\\src\\zapisnici\\");
        File [] listaF = folder.listFiles();
        
        File folderNaloga = new File("C:\\Users\\Gospodin D\\Documents\\NetBeansProjects\\projekat\\src\\nalozi\\");
        File [] listaNaloga = folderNaloga.listFiles();
        
        
        boolean izlazIzPrvog = true;
        boolean odjava = false;
        
        
        Scanner skener = new Scanner(System.in);
        
        File fajl = new File("C:\\Users\\Gospodin D\\Documents\\NetBeansProjects\\projekat\\src\\config\\zgrada.json");
        
        if(fajl.length() <= 0 ) //ovde IF i proveriti da li je json datoteka prazna, ako jeste onda je prvo pokretanje aplikacije
        {
        while(izlazIzPrvog)
        {
        boolean izlaz=false;
        boolean kraj=true;
        
        Zgrada.UnosZgrade();
        
        while(kraj)
        {
       kraj= Predsednik.UnosPodatakaPredsednik();
     
        
        izlazIzPrvog = false;
        }
    }
        
        
    }
        
        int izbor;
        
        while(true)
        {
            odjava =false;
            
            Menu.PrviMeni();
        
            izbor = skener.nextInt();
            skener.nextLine();
                
                if(izbor == 1)
                {
                System.out.println("Unesi koriscnicko ime ");
                String ime = skener.nextLine();
                System.out.println("Unesi lozinku ");
                String lozinka = skener.nextLine();
                
                 
                File stanar = new File("C:\\Users\\Gospodin D\\Documents\\NetBeansProjects\\projekat\\src\\nalozi\\"+ime+".json");
                File predsednik = new File("C:\\Users\\Gospodin D\\Documents\\NetBeansProjects\\projekat\\src\\config\\predsednik.json");
                
                if(stanar.exists())
                {
                Reader reader = new FileReader(stanar);
                    Gson gson = new Gson();
                    Stanar str = gson.fromJson(reader , Stanar.class);
                   
                    
                 Reader reader2 = new FileReader(predsednik);
                    Gson gson1 = new Gson();
                    Stanar pred = gson1.fromJson(reader2 , Stanar.class); 
                    
                      
                    if(pred.korisnicko_ime.equals(ime) && (pred.lozinka.equals(lozinka)))
                    {
                    
                        
                        while(true)
                        {
                        
                        int izborp;
                        Menu.PredsednikovMeni();
                        
                        izborp = skener.nextInt();
                        skener.nextLine();
                    
                        switch (izborp) {
                        case 1:
                            int brojac=0;
                            int izbor4;
                            String dat;
                            FileInputStream fin = null;
                            
                            
                            File zapisnici  = new File("C:\\Users\\Gospodin D\\Documents\\NetBeansProjects\\projekat\\src\\zapisnici\\");
                            
                            
                            if(zapisnici.listFiles().length <=0)
                            {  System.out.println("Nema zapisnika");
                            break;
                            }
                            
                            int duzina;
                            duzina = (int) zapisnici.length();
                            listaDatoteka = new String[duzina];
                           listaDatoteka = zapisnici.list();
                            
                            for(String a : listaDatoteka)
                            {
                                
                                System.out.println(""+brojac + "." + a);
                                brojac++;
                            }
                            
                            System.out.println("Koju datoteku zelite da otvorite?");
                           izbor4 = skener.nextInt();
                           skener.nextLine();
                           
                           String trazena = listaDatoteka[izbor4];
                           
                           try  
                           {
                               fin = new FileInputStream("C:\\Users\\Gospodin D\\Documents\\NetBeansProjects\\projekat\\src\\zapisnici\\" +trazena );
                           }
                           catch (FileNotFoundException e){System.out.println("Datoteka nije pronađena");}
                           
                           try
                           {
                           int c;
                           while((c=fin.read())!=-1)
                                   System.out.print((char)c);
                           }
                           catch (IOException e){System.out.println("Greška u radu sa datotekama");}
                            System.out.println("");
                           fin.close();
                        
                            
                            break;
                        case 2:
                            
                             File nalozi  = new File("C:\\Users\\Gospodin D\\Documents\\NetBeansProjects\\projekat\\src\\nalozi\\");
                            int duzinaS;
                            duzinaS = (int) nalozi.length();
                            listaStanara = new String[duzinaS];
                           listaStanara = nalozi.list();
                           int izborStanara;
                            
                            int brojacStanara=0;
                            
                            for(String a : listaStanara)
                            {
                                
                                a=a.replace(".json", "");
                                
                                System.out.println(brojacStanara + " " + a);
                                brojacStanara++;
                            }
                           
                             brojacStanara=0;
                            
                            System.out.println("Izaberite index stanara");
                            izborStanara = skener.nextInt();
                            skener.nextLine();
                            
                          String imeNaloga = listaNaloga[izborStanara].toString();
                          reader = new FileReader(imeNaloga);
                          gson = new Gson();
                           str = gson.fromJson(reader , Stanar.class);
                            
                            System.out.println("" + str.toString());
                            
                            System.out.println("Da li zelite nazad u glavni meni? (da/ne)");
                           String izbor3 = skener.nextLine();
                            if(izbor3.equals("da"))
                                
                               break;
                            else
                            {
                            System.exit(0);
                            }
                        case 3:
                            System.out.println("Odjavljeni ste");
                            odjava = true;
                            break;
                        case 4:
                            int br=0; 
                            boolean ima=false;
                            
                             
                            File naloziS  = new File("C:\\Users\\Gospodin D\\Documents\\NetBeansProjects\\projekat\\src\\nalozi\\");
                            
                            duzinaS = (int) naloziS.length();
                            listaStanara = new String[duzinaS];
                           listaStanara = naloziS.list();
                            
                            String [] novaLista;
                            int brZaListu=0;
                            
                            for(String a : listaStanara)
                            {
                                if(a.contains("zahtev"))
                                { System.out.println("" + a);
                                    ima=true;
                                    brZaListu++;
                                }
                                
                                
                            }
                            if(ima)
                            {
                                int br5=0;
                                
                                novaLista = new String[brZaListu];
                                
                                for(String a : listaStanara)
                            {
                                if(a.contains("zahtev"))
                                { 
                                    novaLista[br5] = a;
                                    br5++;
                                }
                                
                                
                                
                            }
                                
                                
                                int opcija;
                                Menu.PredsednikMeniZaReg();
                                
                                opcija = skener.nextInt();
                                skener.nextLine();
                                
                                if(opcija == 1)
                                {
                                    System.out.println("Indeks zahteva za unos");
                                    int ind;
                                    
                                    ind = skener.nextInt();
                                    skener.nextLine();
                                    
                                String imeFajla = novaLista[ind];
                                String novoIme = imeFajla.replaceAll("_zahtev.json","");
                                
                                    File stari = new File("C:\\Users\\Gospodin D\\Documents\\NetBeansProjects\\projekat\\src\\nalozi\\"+imeFajla);
                                    File novi = new File("C:\\Users\\Gospodin D\\Documents\\NetBeansProjects\\projekat\\src\\nalozi\\"+novoIme + ".json");
                                    stari.renameTo(novi);
                                    
                                }
                                else
                                {
                                   Stanar.UnosPodatakaStanar();
                                
                                
                                }
                            }
                            else
                            {
                                System.out.println("Nema naloga");
                            }
                            break;
                        case 5:
                            System.out.println("Unesi tekst zapisnika");
                            String tekst;
                            tekst = skener.nextLine();
                            System.out.println("Unesite ime datoteke za zapisnik (datotekaRedniBr)");
                            String imedat;
                            imedat = skener.nextLine();
                            
                            File data = new File("C:\\Users\\Gospodin D\\Documents\\NetBeansProjects\\projekat\\src\\zapisnici\\" + imedat + ".txt");
                            PrintWriter out = new PrintWriter(data);
                            out.append(tekst);
                            out.close();
                           
                          break;
                                    
                        default:
                            break;
                    }
                        
                         if(odjava)
                            break;
                        }
                      }
                     else if(str.lozinka.equals(lozinka))
                    {
                        
                        while(true)
                        {
                        int izbor1;
                        Menu.StanarMeni();
                        
                        izbor1 = skener.nextInt();
                        skener.nextLine();
                        
                    switch (izbor1) {
                        case 1:
                            int brojac=0;
                            int izbor4;
                            String dat;
                            FileInputStream fin = null;
                            
                            
                            File zapisnici  = new File("C:\\Users\\Gospodin D\\Documents\\NetBeansProjects\\projekat\\src\\zapisnici\\");
                            
                            
                            if(zapisnici.listFiles().length  <=0)
                            {  System.out.println("Nema zapisnika");
                            break;
                            }
                            
                            int duzina;
                            duzina = (int) zapisnici.length();
                            listaDatoteka = new String[duzina];
                           listaDatoteka = zapisnici.list();
                            
                            for(String a : listaDatoteka)
                            {
                                
                                System.out.println(""+brojac + "." + a);
                                brojac++;
                            }
                            
                            System.out.println("Koju datoteku zelite da otvorite?");
                           izbor4 = skener.nextInt();
                           skener.nextLine();
                           
                           String trazena = listaDatoteka[izbor4];
                           
                            try  
                           {
                               fin = new FileInputStream("C:\\Users\\Gospodin D\\Documents\\NetBeansProjects\\projekat\\src\\zapisnici\\" +trazena );
                           }
                           catch (FileNotFoundException e){System.out.println("Datoteka nije pronađena");}
                           
                           try
                           {
                           int c;
                           while((c=fin.read())!=-1)
                                   System.out.print((char)c);
                           }
                           catch (IOException e){System.out.println("Greška u radu sa datotekama");}
                           System.out.println("");
                           fin.close();
                            
                            break;
                        case 2:
                            
                             File nalozi  = new File("C:\\Users\\Gospodin D\\Documents\\NetBeansProjects\\projekat\\src\\nalozi\\");
                            int duzinaS;
                            duzinaS = (int) nalozi.length();
                            listaStanara = new String[duzinaS];
                           listaStanara = nalozi.list();
                            
                              for(String a : listaStanara)
                            {
                                System.out.println("" + a);
                            }
                        
                           System.out.println("Da li zelite nazad u glavni meni? (da/ne)");
                           String izbor3 = skener.nextLine();
                            if(izbor3.equals("da"))
                                break;
                            else
                            {
                            System.exit(0);
                            }
                        case 3:
                            System.out.println("Odjavljeni ste");
                            odjava = true;
                            break;
                        default:
                            
                            break;
                    }
                       if(odjava)
                           break;
                    }
                        
                    }
                    else
                    {
                        System.out.println("Lozinka nije dobra!");
                        continue;
                    
                    }
                    
                   }
                else
                {
                    Menu.StanarNijeKreiranMeni();
                    String izbor2 = skener.nextLine();
                
                    if(izbor2.equals("da") )
                    {
                     Stanar.UnosPodatakaStanarZahtev();
                    }
                    else
                        break;
                }
                        
                
                }
                else
                   System.exit(0);
       }
   }
}
