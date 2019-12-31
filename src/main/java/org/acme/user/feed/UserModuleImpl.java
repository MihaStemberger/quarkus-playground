package org.acme.user.feed;


import com.rometools.rome.feed.CopyFrom;
import com.rometools.rome.feed.module.ModuleImpl;

public class UserModuleImpl extends ModuleImpl implements UserModuleIf {

    private String name;
    private String surname;

    public UserModuleImpl() {
        super(UserModuleIf.class, "http://test.miha.si");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public Class<? extends CopyFrom> getInterface() {
        return UserModuleIf.class;
    }

    @Override
    public void copyFrom(CopyFrom copyFrom) {
        UserModuleIf fromCopy = (UserModuleIf) copyFrom;
        setName(fromCopy.getName());
        setSurname(fromCopy.getSurname());
    }
}
