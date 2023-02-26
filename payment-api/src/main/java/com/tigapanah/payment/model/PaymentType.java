package com.tigapanah.payment.model;

public enum PaymentType {
  GOPAY("gopay"), DANA("dana"), OVO("ovo"), SHOPEEPAY("shopeepay");

  private String value;
  private PaymentType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
