package org.academiadecodigo.hackathon.converters;

import org.academiadecodigo.hackathon.command.ComplaintDto;
import org.academiadecodigo.hackathon.persistence.model.Complaint;
import org.springframework.stereotype.Component;

@Component
public class ComplaintToComplaintDto extends AbstractConverter<Complaint, ComplaintDto> {

    @Override
    public ComplaintDto convert(Complaint complaint) {

        ComplaintDto complaintDto = new ComplaintDto();

        complaintDto.setUserId(complaint.getUserId());
        complaintDto.setText(complaint.getText());

        return complaintDto;

    }
}