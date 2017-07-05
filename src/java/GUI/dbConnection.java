/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.Connection;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mnanda021
 */
@ManagedBean
@RequestScoped
public class dbConnection {

    /**
     * Creates a new instance of dbConnection
     */
    public dbConnection() {
    }
    public void ConnectionDB(){
        Connection con=null;
        try{
            con=JDBCconnection.DBConnection();
        HttpSession sess=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            sess.setAttribute("conn", con);
        }  
        catch(Exception ex){
                ex.printStackTrace();
                    }
    
    }
}
