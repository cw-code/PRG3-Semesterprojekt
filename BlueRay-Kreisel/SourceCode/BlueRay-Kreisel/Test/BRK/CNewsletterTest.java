/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BRK;

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
public class CNewsletterTest {
    
    public CNewsletterTest() {
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
     * Test of putToNewsletter method, of class CNewsletter.
     */
    @Test
    public void testPutToNewsletter() {
        System.out.println("putToNewsletter");
        BRK _BRK = new BRK();
        CCustomer Cust1 = new CCustomer("Klaus", "Klaus", "19.02.1990", "klaus@gmx.de", "123456", _BRK);
        CCustomer Cust2 = new CCustomer("Dieter", "Dieter", "19.02.1990", "klaus@gmx.de", "123456", _BRK);
        CCustomer Cust3 = new CCustomer("Hans", "Hans", "19.02.1990", "klaus@gmx.de", "123456", _BRK);
        CCustomer Cust4 = new CCustomer("Werner", "Werner", "19.02.1990", "klaus@gmx.de", "123456", _BRK);
        CCustomer Cust5 = new CCustomer("Magarete", "Magarete", "19.02.1990", "klaus@gmx.de", "123456", _BRK);
        
        CNewsletter Newsletterlist = new CNewsletter();
        Newsletterlist.putToNewsletter(Cust1, "Action");
        Newsletterlist.putToNewsletter(Cust2, "Action");
        Assert.assertEquals(1, Newsletterlist.map.size());
        
        Newsletterlist.putToNewsletter(Cust3, "Drama");
        Assert.assertEquals(2, Newsletterlist.map.size());
        
        Newsletterlist.putToNewsletter(Cust4, "Heimatfilme");
        Newsletterlist.putToNewsletter(Cust5, "Heimatfilme");
        Assert.assertEquals(3, Newsletterlist.map.size());
        
        Assert.assertEquals(2,Newsletterlist.map.get("Action").size());
        Assert.assertEquals(1,Newsletterlist.map.get("Drama").size());
        Assert.assertEquals(2,Newsletterlist.map.get("Heimatfilme").size());
    }

    /**
     * Test of deleteFromNewsletter method, of class CNewsletter.
     */
    @Test
    public void testDeleteFromNewsletter() {
        System.out.println("deleteFromNewsletter");
        BRK _BRK = new BRK();
        CCustomer Cust1 = new CCustomer("Klaus", "Klaus", "19.02.1990", "klaus@gmx.de", "123456", _BRK);
        CCustomer Cust2 = new CCustomer("Dieter", "Dieter", "19.02.1990", "klaus@gmx.de", "123456", _BRK);
        CCustomer Cust3 = new CCustomer("Hans", "Hans", "19.02.1990", "klaus@gmx.de", "123456", _BRK);
        CCustomer Cust4 = new CCustomer("Werner", "Werner", "19.02.1990", "klaus@gmx.de", "123456", _BRK);
        CCustomer Cust5 = new CCustomer("Magarete", "Magarete", "19.02.1990", "klaus@gmx.de", "123456", _BRK);
        
        CNewsletter Newsletterlist = new CNewsletter();
        Newsletterlist.putToNewsletter(Cust1, "Action");
        Newsletterlist.putToNewsletter(Cust2, "Action");
        Newsletterlist.putToNewsletter(Cust3, "Drama");
        Newsletterlist.putToNewsletter(Cust4, "Heimatfilme");
        Newsletterlist.putToNewsletter(Cust5, "Heimatfilme");
        
        Newsletterlist.deleteFromNewsletter(Cust1, "Action");
        Assert.assertEquals(1,Newsletterlist.map.get("Action").size());
        Newsletterlist.deleteFromNewsletter(Cust3, "Drama");
        Assert.assertEquals(0,Newsletterlist.map.get("Drama").size());
        Newsletterlist.deleteFromNewsletter(Cust1, "Heimatfilme");
        Assert.assertEquals(2,Newsletterlist.map.get("Heimatfilme").size());
    }
    
}
