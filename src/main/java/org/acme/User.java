package org.acme;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class User {

    @NotNull(message = "Invalid name value")
    private String name;

    @NotBlank(message = "Invalid surname value")
    private String surname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public User() {
    }
}
