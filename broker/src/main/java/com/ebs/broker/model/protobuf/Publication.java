package com.ebs.broker.model.protobuf;

public class Publication {
  private String fieldName;
  private String value;

  public Publication(){

  }

  public Publication(String fieldName, String value) {
    this.fieldName = fieldName;
    this.value = value;
  }

  public String getFieldName() {
    return fieldName;
  }

  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public static Publication parseFrom(String string) {
    return new Publication();
  }
}
