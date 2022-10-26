/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Account;

/**
 *
 * @author win
 */
public class AccountDBContext extends DBContext {

    public Account check(String username, String password) {
        
        try {
        String sql = "SELECT username,displayname FROM Account WHERE username = ?\n"
                    + "AND [password] = ?";
            PreparedStatement stm= connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs= stm.executeQuery();
            while(rs.next()){
                Account account= new Account();
                account.setUsername(username);
                account.setDisplayname(rs.getString("displayname"));
                return account;
            }
        } catch (SQLException e) {

        }
        return null;
    }

    @Override
    public ArrayList list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
