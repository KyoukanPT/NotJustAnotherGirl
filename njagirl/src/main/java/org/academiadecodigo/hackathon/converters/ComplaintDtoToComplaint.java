package org.academiadecodigo.hackathon.converters;

import org.academiadecodigo.hackathon.command.ComplaintDto;
import org.academiadecodigo.hackathon.persistence.model.Complaint;
import org.academiadecodigo.hackathon.service.mock.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ComplaintDtoToComplaint implements Converter<ComplaintDto, Complaint> {

    @Override
    public Complaint convert(ComplaintDto complaintDto) {

        Complaint complaint =  new Complaint();

        complaint.setUserId(complaintDto.getUserId());
        complaint.setText(complaintDto.getText());

        return complaint;

    }

}
