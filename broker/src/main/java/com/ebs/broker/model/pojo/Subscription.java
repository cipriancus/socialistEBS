package com.ebs.broker.model.pojo;

import java.util.ArrayList;
import java.util.Objects;

public class Subscription {
  private ArrayList<SubscriptionProperty> properties = new ArrayList<>();

  public void add(SubscriptionProperty property) {
    properties.add(property);
  }

  public ArrayList<SubscriptionProperty> getProperties() {
    return properties;
  }

  @Override
  public String toString() {
    StringBuilder output = new StringBuilder("{");
    for (SubscriptionProperty property : properties) {
      output.append("(");
      output.append(property.getProperty()).append(",");
      output.append(property.getComparisonSign()).append(",");
      output.append(property.getValue()).append(");");
    }
    if (output.lastIndexOf(";") != -1) output.deleteCharAt(output.lastIndexOf(";"));
    output.append("}");
    return output.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Subscription)) return false;
    Subscription that = (Subscription) o;
    if (this.properties.size() != that.properties.size()) {
      return false;
    }
    for (int iterator = 0; iterator < this.properties.size(); iterator++) {
      if (this.properties.get(iterator).equals(that.properties.get(iterator)) == false)
        return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getProperties());
  }
}
