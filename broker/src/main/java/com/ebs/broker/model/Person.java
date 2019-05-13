package com.ebs.broker.model;

import java.util.Date;

public class Person {
  private String lastName;

  private String firstName;

  private int age;

  private Date birthDay;

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setBirthDay(Date birthDay) {
    this.birthDay = birthDay;
  }

  public Date getBirthDay() {
    return birthDay;
  }

  @Override
  public String toString() {
    return "("
        + "lastName='"
        + lastName
        + '\''
        + ", firstName='"
        + firstName
        + '\''
        + ", age="
        + age
        + ", birthDay="
        + birthDay
        + ')';
  }
}
