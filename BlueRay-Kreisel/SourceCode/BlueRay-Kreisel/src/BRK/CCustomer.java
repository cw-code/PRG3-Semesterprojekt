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
public class CCustomer {
    private String m_LastName;
    private String m_PreName;
    private String m_Birthday;
    private String m_EMail;
    private String m_Password;
    
    // List of my own bluRays
    ArrayList<CBluRay> myBluRayList = new ArrayList<>();
   
    // Basket of Customer
    CBasket myBasket;
    
    public CCustomer(String _LastName, String _PreName, String _Birthday, String _EMail, String _Password, BRK _BRK){
        this.m_LastName = _LastName;
        this.m_PreName = _PreName;
        this.m_Birthday = _Birthday;
        this.m_EMail = _EMail;
        this.m_Password = _BRK.passwordToHash(_Password);
    }

    public String getPassword() {
        return m_Password;
    }

    public void setPassword(String m_Password) {
        this.m_Password = m_Password;
    }
    
    public String getLastName(){
        return this.m_LastName;
    }

    public void setLastName(String m_LastName) {
        this.m_LastName = m_LastName;
    }

    public String getPreName() {
        return m_PreName;
    }

    public void setPreName(String m_PreName) {
        this.m_PreName = m_PreName;
    }

    public String getEMail() {
        return m_EMail;
    }

    public void setEMail(String m_EMail) {
        this.m_EMail = m_EMail;
    }

    public String getBirthday() {
        return m_Birthday;
    }

    public void setBirthday(String m_Birthday) {
        this.m_Birthday = m_Birthday;
    }
    
    public void printList(ArrayList<CBluRay> _List){
        for(CBluRay b : _List)
        {
            System.out.println(b.getTitle());
        }
    }
    
    // gather the bluray _BluRay to list myBluRayList
    public void gatherBluRay(CBluRay _BluRay){
        this.myBluRayList.add(_BluRay);
    }
    
    // delete the bluray (m_title) _BluRay from list myBluRayList
    public void deleteBluRay(String _Title){
        CBluRay element = null;
        
        for(CBluRay b : this.myBluRayList)
        {
            if (b.getTitle().equals(_Title)) 
            {
                element = b;
                break;
            }
        }
        this.myBluRayList.remove(element);
    }
}
