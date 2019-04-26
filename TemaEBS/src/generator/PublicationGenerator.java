package generator;

import fields.FieldFactory;

import java.io.IOException;
import java.io.OutputStream;

public class PublicationGenerator {

    private FieldFactory fieldFactory = new FieldFactory();

    public void generatePublications(int count, OutputStream whereToWrite) throws IOException {

        for(int i=0; i<count; i++) {
            Publication publication =
                    new Publication(fieldFactory.get(FieldFactory.PATIENT_NAME).get(),
                            fieldFactory.get(FieldFactory.DATE_OF_BIRTH).get(),
                            fieldFactory.get(FieldFactory.HEIGHT).get(),
                            fieldFactory.get(FieldFactory.EYE_COLOR).get(),
                            fieldFactory.get(FieldFactory.HEART_RATE).get());
            whereToWrite.write((publication.toString()+"\n").getBytes());
        }
    }
}
