/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BRK;

import java.util.ArrayList;
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
public class BRKTest {
    
    public BRKTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of register method, of class BRK.
     */
    @Test
    public void testregister() 
    {
        BRK instance = new BRK();
        instance.register(instance, "Hans", "Werner", "08.04.1990", "Hanswerner@web.de", "158545454");
        instance.register(instance, "Peter", "Klaus", "08.04.1990", "klaus@web.de", "158545454");
        Assert.assertEquals(2, instance.myCustList.size());
        Assert.assertEquals("Hans", instance.myCustList.get(0).getLastName());
    }

    /**
     * Test of passwordToHash method, of class BRK.
     */
    @Test
    public void testPasswordToHash() {
        System.out.println("passwordToHash");
        String _Password1 = "klaus9477abc";
        BRK instance = new BRK();
        String expResult1 = "85d56aff24efd81acbbf88265a20c334";
        String result1 = instance.passwordToHash(_Password1);
        assertEquals(expResult1, result1);
        
        String _Password2 = "troelfheinmogk22874";
        String expResult2 = "28d5159e833c23e3fa8f491526e5a764";
        String result2 = instance.passwordToHash(_Password2);
        assertEquals(expResult2, result2);
        
        // ä ö ü funktionieren nicht !!!
    }

    /**
     * Test of login method, of class BRK.
     */
    @Test
    public void testLogin() 
    {
        BRK instance = new BRK();
        instance.register(instance, "Hans", "Werner", "08.04.1990", "Hanswerner@web.de", "158545454");
        instance.register(instance, "Peter", "Klaus", "08.04.1990", "klaus@web.de", "158545454cvbxbx");
        
        CCustomer result = instance.login(instance, "Hanswerner@web.de", "158545454");
        
        Assert.assertEquals(instance.myCustList.get(0), result);
    }

    /**
     * Test of showAllBR method, of class BRK.
     */
    @Test
    public void testShowAllBR() {
        System.out.println("showAllBR");
        
        BRK instance = new BRK();
       
        instance.register(instance, "Hans", "Werner", "08.04.1990", "Hanswerner@web.de", "158545454");
        instance.register(instance, "Peter", "Klaus", "08.04.1990", "klaus@web.de", "158545454");
        instance.register(instance, "Klaus", "Werner", "08.04.1990", "werner@web.de", "158545454");
        instance.register(instance, "Heinz", "Klaus", "08.04.1990", "heinz@web.de", "158545454");
        CBluRay BR1 = new CBluRay( instance.myCustList.get(0), BRState.OWNER, "Minions", "Kinder", 12);
        CBluRay BR2 = new CBluRay( instance.myCustList.get(1), BRState.OWNER, "Transformers", "Kinder", 12);
        CBluRay BR3 = new CBluRay( instance.myCustList.get(2), BRState.OWNER, "EscapePlan", "Kinder", 12);
        CBluRay BR4 = new CBluRay( instance.myCustList.get(3), BRState.OWNER, "Scrubs", "Kinder", 12);
        
        instance.myCustList.get(0).gatherBR(BR1);
        instance.myCustList.get(1).gatherBR(BR2);
        instance.myCustList.get(2).gatherBR(BR3);
        instance.myCustList.get(3).gatherBR(BR4);
        
        int result1 = instance.myCustList.size();
        Assert.assertEquals(4, result1);
        
        Assert.assertEquals("Minions", instance.myCustList.get(0).myBRList.get(0).getTitle());
        Assert.assertEquals("Transformers", instance.myCustList.get(1).myBRList.get(0).getTitle());
        Assert.assertEquals("EscapePlan", instance.myCustList.get(2).myBRList.get(0).getTitle());
        Assert.assertEquals("Scrubs", instance.myCustList.get(3).myBRList.get(0).getTitle());
        
        
        ArrayList<CBluRay> result2 = instance.showAllBR(instance.myCustList.get(0));
        Assert.assertEquals(3, result2.size());
        
    }

    /**
     * Test of searchBR method, of class BRK.
     */
    @Test
    public void testSearchBR() {
        System.out.println("searchBR");
        
        BRK instance = new BRK();
        
        instance.register(instance, "Hans", "Werner", "08.04.1990", "Hanswerner@web.de", "158545454");
        instance.register(instance, "Peter", "Klaus", "08.04.1990", "klaus@web.de", "158545454");
        instance.register(instance, "Klaus", "Werner", "08.04.1990", "werner@web.de", "158545454");
        instance.register(instance, "Heinz", "Klaus", "08.04.1990", "heinz@web.de", "158545454");
        CBluRay BR1 = new CBluRay( instance.myCustList.get(0), BRState.OWNER, "Minions", "Kinder", 12);
        CBluRay BR2 = new CBluRay( instance.myCustList.get(1), BRState.OWNER, "Transformers", "Kinder", 12);
        CBluRay BR3 = new CBluRay( instance.myCustList.get(2), BRState.OWNER, "EscapePlan", "Kinder", 16);
        CBluRay BR4 = new CBluRay( instance.myCustList.get(3), BRState.OWNER, "Scrubs", "Kinder", 12);
        
        instance.myCustList.get(0).gatherBR(BR1);
        instance.myCustList.get(1).gatherBR(BR2);
        instance.myCustList.get(2).gatherBR(BR3);
        instance.myCustList.get(3).gatherBR(BR4);
        
        ArrayList<CBluRay> result = instance.searchBR(instance.myCustList.get(1),"Minions");
        assertEquals(1, result.size());
        
        result = instance.searchBR(instance.myCustList.get(0), "Kinder");
        assertEquals(3, result.size());
        
    }

    /**
     * Test of checkFSK method, of class BRK.
     */
    @Test
    public void testCheckFSK() {
        System.out.println("checkFSK");
        BRK instance = new BRK();
        
        CCustomer Me1 = new CCustomer("Heinz", "Klaus", "19.02.1990", "klaus@gmx.de", "123456", instance);
        CBluRay BR1 = new CBluRay( Me1, BRState.OWNER, "Minions", "Kinder", 12);
        
        Boolean expResult = true;
        Boolean result = instance.checkFSK(Me1, BR1);
        assertEquals(expResult, result);
        
        CCustomer Me2 = new CCustomer("Heinz", "Klaus", "19.02.2015", "klaus@gmx.de", "123456", instance);
        CBluRay BR2 = new CBluRay( Me2, BRState.OWNER, "Minions", "Kinder", 12);
        
        expResult = false;
        result = instance.checkFSK(Me2, BR2);
        assertEquals(expResult, result);
    }
    
}
