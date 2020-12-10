/*package org.academiadecodigo.hackathon.converters;

import org.academiadecodigo.hackathon.command.ComplaintDto;
import org.academiadecodigo.hackathon.persistence.model.Complaint;
import org.academiadecodigo.hackathon.service.mock.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ComplaintDtoToComplaint implements Converter<ComplaintDto, Complaint> {

    private ComplaintService complaintService;

    @Override
    public Complaint convert(ComplaintDto complaintDto) {

        Complaint complaint = (complaintDto.getId() != null ? complaintService.get(complaintDto.getId()) : new Complaint());

        complaint.setUser(complaintDto.getUser());
        complaint.setText(complaintDto.getText());

        return complaint;

    }

    @Autowired
    public void setComplaintService(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }
}*/
