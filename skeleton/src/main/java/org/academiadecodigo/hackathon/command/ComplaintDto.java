package org.academiadecodigo.hackathon.command;

import org.academiadecodigo.hackathon.persistence.model.ComplaintType;
import org.academiadecodigo.hackathon.persistence.model.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ComplaintDto {

    @NotNull(message = "Please, insert your complaint here")
    @NotBlank(message = "Please, insert your complaint here")
    @Size(max = 300)
    private String text;
    private ComplaintType complaintType;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ComplaintType getComplaintType() {
        return complaintType;
    }

    public void setComplaintType(ComplaintType complaintType) {
        this.complaintType = complaintType;
    }
}
