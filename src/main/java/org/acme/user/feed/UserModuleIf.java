package org.acme.user.feed;

import com.rometools.rome.feed.module.Module;

public interface UserModuleIf extends Module {


    public String getName();
    public void setName(String name);

    public String getSurname();
    public void setSurname(String surname);

}
