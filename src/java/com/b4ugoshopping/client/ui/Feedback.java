/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.b4ugoshopping.client.ui;

import com.b4ugoshopping.client.PopUpWidget;
import com.b4ugoshopping.client.ServerService;
import com.b4ugoshopping.client.ServerServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 *
 * @author Satyam Sharan<satyam.sharan@hotmail.com>
 */
public class Feedback extends VerticalPanel implements PopUpWidget{

    private PopUpDialog dialog;
    
    private Label headerLabel;
    private Button submit;
    private TextArea feedbackArea;
    public Feedback() {
        setSpacing(5);
        headerLabel= new Label("Feedback");
        submit=new Button("Submit");
        feedbackArea=new TextArea();
        
        headerLabel.setStyleName("Feedback-headerLabel");
        feedbackArea.setStyleName("Feedback-feedbackArea");
        
        add(headerLabel);
        add(feedbackArea);
        add(submit);
        submit.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                Window.alert("Thanks for the feedback.. :)");
            }
        });
    }

    @Override
    public void setDialog(PopUpDialog dialog) {
        this.dialog = dialog;
    }
    
    public static ServerServiceAsync getService() {
        // Create the client proxy. Note that although you are creating the
        // service interface proper, you cast the result to the asynchronous
        // version of the interface. The cast is always safe because the
        // generated proxy implements the asynchronous interface automatically.

        return GWT.create(ServerService.class);
    }
    
    
}
