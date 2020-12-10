package org.academiadecodigo.hackathon.converters;

import org.academiadecodigo.hackathon.command.UserDto;
import org.academiadecodigo.hackathon.persistence.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDto extends AbstractConverter<User, UserDto> {
    @Override
    public UserDto convert(User user) {
        UserDto userDto = new UserDto();

        userDto.setName(user.getName());
        userDto.setAge(user.getAge());
        userDto.setGender(user.getGender());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());

        return userDto;
    }
}
