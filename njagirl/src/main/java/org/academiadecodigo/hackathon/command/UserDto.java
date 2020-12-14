package org.academiadecodigo.hackathon.command;

import javax.validation.constraints.*;

public class UserDto {

    private Integer id;

    @NotNull(message = "Name is mandatory!")
    @NotBlank(message = "Name is mandatory!")
    @Size(max = 64)
    private String name;

    @NotNull(message = "Age is mandatory!")
    @NotBlank(message = "Age is mandatory!")
    @Size(min = 2)
    private Integer age;

    @NotNull(message = "Gender is mandatory!")
    @NotBlank(message = "Gender is mandatory!")
    @Size(min = 1, max = 1)
    private String gender;

    @Email
    private String email;

    @Pattern(regexp = "^\\+?[0-9]*$", message = "Phone number contains invalid characters")
    @Size(min = 9, max = 16)
    private String phone;

 public Integer getId() {
  return id;
 }

 public void setId(Integer id) {
  this.id = id;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public Integer getAge() {
  return age;
 }

 public void setAge(Integer age) {
  this.age = age;
 }

 public String getEmail() {
  return email;
 }

 public void setEmail(String email) {
  this.email = email;
 }

 public String getPhone() {
  return phone;
 }

 public void setPhone(String phone) {
  this.phone = phone;
 }

 public String getGender() {
  return gender;
 }

 public void setGender(String gender) {
  this.gender = gender;
 }

 @Override
 public String toString() {
    return "UserDto {" +
             "id=" + id +
             ", Name='" + name + '\'' +
             ", Age='" + age + '\'' +
             ", Gender='" + gender + '\'' +
             ", email='" + email + '\'' +
             ", phone='" + phone + '\'' +
             '}';

 }
}
