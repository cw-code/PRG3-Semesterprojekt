/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BRK;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Christoph
 */
public class CCustomerTest {
    
    public CCustomerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of gatherBR method, of class CCustomer.
     */
    @Test
    public void testGatherBR() {
        System.out.println("gatherBR");
        BRK _BRK = new BRK();
        CCustomer _Me = new CCustomer("Heinz", "Klaus", "19.02.1990", "klaus@gmx.de", "123456", _BRK);
        CBluRay _BR1 = new CBluRay( _Me, BRState.OWNER, "Minions", "Kinder", 12);
        CBluRay _BR2 = new CBluRay( _Me, BRState.OWNER, "Transformer", "Action", 12);
        CBluRay _BR3 = new CBluRay( _Me, BRState.OWNER, "Scrubs", "Kinder", 12);
        _Me.gatherBR(_BR1);
        _Me.gatherBR(_BR2);
        _Me.gatherBR(_BR3);
        Assert.assertEquals("Minions", _Me.myBRList.get(0).getTitle());
        Assert.assertEquals("Transformer", _Me.myBRList.get(1).getTitle());
        Assert.assertEquals("Scrubs", _Me.myBRList.get(2).getTitle());
        
    }

    /**
     * Test of deleteBR method, of class CCustomer.
     **/
    @Test
    public void testDeleteBR() {
        System.out.println("deleteBR");
        BRK _BRK = new BRK();
        CCustomer _Me = new CCustomer("Heinz", "Klaus", "19.02.1990", "klaus@gmx.de", "123456", _BRK);
        CBluRay _BR1 = new CBluRay( _Me, BRState.OWNER, "Minions", "Kinder", 12);
        CBluRay _BR2 = new CBluRay( _Me, BRState.OWNER, "Transformer", "Action", 12);
        CBluRay _BR3 = new CBluRay( _Me, BRState.OWNER, "Scrubs", "Kinder", 12);
        _Me.gatherBR(_BR1);
        _Me.gatherBR(_BR2);
        _Me.gatherBR(_BR3);
        Assert.assertEquals(3, _Me.myBRList.size());
        _Me.deleteBR("Transformer");
        Assert.assertEquals(2, _Me.myBRList.size());
        _Me.deleteBR("Scrubs");
        Assert.assertEquals(1, _Me.myBRList.size());
        _Me.deleteBR("Scrubs");
        Assert.assertEquals(1, _Me.myBRList.size());
    }
    
}
