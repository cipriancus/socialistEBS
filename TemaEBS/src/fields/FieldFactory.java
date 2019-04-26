package fields;

public class FieldFactory {

    public static final String HEIGHT = "height";
    public static final String DATE_OF_BIRTH= "DoB";
    public static final String EYE_COLOR= "eye-color";
    public static final String HEART_RATE = "heart-rate";
    public static final String PATIENT_NAME = "patient-name";

    public Field get(String fieldName){
        switch (fieldName){
            case HEIGHT: return new Height();
            case EYE_COLOR: return new EyeColor();
            case DATE_OF_BIRTH: return new DateOfBirth();
            case HEART_RATE: return new HeartRate();
            case PATIENT_NAME: return new PatientName();
            default: return new Field() {
                @Override
                public String get() {
                    return "Unknown field name";
                }
            };
        }
    }
}
