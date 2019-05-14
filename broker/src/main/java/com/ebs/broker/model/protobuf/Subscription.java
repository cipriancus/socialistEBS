package com.ebs.broker.model.protobuf;

public class Subscription {
  private String fieldName;
  private String equalityOperator;
  private String value;

  public Subscription() {}

  public Subscription(String fieldName, String equalityOperator, String value) {
    this.fieldName = fieldName;
    this.equalityOperator = equalityOperator;
    this.value = value;
  }

  public String getFieldName() {
    return fieldName;
  }

  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }

  public String getEqualityOperator() {
    return equalityOperator;
  }

  public void setEqualityOperator(String equalityOperator) {
    this.equalityOperator = equalityOperator;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public static Subscription parseFrom(String string) {
    return new Subscription();
  }
}
