package memepost.dataConnector.util;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
    public static Connection conn = null;
   
    public static void dbConnect() {
        try{
            conn = DriverManager.getConnection(memepost.MemePost.serverURL, memepost.MemePost.serverAdmin,
                    memepost.MemePost.serverPassword);
            System.out.println("connected to db");
        }catch(SQLException e){
            System.err.println(e);
        }
    }
   
    public static void shutdown() throws SQLException {
        if(conn!= null) {
            conn.close();
            System.out.println("connection is shut down");
        }
    }
    
    public static ResultSet dbExecuteQuery(final String query) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        ResultSet resultSet = null;
        try {
            dbConnect();
            System.out.println("Select statement: " + query + "\n");
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery(query);
 
            
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeQuery operation : " + e);
            throw e;
        } 
            //Close connection
            shutdown();
        
        //Return CachedRowSet
        return resultSet;
    }
    //tym wykonujemy wczytywanie naszego uzytkownika na pomoca argumentow przeslanych w adds a query to zapytanie z ? do prepared statemnt
    public static ResultSet dbExecutePreparedStatement(final String[] adds,final String query) throws SQLException,ClassNotFoundException {
        dbConnect();
        PreparedStatement stmt = null;
        ResultSet rs = null;
         stmt = conn.prepareStatement(query);
        
        for(int i = 0;i<adds.length;i++){
            stmt.setString(i+1, adds[i]);
        }
        
        System.out.println(stmt.toString());
        rs = stmt.executeQuery();
      
        return rs;
    }
    
    
    //zwraca true jesli sie udalo dodac 
    public static boolean dbExecuteUpdate(final String[] adds,final String query) throws SQLException, ClassNotFoundException {
        int i = 0;
        PreparedStatement stmt = null;
        try {
            dbConnect();
            
            stmt = conn.prepareStatement(query);
            for(int j = 0;j<adds.length;j++){
            stmt.setString(j+1, adds[j]);
            }
            System.out.println(stmt.toString());
            i = stmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeUpdate operation : " + e);
            throw e;   
        }finally{
            if(i == 0) return false;
        }
        shutdown();
        if(i > 0){
        return true;
        }else return false;
    }
    
}
