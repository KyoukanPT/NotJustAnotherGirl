package org.academiadecodigo.hackathon.service.mock;

import org.academiadecodigo.hackathon.persistence.dao.jpa.UserDao;
import org.academiadecodigo.hackathon.persistence.model.Complaint;
import org.academiadecodigo.hackathon.persistence.model.User;
import org.springframework.stereotype.Service;

import java.util.*;


public class UserService {
    private UserDao userDao;

    private Map<Integer, User> userMap = new HashMap<>();

    protected Integer getNextId() {
        return userMap.isEmpty() ? 1 : Collections.max(userMap.keySet()) + 1;

    }

        public User get(Integer id) {
        return userMap.get(id);
    }

    public User save(User user) {

        if (user.getId() == null) {
            user.setId(getNextId());
        }

        userMap.put(user.getId(), user);
        return user;
    }

    public void delete(Integer id)  {
        userMap.remove(id);
    }

    public List<User> list() {
        return new ArrayList<>(userMap.values());
    }

    public Complaint addComplaint(Integer id,Complaint complaint){
        User user = get(id);
       return user.addComplaint(complaint);
    }


    }
