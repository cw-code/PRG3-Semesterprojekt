package Testpackage;

import java.util.*;
import junit.framework.TestCase;

import BRK.CCustomer;
/**
 *
 * @author Christoph
 */
public class CCustumer_Test extends TestCase 
{    
  CCustomer customer1;
  
  @Override public void setUp() throws Exception
  {
      customer1 = new CCustomer("Hans", "Hans", "12.06.1960", "hans@gmx.de", "123456");
      
      //assertEquals("Anfangs ist die Liste leer", null, customer1.printList(customer1.))
  }
}
