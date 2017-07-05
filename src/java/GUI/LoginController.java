/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.faces.application.FacesMessage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mnanda021
 */
@ManagedBean
@SessionScoped
public class LoginController {
    private String username;
   private String password;
   
    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String login(){
        if(username.equals("Mahananda") && password.equals("Manu123")){
            HttpSession sess=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            sess.setAttribute("username", username);
            return "index";
        }
        else{
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return "login";
        }
    }
    public String logout(){
        HttpSession sess=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            sess.invalidate();
            return "mainPage";
    }
    public String session_check(){
     
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest req = (HttpServletRequest) fc.getExternalContext().getRequest();
        HttpSession session = (HttpSession)req.getSession(false);
        if(session.getAttribute("username") == null)
        {
            try {
            // return "Login";
                FacesContext.getCurrentInstance().getExternalContext().redirect("../login.xhtml");
             } 
            
            catch (IOException ex) {
             Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
           return (String)session.getAttribute("username");
        }
        return null;
     }
}
