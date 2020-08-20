package dir.v2.service;

import dir.v2.Student;
import dir.v2.StudentList;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;

public class OXMService {
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;
    public String convertObjectToXML(Student student) throws IOException {
        StringWriter sw = new StringWriter();
        marshaller.marshal(student, new StreamResult(sw));
        System.out.println(sw.toString());
        return sw.toString();
    }

    public String convertObjeToXml(StudentList students) throws IOException {
        StringWriter sw = new StringWriter();
        getMarshaller().marshal(students, new StreamResult(sw));
        System.out.println("output : "+ sw.toString());
        return sw.toString();
    }

    public StudentList convertXMLToObjList(String xmlString) throws IOException {
        StringReader sr = new StringReader(xmlString);
        StreamSource ss = new StreamSource(sr);
        StudentList obj = (StudentList)getUnmarshaller().unmarshal(ss);
        System.out.println("student data : " + obj.getStudentList());
        return obj;
    }

    public Marshaller getMarshaller() {
        return marshaller;
    }

    public void setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
    }

    public Unmarshaller getUnmarshaller() {
        return unmarshaller;
    }

    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }
}
