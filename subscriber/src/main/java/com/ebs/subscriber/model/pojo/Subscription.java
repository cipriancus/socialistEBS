package com.ebs.subscriber.model.pojo;

import java.util.ArrayList;

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
        if (output.lastIndexOf(";") != -1)
            output.deleteCharAt(output.lastIndexOf(";"));
        output.append("}");
        return output.toString();
    }
}
