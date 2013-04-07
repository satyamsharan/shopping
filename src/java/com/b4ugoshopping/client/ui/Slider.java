/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.b4ugoshopping.client.ui;

import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 *
 * @author manu
 */
public class Slider extends VerticalPanel {

    public Slider() {
        Frame slidingFrame = new Frame("slider/show.html?id=" + Random.nextInt(1000));
        slidingFrame.setStyleName("Slider-slidingFrame");
        add(slidingFrame);

    }
}
