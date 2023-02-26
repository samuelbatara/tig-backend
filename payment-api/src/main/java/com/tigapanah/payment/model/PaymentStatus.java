package com.tigapanah.payment.model;

public enum PaymentStatus {
  PAID("paid"),
  PENDING("pending"),
  UNSUCCESSFUL("unsuccessful"),
  DELETED("deleted");

  private String value;
  private PaymentStatus(String value) {
    this.value = value;
  }
  public String getValue() {
    return value;
  }
}
