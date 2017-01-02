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

    /**
     * @param args the command line arguments
     */
        
    public static void main(String[] args) {
        // List of all Customers
        ArrayList<CCustomer> myCustList = new ArrayList<>();
        
        // create test-customer
        String myDate = "07.02.1988";
        CCustomer myEckardt = new CCustomer("Eckardt", "Marco", myDate, "marco.eckardt@fh-erfurt.de", "123456");
        myCustList.add(myEckardt);
        
        // create test-bluray
        CBluRay myBatman = new CBluRay("Batman", "Action", 12, myEckardt);
        CBluRay myMinions = new CBluRay("Minions", "Trickfilm", 0, myEckardt);
        
        // printout test-customer and test-bluray
        System.out.println(myCustList.size());
        System.out.println(myCustList.get(0).getBirthday().toString());
        myEckardt.printList(myEckardt.myBluRayList);
        
        // test to delete bluray
        myEckardt.deleteBluRay("Batman");
        myEckardt.printList(myEckardt.myBluRayList);
        
        myEckardt.myBasket.toBasket(myBatman);
    }
    
}
