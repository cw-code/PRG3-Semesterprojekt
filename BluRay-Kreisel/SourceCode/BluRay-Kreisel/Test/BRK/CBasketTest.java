/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BRK;

import java.util.ArrayList;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Christoph
 */
public class CBasketTest 
{   
    public CBasketTest() 
    {
    }
    
    @Before
    public void setUp() 
    {   
    }
    
    @After
    public void tearDown() 
    {
    }

    /**
     * Test of toBasket method, of class CBasket.
     */
    @Test
    public void testToBasket() 
    {
        System.out.println("toBasket");
        BRK _BRK = new BRK();
        CCustomer _From1 = new CCustomer("Heinz", "Klaus", "19.02.1990", "klaus@gmx.de", "123456", _BRK);
        CCustomer _Me1 = new CCustomer("Heinz", "Klaus", "19.02.1990", "klaus@gmx.de", "123456", _BRK);
        CCustomer _From2 = new CCustomer("Heinz", "Klaus", "19.02.1990", "klaus@gmx.de", "123456", _BRK);
        CCustomer _Me2 = new CCustomer("Heinz", "Klaus", "19.02.1990", "klaus@gmx.de", "123456", _BRK);
        CCustomer _From3 = new CCustomer("Heinz", "Klaus", "19.02.1990", "klaus@gmx.de", "123456", _BRK);
        CCustomer _Me3 = new CCustomer("Heinz", "Klaus", "19.02.1990", "klaus@gmx.de", "123456", _BRK);
        CBluRay _BR1 = new CBluRay( _From1, BRState.OWNER, "Minions", "Kinder", 12);
        CBluRay _BR2 = new CBluRay( _From2, BRState.OWNER, "Minions", "Kinder", 12);
        CBluRay _BR3 = new CBluRay( _From3, BRState.OWNER, "Minions", "Kinder", 12);
        _BR1.setRentTo(_Me1);
        _BR2.setRentTo(_Me2);
        _BR3.setRentTo(_Me3);
        CBasket Basket = new CBasket();
        
        Basket.toBasket(_BRK, _From1, _Me1, _BR1);
        Assert.assertEquals(1, Basket.m_Count);
        Basket.toBasket(_BRK, _From2, _Me2, _BR2);
        Assert.assertEquals(2, Basket.m_Count);
        Basket.toBasket(_BRK, _From3, _Me3, _BR3);
        Assert.assertEquals(3, Basket.m_Count);
        
        
    }

    /**
     * Test of sendBasket method, of class CBasket.
     */
    @Test
    public void testSendBasket() 
    {
        BRK _BRK = new BRK();
        System.out.println("sendBasket");
        CCustomer _From = new CCustomer("Heinz", "Klaus", "19.02.1990", "klaus@gmx.de", "123456", _BRK);
        CCustomer _Me = new CCustomer("Heinz", "Klaus", "19.02.1990", "klaus@gmx.de", "123456", _BRK);
        CBluRay _BR = new CBluRay( _From, BRState.OWNER, "Minions", "Kinder", 12);
        _BR.setRentTo(_Me);
        CBasket Basket = new CBasket();
        Basket.toBasket(_BRK, _From, _Me, _BR);
        Basket.sendBasket(_Me);
        Assert.assertEquals(1, _Me.myBRList.size());
    }
    
}
