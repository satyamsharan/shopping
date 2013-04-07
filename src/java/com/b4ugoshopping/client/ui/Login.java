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
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 *
 * @author Satyam Sharan<satyam.sharan@hotmail.com>
 */
public class Login extends VerticalPanel implements PopUpWidget{

    private PopUpDialog dialog;
    
    private Label headerLabel;
    
    
    //private Label emailErrorLabel;
    //private Label passwordErrorLabel;
    
    private TextBox emailBox;
    private TextBox passwordBox;
    
    private Button login;
    
    public Login() {
        setSpacing(5);
        //emailErrorLabel=new Label("");
        //passwordErrorLabel=new Label("");
    
        headerLabel= new Label("Login");
        
        emailBox=new TextBox();
        passwordBox= new PasswordTextBox();
        
        login=new Button("Login");
        
        emailBox.getElement().setAttribute("placeholder", "E-Mail");
        passwordBox.getElement().setAttribute("placeholder", "Password");
        
        headerLabel.setStyleName("Login-headerLabel");
        emailBox.setStyleName("Login-emailBox");
        passwordBox.setStyleName("Login-passwordBox");
        login.setStyleName("Login-login");
        
        add(headerLabel);
        add(emailBox);
        
        //add(emailErrorLabel);
        
        
        add(passwordBox);
        //add(passwordErrorLabel);
        
        add(login);
        
        login.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                getService().login(emailBox.getText(), passwordBox.getText(), new AsyncCallback<String>() {

                    @Override
                    public void onFailure(Throwable caught) {
                        Window.alert("Something went wrong. Please try again.");
                        dialog.disappear(false);
                    }

                    @Override
                    public void onSuccess(String result) {
                        if(result.equals("-1")){
                            dialog.disappear(false);
                            Window.alert("Invalid Email or Password");
                        }else if(result.equals("-1")){
                            dialog.disappear(false);
                            Window.alert("Something went wrong. Please try again.");
                        }else{
                            dialog.disappear(true);
                            Cookies.setCookie("UID", result);
                            Window.Location.reload();
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
