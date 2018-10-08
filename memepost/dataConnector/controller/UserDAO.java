/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memepost.dataConnector.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import memepost.dataConnector.util.DBUtil;
import memepost.MemePost;
import memepost.dataConnector.model.User;

public class UserDAO {
    //logowanie
    public static User loginToSystem(final String name,final String pass) throws SQLException, ClassNotFoundException{
        String query = "select * from user where login = ? and password = ?";
        String[] data = {name,pass};
        
        ResultSet rs = DBUtil.dbExecutePreparedStatement(data,query);
        User user = getUserFromResultSet(rs);
        return user;
    }
    //wczytujemy uzytownika z resultatu
     private static User getUserFromResultSet(final ResultSet rs) throws SQLException{
        User user = null;
        if (rs.next()) {
            user = new User();
            user.setLoginProperty(rs.getString("login"));
            user.setPasswordProperty(rs.getString("password"));
            user.setEmailProperty(rs.getString("email"));
            user.setIdProperty(rs.getInt("id"));
            user.setScoreProperty(rs.getInt("score"));
            user.setDateProperty(rs.getDate("create_date"));
        }
        DBUtil.shutdown();
        return user;
    }
     
    public static boolean registerUser(final String name,
            final String pass, final String email) throws SQLException, ClassNotFoundException{
        String query = "insert into user (login, email, password) values(?, ?, ?)";
        String[] Data = {name,email,pass};
        
        boolean result = DBUtil.dbExecuteUpdate(Data, query);
        return result;
    }
}
