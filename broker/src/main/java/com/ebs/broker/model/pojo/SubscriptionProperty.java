package com.ebs.broker.model.pojo;

import java.util.concurrent.ThreadLocalRandom;

public class SubscriptionProperty {
//    public enum Type {
//        INT("int"),
//        STRING("string");
//        private String type;
//
//        Type(String type) {
//            this.type = type;
//        }
//
//        public String getValue() {
//            return type;
//        }
//
//        public static Type getEnum(String value) {
//            for (Type type : Type.values())
//                if (type.getValue().equalsIgnoreCase(value)) {
//                    return type;
//                }
//
//            throw new IllegalArgumentException();
//        }
//
//    }

    String property;
    String comparisonSign;
    String value;
//    SubscriptionProperty.Type type;

    public SubscriptionProperty(){}

    public SubscriptionProperty(String property, String value) {
        this.property = property;
        this.value = value;
    }

    public SubscriptionProperty(String property, String comparisonSign, String value) {
        this.property = property;
        this.comparisonSign = comparisonSign;
        this.value = value;
    }

//    public Type getType() {
//        return type;
//    }
//
//    public void setType(Type type) {
//        this.type = type;
//    }

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

    public static class ComparisonSignGenerator{
        private static String[] signs = {"<=","<","=",">",">=","<>"};

        public static String generateComparisonSign(){
            return signs[ThreadLocalRandom.current().nextInt(signs.length)];
        }

    }

}
