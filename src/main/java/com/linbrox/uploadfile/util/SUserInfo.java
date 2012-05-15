/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linbrox.uploadfile.util;

import com.jcraft.jsch.UserInfo;

/**
 *
 * @author zepolar
 */
public class SUserInfo implements UserInfo{

    private String password;
    private String passPhrase;

    public SUserInfo(String password, String passPhrase) {
        this.password = password;
        this.passPhrase = passPhrase;
    }

    @Override
    public String getPassphrase() {
        return passPhrase;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean promptPassphrase(String arg0) {
        return true;
    }

    @Override
    public boolean promptPassword(String arg0) {
        return false;
    }

    @Override
    public boolean promptYesNo(String arg0) {
        return true;
    }

    @Override
    public void showMessage(String arg0) {
        System.out.println("SUserInfo.showMessage()");
    }
}
