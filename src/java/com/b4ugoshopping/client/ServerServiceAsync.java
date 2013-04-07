/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.b4ugoshopping.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 *
 * @author Satyam Sharan<satyam.sharan@hotmail.com>
 */
public interface ServerServiceAsync {

    public void myMethod(String s, AsyncCallback<String> callback);
    public void register(String fName,String lName,String sex, String email, String password,String mobile, AsyncCallback<String> callback);
    public void login(String email, String password, AsyncCallback<String> callback);
}
