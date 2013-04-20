/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.b4ugoshopping.client;

import com.b4ugoshopping.client.ui.Base;
import com.b4ugoshopping.client.ui.HeaderLink;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Main entry point.
 *
 * @author user
 */
public class ShoppingEntryPoint implements EntryPoint {

    private Base base;
    private HeaderLink link;

    public ShoppingEntryPoint() {
    }

    /**
     * The entry point method, called automatically by loading a module that
     * declares an implementing class as an entry-point
     */
    @Override
    public void onModuleLoad() {
        base = new Base();
        link = new HeaderLink();

        base.setStyleName("ShoppingEntryPoint-base");
        link.setStyleName("ShoppingEntryPoint-link");

        RootPanel.get("headerLink").add(link);
        RootPanel.get("bodyDiv").add(base);


        History.addValueChangeHandler(new ValueChangeHandler<String>() {
            @Override
            public void onValueChange(ValueChangeEvent<String> event) {
                historyChange(event.getValue());
            }
        });


        if (History.getToken() == null || History.getToken().trim().equals("")) {
            History.newItem("home");
        } else {
            historyChange(History.getToken());
        }
    }

    private void historyChange(String token) {
        if (token == null || token.trim().equals("") || token.trim().equals("home")) {
            base.setHome();
        }else if(token.equals("login")){
            base.setLogin();
        }else if(token.equals("join")){
            base.setJoin();
        }else if(token.equals("logout")){
            base.setLogout();
        }else if(token.equals("dashboard")){
            base.setDashboard();
        }else if(token.equals("groceries")){
            base.setDashboard();
        }else if(token.equals("logout")){
            base.setLogout();
        }else if(token.equals("about")){
            base.setAbout();
        }else if(token.equals("copyright")){
            base.setCopyright();
        }else if(token.equals("feedback")){
            base.setFeedback();
        }else if(token.equals("contact")){
            base.setContact();
        }else if(token.equals("")){
            base.setDashboard();
        }
        
    }
}
