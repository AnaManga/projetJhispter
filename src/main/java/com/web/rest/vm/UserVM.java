package com.web.rest.vm;

import com.service.dto.UserDTO;

import java.util.Set;

/**
 * View Model extending the UserDTO, which is meant to be used in Group UI (users list).
 */

public class UserVM extends UserDTO {

    private Long id;

    private String login;

    private String firstName;

    private String lastName;

    public UserVM() {
        // Empty constructor needed for Jackson.
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "UserVM{" +
            "} " + super.toString();
    }
}
