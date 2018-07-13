package com.sshlearn.web.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

public class UserAction extends ActionSupport {
    private String userName;
    private String passWord;

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String login(){
        if ("admin".equals(userName) && "admin".equals(passWord)){
            ServletActionContext.getRequest().getSession().setAttribute("exist","ok");
            return "main";
        }
        return "login";
    }
}
