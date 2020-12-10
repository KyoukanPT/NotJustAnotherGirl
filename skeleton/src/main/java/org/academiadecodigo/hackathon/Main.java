package org.academiadecodigo.hackathon;

import org.academiadecodigo.hackathon.persistence.model.Complaint;
import org.academiadecodigo.hackathon.persistence.model.User;
import org.academiadecodigo.hackathon.service.mock.ComplaintService;
import org.academiadecodigo.hackathon.service.mock.UserService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        ComplaintService complaintService = new ComplaintService();


        User user1 = new User();

        user1.setName("Joana");
        user1.setPhone("96657295");
        user1.setAge(43);
        user1.setEmail("hdhdhd@gmail.com");
        user1.setGender("Female");
        userService.save(user1);

        Complaint complaint = new Complaint();
        complaint.setId(1);
        complaint.setText("Yesterday, i wad osidjwiqodjwqiodjwiuDHWD NWHGEWR FDJKWBSIUHB isbdnqwjbwjkdnaskjnxasjxknwiuedhwadncasjkncascxzc" +
                "sacjsaciosajdcioasjcasiojdascoicasiodfjqweiodjewoifhewuovfbewofhwaifhewiupfhewºfgewfgbcshkbcewifgewiugewcbfhwifbwcbwifwu");
        user1.addComplaint(complaint);

        System.out.println(userService.list().get(0).getName());

        while (true){
            System.out.println(" ");
        }
    }
}
