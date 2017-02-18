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
public class CNewsletter {
    Map<String, List<CCustomer>> map = new HashMap<>();
    
    
    /**
     * puts a customer to a map of newsletter-genres
     * @param _Me
     * @param _Genre
     */
    public void putToNewsletter(CCustomer _Me, String _Genre)
    {
        List<CCustomer> myCustList = map.get( _Genre );
        
        if( myCustList == null ) {
            myCustList = new ArrayList<CCustomer>();
            map.put( _Genre, myCustList );
        }
        
        myCustList.add(_Me);      
    }
    
    
    /**
     * deletes a customer from a map of newsletter-genres
     * @param _Me
     * @param _Genre
     */
    public void deleteFromNewsletter (CCustomer _Me, String _Genre)
    {
        List<CCustomer> myCustList = map.get( _Genre );
        
        if( myCustList != null ) {
            myCustList.remove(_Me);
        }        
    }
    
    
    /**
     * sends a newsletter to all registered customer to a newsletter-genre
     * @param _Genre
     */
    public void sendNewsletter(String _Genre)
    {
        // TODO
    }
    
}
