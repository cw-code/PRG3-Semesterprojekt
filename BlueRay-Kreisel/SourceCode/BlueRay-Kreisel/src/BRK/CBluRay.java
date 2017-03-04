/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BRK;
import java.util.*;

// OWNER: this is my BR
// LENT: i borrowed my BR to somebody
// RENT: i borrowed a BR from somebody
enum BRState 
{ 
    OWNER, LENT, RENT; 
}

/**
 *
 * @author Marco
 */
public class CBluRay {
    private CCustomer m_Owner;
    private CCustomer m_LentFrom = null;
    private CCustomer m_RentTo = null;
    private Date m_LRDate = null;
    private BRState m_State;
    private String m_Title;
    private String m_Genre;
    private int m_FSK;
    
    public CBluRay( CCustomer _Owner, BRState _State, String _Title, String _Genre, int _FSK ){
        this.m_Owner = _Owner;
        this.m_State = _State;
        this.m_Title = _Title;
        this.m_Genre = _Genre;
        this.m_FSK = _FSK;
        _Owner.gatherBR(this);
    }
    
    
    public CCustomer getOwner() {
        return m_Owner;
    }

    public void setOwner(CCustomer _Owner) {
        this.m_Owner = _Owner;
    }
    
    public CCustomer getLentFrom() {
        return m_LentFrom;
    }

    public void setLentFrom(CCustomer _LentFrom) {
        this.m_LentFrom = _LentFrom;
    }

    public CCustomer getRentTo() {
        return m_RentTo;
    }

    public void setRentTo(CCustomer _RentTo) {
        this.m_RentTo = _RentTo;
    }

    public Date getLRDate() {
        return m_LRDate;
    }

    public void setLRDate(Date _LRDate) {
        this.m_LRDate = _LRDate;
    }

    public BRState getState() {
        return m_State;
    }

    public void setState(BRState _State) {
        this.m_State = _State;
    }

    public String getTitle() {
        return m_Title;
    }

    public void setTitle(String m_Title) {
        this.m_Title = m_Title;
    }

    public String getGenre() {
        return m_Genre;
    }

    public void setGenre(String m_Genre) {
        this.m_Genre = m_Genre;
    }

    public int getFSK() {
        return m_FSK;
    }

    public void setFSK(int m_FSK) {
        this.m_FSK = m_FSK;
    }

    
}
