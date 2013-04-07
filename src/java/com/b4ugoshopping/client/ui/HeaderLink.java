/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.b4ugoshopping.client.ui;

import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;

/**
 *
 * @author Satyam Sharan<satyam.sharan@hotmail.com>
 */
public class HeaderLink extends HorizontalPanel {
    private Hyperlink city = new Hyperlink("New Delhi", "city");
    private Hyperlink login = new Hyperlink("Login", "login");
    private Hyperlink join = new Hyperlink("Join Us", "join");
    private Hyperlink home = new Hyperlink("Home", "home");
    private Hyperlink dashboard = new Hyperlink("Dashboard", "dashboard");
    private Hyperlink logout = new Hyperlink("Logout", "logout");
    //private Hyperlink support = new Hyperlink("Customer Support", "support");

    public HeaderLink() {

        city.setStyleName("HeaderLink-city");
        home.setStyleName("HeaderLink-home");
        login.setStyleName("HeaderLink-login");
        join.setStyleName("HeaderLink-join");
        dashboard.setStyleName("HeaderLink-dashboard");
        logout.setStyleName("HeaderLink-logout");
        //support.setStyleName("HeaderLink-support");
        
        
        //add(city);
        add(home);
        if(Cookies.getCookie("UID")!=null){
            add(dashboard);
            add(logout);
        }else{
            add(join);
            add(login);
        }
        //add(support);

    }
}
