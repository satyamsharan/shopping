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
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
        
/**
 *
 * @author Satyam Sharan<satyam.sharan@hotmail.com>
 */
public class Join extends VerticalPanel implements PopUpWidget{

    private PopUpDialog dialog;
    
    private Label headerLabel;
    
    
    //private Label emailErrorLabel;
    //private Label passwordErrorLabel;
    
    private TextBox fNameBox;
    private TextBox lNameBox;
    private ListBox sexBox;
    private TextBox emailBox;
    private TextBox passwordBox;
    private TextBox retypePasswordBox;
    private TextBox mobileNoBox;
    
    
    private Button join;
    
    public Join() {
        setSpacing(5);
        //emailErrorLabel=new Label("");
        //passwordErrorLabel=new Label("");
    
        headerLabel= new Label("Join Us");
        
        fNameBox=new TextBox();
        lNameBox=new TextBox();
        sexBox=new ListBox(false);
        emailBox=new TextBox();
        passwordBox= new PasswordTextBox();
        retypePasswordBox= new PasswordTextBox();
        mobileNoBox=new TextBox();
        
        sexBox.addItem("Male");
        sexBox.addItem("Female");
        sexBox.setSelectedIndex(0);
        
        join=new Button("Join Us");
        
        fNameBox.getElement().setAttribute("placeholder", "First Name");
        lNameBox.getElement().setAttribute("placeholder", "Last Name");
        sexBox.getElement().setAttribute("placeholder", "Sex");
        emailBox.getElement().setAttribute("placeholder", "E-Mail");
        passwordBox.getElement().setAttribute("placeholder", "Password");
        retypePasswordBox.getElement().setAttribute("placeholder", "Re-Type Password");
        mobileNoBox.getElement().setAttribute("placeholder", "Mobile Nubmer");
        
        
        headerLabel.setStyleName("Join-headerLabel");
        fNameBox.setStyleName("Join-textBox");
        lNameBox.setStyleName("Join-textBox");
        emailBox.setStyleName("Join-textBox");
        passwordBox.setStyleName("Join-textBox");
        retypePasswordBox.setStyleName("Join-textBox");
        mobileNoBox.setStyleName("Join-textBox");
        
        sexBox.setStyleName("Join-listBox");
        
        join.setStyleName("Join-join");
        
        add(headerLabel);
        add(fNameBox);
        add(lNameBox);
        add(sexBox);
        add(emailBox);
        add(passwordBox);
        add(retypePasswordBox);
        add(mobileNoBox);
        
        add(join);
        
        join.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                getService().register(fNameBox.getText(), lNameBox.getText(), sexBox.getValue(sexBox.getSelectedIndex()), emailBox.getText(), passwordBox.getText(), mobileNoBox.getText(), new AsyncCallback<String>() {

                    @Override
                    public void onFailure(Throwable caught) {
                        dialog.disappear(false);
                        Window.alert("Something went wrong. Please try again.");
                    }

                    @Override
                    public void onSuccess(String result) {
                        if(result.equals("success")){
                            dialog.disappear(true);
                            Window.alert("You are successfully registered.");
                        }else{
                            dialog.disappear(false);
                            Window.alert(result);
                        }
                    }
                });
                
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
