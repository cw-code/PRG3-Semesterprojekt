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
    public ArrayList<CCustomer> myCustList = new ArrayList<>();
        
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
    
    public CBluRay searchBR(String _Arg)
    {
        CBluRay retBR = null;
        
        for(CBluRay b : this.getAllBR())
        {
            if (b.getTitle().equals(_Arg))
            {
                retBR = b;
            }
        }
        
        return retBR;
    }
    
        
    public static void main(String[] args) {
        /**
        * @param args the command line arguments
        */
        
        BRK myBRK = new BRK();

        // create test-customer
        CCustomer myEckardt = new CCustomer("Eckardt", "Marco", "07.02.1988", "marco.eckardt@fh-erfurt.de", "123456");
        myBRK.myCustList.add(myEckardt);
        
        // create test-bluray
        CBluRay myBatman = new CBluRay( myEckardt, BRState.OWNER, "Batman", "Action", 12);
        CBluRay myMinions = new CBluRay( myEckardt, BRState.OWNER, "Minions", "Trickfilm", 0);
        
        // test search funtion
        //CBluRay mySearch = myBRK.searchBR("Batman");

        // test delete BR
        myEckardt.deleteBluRay("Minions");
        
        // test toBasket Basket
        //myEckardt.myBasket.toBasket(myBatman);
        
        // test send Basket
        //myEckardt.myBasket.sendBasket();
        
        // TO-DO
        // REGISTRIERUNG
        // LOGIN-Funktion
        // Anzeigen der BluRays aller anderen Kunden
        // BluRay suchen nach Titel od. Genre, FSK...
        // Warenkorb absenden, damit BluRay meiner Liste mit Attribut ausgeliehen hizufügen
        // ENUM (VERLIEHEN, AUSGELIEHEN, VERFÜGBAR)
        // BluRay Rückgabe
        // Newsletter
    }
    
}
