/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BRK;

import java.util.*;
import java.security.*;
import java.text.*;

/**
 *
 * @author Marco
 */
public class BRK {        
    
    // List of all Customers
    public ArrayList<CCustomer> myCustList = new ArrayList<>();
    
    // Newsletter Object
    CNewsletter myNewsletter = new CNewsletter();
    
    /**
     * register an user to BRK, returns true/ false if succesfull
     * @param _BRK
     * @return
     */
    public Boolean register(BRK _BRK)
    {
        Boolean succ = false;
        
        Scanner register = new Scanner(System.in);

        String lastName;
        String preName;
        String birthday;
        String email;
        String password;

        System.out.println("REG: lastName: ");
        lastName = register.nextLine();
        
        System.out.println("REG: preName: ");
        preName = register.nextLine();
        
        System.out.println("REG: birthday: ");
        birthday = register.nextLine();
        
        System.out.println("REG: email: ");
        email = register.nextLine();
        
        System.out.println("REG: password: ");
        password = register.nextLine();
        
        if (lastName != null && preName != null && birthday != null && email != null && password != null)
        {
            CCustomer myUser = new CCustomer(lastName, preName, birthday, email, password, _BRK);
            _BRK.myCustList.add(myUser);
            succ = true;
        }  
        
        return succ;
        
    }
    
    
    /**
     * generates a hash out of the password, returns the hash *copy-paste from inet*
     * @param _Password
     * @return
     */
    public String passwordToHash(String _Password)
    {
        String password = _Password;
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        }
        
        return generatedPassword;
        
    }
    
    
    /**
     * login a user if he/ she exists, returns a user-object
     * @param _BRK
     * @return
     */
    public CCustomer login(BRK _BRK)
    {
        Scanner login = new Scanner(System.in);

        String email;
        String password;
        CCustomer myUserObject = null;

        System.out.println("LOGIN email: ");
        email = login.nextLine();

        System.out.println("LOGIN password: ");
        password = login.nextLine();
        
        for(CCustomer c : this.myCustList)
        {
            if (c.getEMail().equalsIgnoreCase(email) && c.getPassword().equals(_BRK.passwordToHash(password)))
            {
                myUserObject = c;
                break;
            }
        }
        
        if(myUserObject != null) 
            System.out.println("You are logged in as: " + myUserObject.getLastName() + ", " + myUserObject.getPreName());
        else
            System.out.println("Bad email or password!");

        return myUserObject;
        
    }
    
    
    /**
     * generates a list of all BR in BRK except mine
     * @param _Me
     * @return
     */
    public ArrayList<CBluRay> showAllBR(CCustomer _Me)
    {
        ArrayList<CBluRay> retAllBRList = new ArrayList();
        // List all BR in BRK
        for(CCustomer c : this.myCustList)
        {
            if (c.getEMail().equalsIgnoreCase(_Me.getEMail()))
            {
                for(CBluRay b : c.myBRList)
                {
                    retAllBRList.add(b);
                }  
            }
            
        }
        
        return retAllBRList;
        
    }
    
    
    /**
     * searches a BR in BRK with specific title, genre or FSK, returns a BR-list
     * @param _Arg
     * @return
     */
    public ArrayList<CBluRay> searchBR(CCustomer _Me, String _Arg)
    {
        ArrayList<CBluRay> retSearchBR = new ArrayList();
        
        for(CBluRay b : this.showAllBR(_Me))
        {
            if (b.getTitle().equalsIgnoreCase(_Arg) || b.getGenre().equalsIgnoreCase(_Arg) || b.getFSK() == Integer.parseInt(_Arg) )
            {
                retSearchBR.add(b);
            }
        }
        
        return retSearchBR;
        
    }
    
    
    /**
     * checks FSK <==> age of user, returns true/ false
     * @param _Me
     * @param _BR
     * @return
     */
    public Boolean checkFSK(CCustomer _Me, CBluRay _BR)
    {
        Boolean succ = false;
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        
        try 
        {
            if (new Date().getYear() - df.parse(_Me.getBirthday()).getYear() >= _BR.getFSK())
                succ = true;
        } 
        catch (ParseException e) 
        {
            e.printStackTrace();
        }
        
        return succ;
        
    }
    
    
    /**
     * render a list of BR-objects
     * @param _List
     */
    public void printBRList(ArrayList<CBluRay> _List){
        for(CBluRay b : _List)
        {
            System.out.println(b.getTitle());
        }
    }
    
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
        * @param args the command line arguments
        */
        
        BRK myBRK = new BRK();
        
        // TestUser
        CCustomer myUser = new CCustomer("Wagner", "Christoph", "01.01.1995", "ch.wa@fh.de", "123456", myBRK);
        myBRK.myCustList.add(myUser);
        
        CCustomer mySessionUser = null; 
        
        Scanner menu = new Scanner(System.in);
        
        System.out.println("Treffen Sie eine Auswahl: ");
        System.out.println("1: Registrieren");
        System.out.println("2: Einloggen");
        System.out.println("e: Beenden");
        
        String choice = menu.nextLine();
        
        switch (choice)
        {
            
            case "1":
                while (!myBRK.register(myBRK));
            
            case "2":
                mySessionUser = myBRK.login(myBRK);
                break;
                
            case "e":
                System.exit(0);
                
        }
        
        // create test-bluray
        CBluRay myBR = new CBluRay( myUser, BRState.OWNER, "Batman", "Action", 12);
        myBR= new CBluRay( myUser, BRState.OWNER, "Minions", "Trickfilm", 0);
        myBR = new CBluRay( mySessionUser, BRState.OWNER, "Titanic", "Drama", 0);
        myBR = new CBluRay( mySessionUser, BRState.OWNER, "Titanic", "Drama", 0);
        
        myBRK.checkFSK(mySessionUser, myBR);
        
        // test add to newsletter
        //myBRK.myNewsletter.putToNewsletter(mySessionUser, "Drama");
        
        // test search funtion
        //myBRK.printBRList(myBRK.searchBR( mySessionUser, "12"));

        // test show all
        //myBRK.printBRList(myBRK.showAllBR(myUser));
        
        // test delete BR
        //mySessionUser.deleteBR("Minions");

        // test toBasket Basket
        //mySessionUser.myBasket.toBasket(myBRK, myBR.getOwner(), mySessionUser, myBR);
        //myBRK.printBRList(mySessionUser.myBasket.BasketList);

        // test send Basket
        //mySessionUser.myBasket.sendBasket();
        
        // TO-DO
        // Warenkorb absenden, damit BluRay meiner Liste mit Attribut ausgeliehen hizufügen
        // BluRay Rückgabe
        // Newsletter
    }
    
}
