/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.b4ugoshopping.server;

import com.b4ugoshopping.client.ServerService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.sql.ResultSet;

/**
 *
 * @author Satyam Sharan<satyam.sharan@hotmail.com>
 */
public class ServerServiceImpl extends RemoteServiceServlet implements ServerService {

    public String myMethod(String s) {
        // Do something interesting with 's' here on the server.
        return "Server says: " + s;
    }

    @Override
    public String register(String fName, String lName, String sex, String email, String password, String mobile) {
        try {
            String query = "insert into User values(null ,1 ,'" + email + "','" + password + "','" + fName + "','" + lName + "'," + (sex.equals("Male")?"0":"1") + ",'" + mobile + "')";
            System.out.println(query);
            
            Database db = new Database();
            db.startDatabase();

            db.updateQuery(query);
            db.closeDatabase();
            return "success";
        } catch (Exception e) {
            System.out.println(e.toString());
            return "Something went wrong. Please try again";
        }

        
    }

    @Override
    public String login(String email, String password) {
         try {
            String query = "select ID  from User where email='"+email+"' and password='"+password+"'";
            System.out.println(query);
            
            Database db = new Database();
            db.startDatabase();
            
            ResultSet rs = db.executeQuery(query);
            
            if(rs!=null){
                while(rs.next()){
                    return rs.getString(1);
                }   
            }
            db.closeDatabase();
            return "-1";
        } catch (Exception e) {
            System.out.println(e.toString());
            return "-2";
        }
    }
}
