package org.academiadecodigo.hackathon.converters;

import org.academiadecodigo.hackathon.persistence.model.User;
import org.academiadecodigo.hackathon.command.UserDto;
import org.academiadecodigo.hackathon.service.mock.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUser implements Converter<UserDto, User> {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @Override
    public User convert(UserDto userDto) {

        User user = (userDto.getId() != null ? userService.get(userDto.getId()) : new User());

        user.setName(userDto.getName());
        user.setAge(userDto.getAge());
        user.setGender(userDto.getGender());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());

        return user;
    }
}
