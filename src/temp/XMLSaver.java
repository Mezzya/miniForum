package temp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by andre on 10/28/2016.
 */
public class XMLSaver implements Saver {
    @Override
    public void save(Object object, String source) {
        try {
            JAXBContext context = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(object,new File(source));
            System.out.println(">> Save to XML OK!");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object load(String source) {

        try {
            JAXBContext context = JAXBContext.newInstance(Object.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return unmarshaller.unmarshal(new File(source));
        } catch (JAXBException e) {
            e.printStackTrace();
        }


        return null;
    }
}
