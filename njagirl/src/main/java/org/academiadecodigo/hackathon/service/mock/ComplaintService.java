package org.academiadecodigo.hackathon.service.mock;

import org.academiadecodigo.hackathon.persistence.model.Complaint;
import org.academiadecodigo.hackathon.persistence.model.User;
import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ComplaintService {
    private List<Complaint> complaints = new LinkedList<>();

    public ComplaintService(){

    }

    protected Integer getNextId() {
        return complaints.isEmpty() ? 1 : complaints.size() + 1;

    }

    public Complaint get(Integer id) {
        return complaints.get(id);
    }

    public Complaint save(Complaint complaint) {

        if (complaint.getUserId() == null) {
           return null;
        }

        complaints.add(complaint);
        return complaint;
    }

    public void delete(Integer id) {
        complaints.remove(id);
    }

    public List<Complaint> getComplaints() {
        return complaints;
    }

    public void setComplaints(List<Complaint> complaints) {
        this.complaints = complaints;
    }
}
