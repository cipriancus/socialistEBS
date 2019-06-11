package com.ebs.broker.model.pojo;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class SubscriptionProperty {

  String property;
  String comparisonSign;
  String value;

  public SubscriptionProperty() {}

  public SubscriptionProperty(String property, String value) {
    this.property = property;
    this.value = value;
  }

  public SubscriptionProperty(String property, String comparisonSign, String value) {
    this.property = property;
    this.comparisonSign = comparisonSign;
    this.value = value;
  }

  public String getProperty() {
    return property;
  }

  public void setProperty(String property) {
    this.property = property;
  }

  public String getComparisonSign() {
    return comparisonSign;
  }

  public void setComparisonSign(String comparisonSign) {
    this.comparisonSign = comparisonSign;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public static class ComparisonSignGenerator {
    private static String[] signs = {"<=", "<", "=", ">", ">=", "<>"};

    public static String generateComparisonSign() {
      return signs[ThreadLocalRandom.current().nextInt(signs.length)];
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof SubscriptionProperty)) return false;
    SubscriptionProperty that = (SubscriptionProperty) o;
    return Objects.equals(getProperty(), that.getProperty())
        && Objects.equals(getComparisonSign(), that.getComparisonSign())
        && Objects.equals(getValue(), that.getValue());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getProperty(), getComparisonSign(), getValue());
  }
}
