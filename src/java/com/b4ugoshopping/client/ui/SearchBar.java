/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.b4ugoshopping.client.ui;

import com.b4ugoshopping.client.ServerService;
import com.b4ugoshopping.client.ServerServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 *
 * @author Satyam Sharan<satyam.sharan@hotmail.com>
 */
public class SearchBar extends VerticalPanel {

    SuggestBox productBox;
    SuggestBox locationBox;
    Button searchButton;

    Home home;
    
    public SearchBar(Home home1) {
        this.home=home1;
        VerticalPanel vp = new VerticalPanel();
        vp.setStyleName("SearchBar-vp");
        
        productBox = new SuggestBox();
        locationBox = new SuggestBox();
        searchButton = new Button("search");

        
        productBox.setStyleName("SearchBar-productBox");
        locationBox.setStyleName("SearchBar-locationBox");
        searchButton.setStyleName("SearchBar-searchButton");

        
        productBox.getElement().setAttribute("placeholder", "Product...");
        locationBox.getElement().setAttribute("placeholder", "Locality...");
        
        vp.add(productBox);
        vp.add(locationBox);
        vp.add(searchButton);

        vp.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER); //Neds  to be changed
        
        add(vp);
        
        searchButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                History.newItem("searchresults", true);
                getService().myMethod("Hi", new AsyncCallback<String>() {

                    @Override
                    public void onFailure(Throwable caught) {
                        Window.alert(caught.toString());
                    }

                    @Override
                    public void onSuccess(String result) {
                        //Window.alert(result);
                        home.clear();
                        home.add(new Image("images/loading.gif"));
                    }
                });
            }
        });
        

    }
    
        public static ServerServiceAsync getService() {
        // Create the client proxy. Note that although you are creating the
        // service interface proper, you cast the result to the asynchronous
        // version of the interface. The cast is always safe because the
        // generated proxy implements the asynchronous interface automatically.

        return GWT.create(ServerService.class);
    }
}
