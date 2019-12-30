package org.acme.UserFeed;


import com.sun.syndication.feed.module.Module;

public interface UserModuleIf extends Module {

    public static final String URI = "http://rome.dev.java.net/module/sample/1.0";

    public String getName();
    public void setName(String name);

    public String getSurname();
    public void setSurname(String surname);

}
