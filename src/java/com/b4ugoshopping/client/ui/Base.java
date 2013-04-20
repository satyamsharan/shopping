/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.b4ugoshopping.client.ui;

import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 *
 * @author Satyam Sharan<satyam.sharan@hotmail.com>
 */
public class Base extends VerticalPanel {

    PopUpDialog loginPopUp;
    PopUpDialog joinPopUp;
    PopUpDialog aboutPopUp;
    PopUpDialog copyrightPopUp;
    PopUpDialog feedbackPopUp;
    PopUpDialog contactPopUp;

    public Base() {
        
    }

    public void setHome() {
        Home home = new Home();
        clear();
        add(home);
    }

    public void setLogin() {
        loginPopUp = new PopUpDialog("home","dashboard");
        Login l= new Login();
        l.setDialog(loginPopUp);
        loginPopUp.set("Login", l);
        loginPopUp.setStyleName("HeaderLink-loginPopUp");
        loginPopUp.innerVP.setStyleName("HeaderLink-loginPopUp");
        loginPopUp.show();
    }
    
    public void setJoin() {
        joinPopUp = new PopUpDialog("home","dashboard");
        Join j= new Join();
        j.setDialog(joinPopUp);
        joinPopUp.set("Register With Us", j);
        joinPopUp.setStyleName("HeaderLink-joinPopUp");
        joinPopUp.innerVP.setStyleName("HeaderLink-joinPopUp");
        joinPopUp.show();
    }

    public void setLogout() {
        Cookies.removeCookie("UID");
        History.newItem("home");
        Window.Location.reload();
    }

    public void setDashboard() {
        Dashboard dashboard = new Dashboard();
        clear();
        add(dashboard);
    }
    
    public void setFeedback() {
        feedbackPopUp = new PopUpDialog("home","home");
        Feedback f = new Feedback();
        f.setDialog(feedbackPopUp);
        feedbackPopUp.set("Feedback", f);
        feedbackPopUp.setStyleName("Base-feedbackPopUp");
        feedbackPopUp.innerVP.setStyleName("Base-feedbackPopUp");
        feedbackPopUp.show();
    }
    
}
