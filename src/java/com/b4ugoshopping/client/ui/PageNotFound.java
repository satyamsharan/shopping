/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.b4ugoshopping.client.ui;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;
        
/**
 *
 * @author Satyam Sharan<satyam.sharan@hotmail.com>
 */
public class PageNotFound extends VerticalPanel{

    public PageNotFound() {
        setStyleName("PageNotFound");
        Image img= new Image("images/puc.png");
        img.setStyleName("PageNotFound-img");
        add(img);
    }

        
}
