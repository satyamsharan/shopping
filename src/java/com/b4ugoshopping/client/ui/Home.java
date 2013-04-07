/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.b4ugoshopping.client.ui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
        
/**
 *
 * @author Satyam Sharan<satyam.sharan@hotmail.com>
 */
public class Home extends VerticalPanel{

    public Home() {
        setSpacing(10);
        setStyleName("Home");
        Slider slider=new Slider();
        SearchBar searchBar =new SearchBar(this);
        searchBar.setStyleName("Home-searchBar");
        
        
        Button grocLink = new Button();
        Button loginLink = new Button();
        Button joinLink = new Button();
        
        
        grocLink.setStyleName("Home-grocLink");
        loginLink.setStyleName("Home-loginLink");
        joinLink.setStyleName("Home-joinLink");
        
        
        HorizontalPanel hp = new HorizontalPanel();
        hp.setStyleName("Home-hp");
        
        add(slider);
        add(searchBar);
        
        hp.add(grocLink);
        hp.add(loginLink);
        hp.add(joinLink);
        
        add(hp);
        
        grocLink.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                History.newItem("groceries");
            }
        });
        
        
        loginLink.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                History.newItem("login");
            }
        });
        
        
        joinLink.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                History.newItem("join");
            }
        });
        
    }

}
