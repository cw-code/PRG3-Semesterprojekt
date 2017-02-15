/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BRK;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

enum BRState 
{ 
    OWNER, LENT, RENT; 
}

/**
 *
 * @author Christoph
 */
public class CCustomerTest {
    
    private CCustomer wagner;
    private CBluRay minions;
    private CBluRay HouseOfCards;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() 
    {
        wagner = new CCustomer("Wagner", "Christoph", "06.09.1994", "cw@web.de", "123456", myBRK);
        minions = new CBluRay(wagner, BRState.OWNER , "Minions", "Kinder", 12);
        HouseOfCards = new CBluRay(wagner, BRState.OWNER , "HouseOfCards", "Politik-Drama", 16);
    }
    
    @After
    public void tearDown() 
    {
        
    }

    @Test
    public void testGatherBluRay() 
    {
        wagner.gatherBluRay(minions);
        wagner.gatherBluRay(HouseOfCards);
        
        wagner.printList(wagner.myBluRayList);
        
    }
    
    @Test
    public void testdeleteBluRay()
    {
        wagner.deleteBluRay("HouseOfCards");
        
        wagner.printList(wagner.myBluRayList);
        
    }
    
}
