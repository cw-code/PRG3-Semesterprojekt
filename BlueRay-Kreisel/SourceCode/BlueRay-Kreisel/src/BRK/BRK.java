/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BRK;

import java.util.*;

/**
 *
 * @author Marco
 */
public class BRK {        
    
    // List of all Customers
    ArrayList<CCustomer> myCustList = new ArrayList<>();
        
    public ArrayList<CBluRay> getAllBR()
    {
        ArrayList<CBluRay> myList = new ArrayList();
        // List all BR in BRK
        for(CCustomer c : this.myCustList)
        {
            for(CBluRay b : c.myBluRayList)
            {
                myList.add(b);
            }
        }
        return myList;
    }
    
        
    public static void main(String[] args) {
        /**
        * @param args the command line arguments
        */
        
        BRK myBRK = new BRK();

        
        // create test-customer
        String myDate = "07.02.1988";
        CCustomer myEckardt = new CCustomer("Eckardt", "Marco", myDate, "marco.eckardt@fh-erfurt.de", "123456");
        myBRK.myCustList.add(myEckardt);
        
        // create test-bluray
        CBluRay myBatman = new CBluRay( myEckardt, BRState.OWNER, "Batman", "Action", 12);
        CBluRay myMinions = new CBluRay( myEckardt, BRState.OWNER, "Minions", "Trickfilm", 0);
        
        // printout test-customer and test-bluray
        System.out.println(myBRK.myCustList.size());
        System.out.println(myBRK.myCustList.get(0).getBirthday().toString());
        //myEckardt.printList(myEckardt.myBluRayList);
        
        // test to delete bluray
        //myEckardt.deleteBluRay("Batman");
        myEckardt.printList(myEckardt.myBluRayList);
        
        for(CBluRay b : myBRK.getAllBR())
        {
            b.getTitel();
        }
        
        //myEckardt.myBasket.toBasket(myBatman);
        
        
       
        // TO-DO
        // REGISTRIERUNG
        // LOGIN-Funktion
        // alle Kunden in einer Liste in BRK sichern
        // Anzeigen der BluRays aller anderen Kunden
        // BluRay suchen nach Titel od. Genre, FSK...
        // BluRay in Warenkorb aufnehmen
        // Warenkorb absenden, damit BluRay meiner Liste mit Attribut ausgeliehen hizufügen
        // ENUM (VERLIEHEN, AUSGELIEHEN, VERFÜGBAR)
        // BluRay Rückgabe
        // Newsletter
    }
    
}
