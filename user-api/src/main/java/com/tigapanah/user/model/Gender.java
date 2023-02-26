package com.tigapanah.user.model;

public enum Gender {
  MALE("male"), FEMALE("female");

  private String value;

  private Gender(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
