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
public class CBasket {
    int m_Count = 0;
    ArrayList<CBluRay> myBasket = new ArrayList<>();
    
    // BluRay to Basket, Counter++
    public void toBasket(CBluRay _BluRay){
        myBasket.add(_BluRay);
        m_Count++;
    }
    
    public void sendBasket(){
        for(CBluRay b : myBasket)
        {     
            System.out.println(b.getTitle());
        }  
    }
}
