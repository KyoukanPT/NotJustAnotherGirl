package org.academiadecodigo.hackathon.command;

import org.academiadecodigo.hackathon.persistence.model.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ComplaintDto {

    private Integer id;

    private User user;

    @NotNull(message = "Please, insert your complaint here")
    @NotBlank(message = "Please, insert your complaint here")
    @Size(max = 300)
    private String text;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
