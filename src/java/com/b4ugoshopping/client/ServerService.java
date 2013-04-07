/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.b4ugoshopping.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 *
 * @author Satyam Sharan<satyam.sharan@hotmail.com>
 */
@RemoteServiceRelativePath("serverservice")
public interface ServerService extends RemoteService {

    public String myMethod(String s);
    public String register(String fName,String lName,String sex, String email, String password,String mobile);
    public String login(String email, String password);
}
