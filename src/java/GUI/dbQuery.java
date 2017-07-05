/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//import static GUI.DisplayManagedBean.rs;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import net.java.dev.jaxb.array.StringArray;
import web.DisplayWebService;
import web.DisplayWebService_Service;

/**
 *
 * @author mnanda021
 */
@ManagedBean
@RequestScoped
public class dbQuery {

    private String ISBN;
    private String Title;
    private String EditionNumber;
    private String Copyright;
    private String FirstName;
    private String LastName;
    private String searchkey;
    
    public dbQuery() {
    }
public dbQuery(String ISBN, String Title, String EditionNumber, String Copyright,String FirstName,String LastName,String searchkey) {
        this.ISBN = ISBN;
        this.Title = Title;
        this.EditionNumber = EditionNumber;
        this.Copyright = Copyright;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.searchkey=searchkey;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getEditionNumber() {
        return EditionNumber;
    }

    public void setEditionNumber(String EditionNumber) {
        this.EditionNumber = EditionNumber;
    }

    public String getCopyright() {
        return Copyright;
    }

    public void setCopyright(String Copyright) {
        this.Copyright = Copyright;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getSearchkey() {
        return searchkey;
    }

    public void setSearchkey(String searchkey) {
        this.searchkey = searchkey;
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
    public static ResultSet rs=null;
     public ArrayList<dbQuery> GetBooks(){
        
        ArrayList<dbQuery> list=new ArrayList<>();
       //ConnectionDB();
       //Connection con_new=null;
        try{
            FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest req = (HttpServletRequest) fc.getExternalContext().getRequest();
        HttpSession session = (HttpSession)req.getSession(false);
        //con_new = (Connection)session.getAttribute("conn");
           //rs=JDBCconnection.DisplayData(con_new);
           DisplayWebService_Service ws=new DisplayWebService_Service();
        
         final DisplayWebService service=ws.getDisplayWebServicePort();
        
           List <StringArray > list_new=new ArrayList<>();
         list_new = service.display();
           for(Iterator<StringArray> it=list_new.iterator();it.hasNext();){
              StringArray a=it.next();
          // while(rs.next()){
                dbQuery db=new dbQuery();
              /* db.setISBN(rs.getString("ISBN"));
               db.setTitle(rs.getString("Title"));
                db.setEditionNumber(rs.getString("EditionNumber"));
                db.setCopyright(rs.getString("Copyright"));
                db.setFirstname(rs.getString("FirstName"));
                db.setLastname(rs.getString("LastName"));*/
            db.setISBN(a.getItem().get(0));
            db.setTitle(a.getItem().get(1));
            db.setEditionNumber(a.getItem().get(2));
            db.setCopyright(a.getItem().get(3));
            db.setFirstName(a.getItem().get(4));
            db.setLastName(a.getItem().get(5));
             
               list.add(db);
            }
            return list;
            
        }catch(Exception ex){
            ex.printStackTrace();
            
        }
        
        return list;
    }
     public ArrayList<dbQuery> search(){
        ArrayList<dbQuery> list=new ArrayList<>();
       ConnectionDB();
       
       Connection con_new=null;
       try{
          FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest req = (HttpServletRequest) fc.getExternalContext().getRequest();
        HttpSession session = (HttpSession)req.getSession(false);
           con_new = (Connection)session.getAttribute("conn");
            //String searchkey=this.getSearchkey();
           // PreparedStatement pst=JDBCconnection.query(con_new);
            //pst.setString(1, "%"+this.getSearchkey()+"%");
            
           rs=JDBCconnection.query( con_new,this.getSearchkey());
           //rs=JDBCconnection.DisplayData(con_new);
         while(rs.next()){
           // if(this.searchkey.equals(rs.getString("Title")) || this.searchkey.equals(rs.getString("ISBN"))|| this.searchkey.equals(rs.getString("EditionNumber"))||this.searchkey.equals(rs.getString("Copyright"))||this.searchkey.equals(rs.getString("FirstName"))||this.searchkey.equals(rs.getString("LastName"))){
                dbQuery db=new dbQuery();
              db.setISBN(rs.getString("ISBN"));
               db.setTitle(rs.getString("Title"));
                db.setEditionNumber(rs.getString("EditionNumber"));
                db.setCopyright(rs.getString("Copyright"));
                db.setFirstName(rs.getString("FirstName"));
                db.setLastName(rs.getString("LastName"));
                list.add(db);
           //}
         }
           return list;
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return list;
    }
    /*public ArrayList<DisplayManagedBean> query(){
    ArrayList<DisplayManagedBean> list=new ArrayList<>();
       ConnectionDB();
       Connection con_new=null;
       try{
           FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest req = (HttpServletRequest) fc.getExternalContext().getRequest();
        HttpSession session = (HttpSession)req.getSession(false);
           con_new = (Connection)session.getAttribute("conn");
            //String searchkey=this.getSearchkey();
           // PreparedStatement pst=JDBCconnection.query(con_new);
            //pst.setString(1, "%"+this.getSearchkey()+"%");
            
           rs=JDBCconnection.query(con_new, this.getSearchkey());
           //rs=JDBCconnection.DisplayData(con_new);
         while(rs.next()){
           // if(this.searchkey.equals(rs.getString("Title")) || this.searchkey.equals(rs.getString("ISBN"))|| this.searchkey.equals(rs.getString("EditionNumber"))||this.searchkey.equals(rs.getString("Copyright"))||this.searchkey.equals(rs.getString("FirstName"))||this.searchkey.equals(rs.getString("LastName"))){
                DisplayManagedBean db=new DisplayManagedBean();
              db.setISBN(rs.getString("ISBN"));
               db.setTitle(rs.getString("Title"));
                db.setEditionNumber(rs.getString("EditionNumber"));
                db.setCopyright(rs.getString("Copyright"));
                db.setFirstname(rs.getString("FirstName"));
                db.setLastname(rs.getString("LastName"));
                list.add(db);
           //}
         }
           return list;
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return list;
    }*/
    public void edit(){
        String BookISBN;
        //JDBCconnection.DisplayData();
        ArrayList<dbQuery> list=GetBooks();
        FacesContext fc=FacesContext.getCurrentInstance();
      //  Map<String,String> mapParam=fc.getExternalContext().getInitParameterMap();
        HttpServletRequest rq=(HttpServletRequest) fc.getExternalContext().getRequest();
        //HttpServletRequest rq=(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        BookISBN=rq.getParameter("ISBN");
        for(dbQuery dbQuery:list)
        {
            if(dbQuery.getISBN().equals(BookISBN))
            {
                this.setISBN(dbQuery.getISBN());
               // this.setISBN(BookISBN);
                this.setTitle(dbQuery.getTitle());
                this.setEditionNumber(dbQuery.getEditionNumber());
                this.setCopyright(dbQuery.getCopyright());
                this.setFirstName(dbQuery.getFirstName());
                this.setLastName(dbQuery.getLastName());
                
            }
        }
        
    }
}
