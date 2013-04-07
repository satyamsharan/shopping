/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.b4ugoshopping.client.ui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Button;
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
        
        
        grocLink.setStyleName("Home-grocLink");
        
        
        
        add(slider);
        add(searchBar);
        
        add(grocLink);
        
        grocLink.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                History.newItem("groceries");
            }
        });
    }

}
