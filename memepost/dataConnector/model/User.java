package memepost.dataConnector.model;




import java.sql.Date;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
    final private StringProperty login = new SimpleStringProperty();
    final private StringProperty email = new SimpleStringProperty();
    final private StringProperty password = new SimpleStringProperty();
    final private IntegerProperty score = new SimpleIntegerProperty();
    final private IntegerProperty id = new SimpleIntegerProperty();
    final private ObjectProperty<Date> date = new SimpleObjectProperty();
    
    //////////////////////////////
    ///////login
    public void setLoginProperty(String Login){
        login.set(Login);
    }
    public StringProperty getLoginProperty(){
        return login;
    }
    public String getLogin(){
        return login.get();
    }
    ////////////////////email
    public void setEmailProperty(String Email){
        email.set(Email);
    }
    public StringProperty getEmailProperty(){
        return email;
    }
    public String getEmail(){
        return email.get();
    }
    //////////////////password
    public void setPasswordProperty(String Password){
        login.set(Password);
    }
    public StringProperty getPasswordProperty(){
        return password;
    }
    public String getPassword(){
        return password.get();
    }
    ////////////////////score
    public void setScoreProperty(int Score){
        score.set(Score);
    }
    public IntegerProperty getScoreProperty(){
        return score;
    }
    public int getScore(){
        return score.get();
    }
    //////////////////////id
    public void setIdProperty(int Id){
        id.set(Id);
    }
    public IntegerProperty getIdProperty(){
        return id;
    }
    public int getId(){
        return id.get();
    }
    ////////////date
    public void setDateProperty(Date d){
      date.set(d);
    }
    public ObjectProperty<Date> getDateProperty(){
        return date;
    }
    public Date getDate(){
        return date.get();
    }
    /////////////////////////////////
    public User(){}
    public User(final String name,final String em, final String pass){
        login.set(name);
        email.set(em);
        password.set(pass);
        score.set(0);
    }
    public User(final String name,final String em, final String pass,int scor){
        login.set(name);
        email.set(em);
        password.set(pass);
        score.set(scor);
    }
    
    
}
