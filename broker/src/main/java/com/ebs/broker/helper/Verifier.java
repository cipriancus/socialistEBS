package com.ebs.broker.helper;

//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;

public class Verifier {
//    public static boolean verifyMessage(Message message, Condition condition) {
//        Publication person = (Publication) message.getGeneratedObject();
//        if (condition.getFieldName().equalsIgnoreCase("firstName")) {
//            if (person.getFirstName() != null && condition.getEqualityOperator().equalsIgnoreCase("=")) {
//                return person.getFirstName().equalsIgnoreCase(condition.getValue());
//            }
//        } else if (condition.getFieldName().equalsIgnoreCase("lastName")) {
//            if (person.getLastName() != null && condition.getEqualityOperator().equalsIgnoreCase("=")) {
//                return person.getLastName().equalsIgnoreCase(condition.getValue());
//            }
//        } else if (condition.getFieldName().equalsIgnoreCase("age")) {
//            if (person.getAge() > 0 && condition.getEqualityOperator().equalsIgnoreCase("=")) {
//                return person.getAge() == Integer.parseInt(condition.getValue());
//            } else if (person.getAge() > 0 && condition.getEqualityOperator().equalsIgnoreCase("<")) {
//                return person.getAge() < Integer.parseInt(condition.getValue());
//            } else if (person.getAge() > 0 && condition.getEqualityOperator().equalsIgnoreCase(">")) {
//                return person.getAge() > Integer.parseInt(condition.getValue());
//            }
//        } else if (condition.getFieldName().equalsIgnoreCase("birthDay")) {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//
//            if (person.getBirthDay() == null) {
//                return false;
//            }
//
//            Calendar personCalendar = Calendar.getInstance();
//            personCalendar.setTime(person.getBirthDay());
//
//            Calendar conditionCalendar = Calendar.getInstance();
//            try {
//                conditionCalendar.setTime(sdf.parse(condition.getValue()));
//            } catch (ParseException e) {
//                return false;
//            }
//            if (condition.getEqualityOperator().equalsIgnoreCase("=")) {
//                return personCalendar.equals(conditionCalendar);
//            } else if (condition.getEqualityOperator().equalsIgnoreCase("<")) {
//                return personCalendar.before(conditionCalendar);
//            } else if (condition.getEqualityOperator().equalsIgnoreCase(">")) {
//                return personCalendar.after(conditionCalendar);
//            }
//        }
//        return false;
//    }
}
