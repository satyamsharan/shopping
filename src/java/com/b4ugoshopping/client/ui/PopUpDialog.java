/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.b4ugoshopping.client.ui;

import com.b4ugoshopping.client.PopUpWidget;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 *
 * @author Satyam Sharan<satyam.sharan@hotmail.com>
 */
public class PopUpDialog extends DialogBox {

    public VerticalPanel innerVP;
    Label title = new Label();
    String cancle;
    String ok;

    public PopUpDialog(String cancle1, String ok) {
        this.cancle = cancle1;
        this.ok = ok;
        

        VerticalPanel vp = new VerticalPanel();
        innerVP = new VerticalPanel();
        Button closeButton = new Button(
                "", new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                disappear(false);
            }
        });

        closeButton.setStyleName("PopUpDialog-closeButton");
        vp.setStyleName("PopUpDialog-vp");
        //innerVP.setStyleName("PopUpDialog-innerVP");
        title.setStyleName("PopUpDialog-title");

        vp.add(closeButton);
        vp.add(innerVP);

        setGlassEnabled(true);
        setAnimationEnabled(true);
        setGlassStyleName("PopUpDialog-Back");
        setWidget(vp);
    }

    @Override
    public void show() {
        super.show();
        super.center();
    }

    public void disappear(boolean response) {
        if (response) {
            History.newItem(ok);
        } else {
            History.newItem(cancle);
        }
        super.hide();
    }

    public void set(String title, PopUpWidget widget) {

        this.title.setText(title);
        innerVP.add(this.title);
        innerVP.add(widget);
    }
    
//    @Override
//    public void setStyleName(String styleName){
//        super.setStyleName(styleName);
//        innerVP.setStyleName(styleName);
//    }
}
