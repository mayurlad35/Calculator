package dir.v2;

import dir.v2.service.OXMService;
import dir.v2.service.RestCallService;
import dir.v2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class HomeController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private OXMService oxmService;
    @Autowired
    private RestCallService restCallService;

    @RequestMapping(method = RequestMethod.GET)
    public String getHomepage(Model model) {
        model.addAttribute("msg", "Calculator project");
        return "home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHomepage1(Model model) {
        model.addAttribute("msg", "banglore v2");
        return "homenew";
    }

    @RequestMapping(value = "/Students", method = RequestMethod.GET)
    public String getAllStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("studentList", students);
        return "student";
    }

    @RequestMapping(value = "/xmlResponse", method = RequestMethod.GET)
    @ResponseBody
    public String getXmlResponse() throws IOException {
        List<Student> students = studentService.getAllStudents();
        StudentList stuList = new StudentList();
        stuList.setStudentList(new ArrayList<Student>(students));
        return oxmService.convertObjeToXml(stuList);
    }

    @RequestMapping(value = "/restCall", method = RequestMethod.GET)
    @ResponseBody
    public String getRestResponse() throws IOException {
        Employee emp = restCallService.getEmployeeData();
        StringBuilder data = new StringBuilder();
        data.append(emp.getStatus()).append("\n");
        for (Data entry : emp.getData()) {
            data.append(entry.id).append("::").append(entry.employee_name).append("\n");
        }
        return data.toString();
    }

    @RequestMapping(value = "/ownRestCall", method = RequestMethod.GET)
    @ResponseBody
    public String getResponse() throws IOException {
        String data = restCallService.getOwnServerData();
        return data;
    }
}
