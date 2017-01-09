/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BRK;

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
    private BRState m_State;
    private String m_Titel;
    private String m_Genre;
    private int m_FSK;
    
    public CBluRay( CCustomer _Owner, BRState _State, String _Titel, String _Genre, int _FSK ){
        this.m_Owner = _Owner;
        this.m_State = _State;
        this.m_Titel = _Titel;
        this.m_Genre = _Genre;
        this.m_FSK = _FSK;
        _Owner.gatherBluRay(this);
    }

    public String getTitel() {
        return m_Titel;
    }

    public void setTitel(String m_Titel) {
        this.m_Titel = m_Titel;
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
