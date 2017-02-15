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
    ArrayList<CBluRay> BasketList = new ArrayList<>();
    
    
    /**
     * puts a BR to basket, if checkFSK is true and BR is available
     * @param _BRK
     * @param _From
     * @param _Me
     * @param _BR
     */
    public void toBasket(BRK _BRK, CCustomer _From, CCustomer _Me, CBluRay _BR)
    {
        if ( _BRK.checkFSK(_Me, _BR) && _BR.getRentTo() != null )
        {
            _BR.setState(BRState.LENT);
            _BR.setLRDate(new Date());
            _BR.setLentFrom(_From);
            _BR.setRentTo(_Me);
            BasketList.add(_BR);
            m_Count++;
        }
    }
    
    
    /**
     *
     */
    public void sendBasket()
    {
        for(CBluRay b : BasketList)
        {     
            System.out.println(b.getTitle());
        }  
    }
}
