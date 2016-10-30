package temp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by andre on 10/28/2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Forum {
    @XmlElement
    private ArrayList<Thema> themas = new ArrayList<>();

    public Forum() {

    }

    public ArrayList<Thema> getThemas() {
        return themas;
    }

    public void setThemas(ArrayList<Thema> themas) {
        this.themas = themas;
    }

    public void saveXML(String source) {


        try {
            JAXBContext context = JAXBContext.newInstance(this.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(this,new File(source));
            System.out.println(">> Save to XML OK!");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    public Thema getThembyId(Integer id)
    {
      if (id<=themas.size())
      {
          return themas.get(id);
      }
      return null;
    }
    public Thema getThema(String title)
    {
        for (Thema thema: themas) {

            if (thema.getTitle().equals(title))
            {
                return thema;
            }

        }
        return null;


    }

    public void loadXML(String source) {
        try {
            JAXBContext context = JAXBContext.newInstance(this.getClass());
            Unmarshaller unmarshaller = context.createUnmarshaller();
            this.themas = ((Forum) unmarshaller.unmarshal(new File(source))).getThemas();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
