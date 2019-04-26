package generator;

public class Publication {

    String patientName;
    String dateOfBirth;
    String height;
    String eyeColor;
    String heartRate;

    public Publication(String patientName, String dateOfBirth, String height, String eyeColor, String heartRate) {
        this.patientName = patientName;
        this.dateOfBirth = dateOfBirth;
        this.height = height;
        this.eyeColor = eyeColor;
        this.heartRate = heartRate;
    }

    @Override
    public String toString() {
        return ("{(patient-name,\""+patientName+"\");" +
                "(DoB,\""+dateOfBirth+"\");" +
                "(height,"+height+");" +
                "(eye-color,\""+eyeColor+"\");" +
                "(heart-rate,"+heartRate+")}");
    }


}
