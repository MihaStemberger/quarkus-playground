package org.acme.UserFeed;


import com.sun.syndication.feed.module.ModuleImpl;

public class UserModuleImpl extends ModuleImpl implements UserModuleIf {

    private String _name;
    private String _surname;

    public UserModuleImpl() {
        super(UserModuleIf.class, UserModuleIf.URI);
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        this._name = name;
    }

    @Override
    public String getSurname() {
        return _surname;
    }

    @Override
    public void setSurname(String surname) {
        this._surname = surname;
    }

    @Override
    public Class getInterface() {
        return UserModuleIf.class;
    }

    @Override
    public void copyFrom(Object o) {
        UserModuleIf userModuleIf = (UserModuleIf) o;
        setName(userModuleIf.getName());
        setSurname(userModuleIf.getSurname());
    }
}
