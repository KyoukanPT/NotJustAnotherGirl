package org.academiadecodigo.hackathon.controller.rest;

import org.academiadecodigo.hackathon.command.Signin;
import org.academiadecodigo.hackathon.command.UserDto;
import org.academiadecodigo.hackathon.converters.ComplaintToComplaintDto;
import org.academiadecodigo.hackathon.converters.UserDtoToUser;
import org.academiadecodigo.hackathon.converters.UserToUserDto;
import org.academiadecodigo.hackathon.persistence.model.Complaint;
import org.academiadecodigo.hackathon.persistence.model.User;
import org.academiadecodigo.hackathon.service.mock.AuthService;
import org.academiadecodigo.hackathon.service.mock.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserRestController {
    private UserService userService;
    private UserDtoToUser userDtoToUser;
    private UserToUserDto userToUserDto;
    private AuthService authService;
    private ComplaintToComplaintDto complaintToComplaintDto;

    @Autowired
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    @Autowired
    public void setUserDtoToUser(UserDtoToUser userDtoToUser) {
        this.userDtoToUser = userDtoToUser;
    }

    @Autowired
    public void setUserToUserDto(UserToUserDto userToUserDto) {
        this.userToUserDto = userToUserDto;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public ResponseEntity<List<UserDto>> listUser() {

        List<UserDto> userDtos = userService.list().stream()
                .map(user -> userToUserDto.convert(user))
                .collect(Collectors.toList());

        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<UserDto> showUser(@PathVariable Integer id) {

        User user = userService.get(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>( userToUserDto.convert(user), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public ResponseEntity<?> addUser(@Valid @RequestBody User userDto, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {

        if (bindingResult.hasErrors() || userDto.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        for(User user : userService.list()){
            if(user.getEmail().equals(userDto.getEmail())){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        User savedUser = userService.save(userDto);



        // get help from the framework building the path for the newly created resource
        UriComponents uriComponents = uriComponentsBuilder.path("/api/customer/" + savedUser.getId()).build();

        // set headers with the created path
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());

        return new ResponseEntity<>(headers,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<User> editUser(@Valid @RequestBody User userDto, BindingResult bindingResult, @PathVariable Integer id) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (userDto.getId() != null && !userDto.getId().equals(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (userService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        userDto.setId(id);

        userService.save(userDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}/showComplaints")
    public ResponseEntity<List<Complaint>> showComplaints(@PathVariable Integer id){
        List<Complaint> complaintList = userService.get(id).getComplaintList();
        return new ResponseEntity<>(complaintList,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/addComplaint")
    public ResponseEntity<Complaint> addComplaint(@Valid @RequestBody Complaint complaint, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        userService.get(complaint.getUserId()).addComplaint(complaint);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Integer id) {

            userService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @RequestMapping(method = RequestMethod.GET,path = "/signin")
    public ResponseEntity<?> login(@Valid Signin signin){
        System.out.println(signin.getEmail());
        User user = authService.authenticate(signin);
        if(user != null){
            return new ResponseEntity<>(user,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
