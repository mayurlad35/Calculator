package dir.v2.service;

import dir.v2.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestCallService {
    private RestTemplate restTemplate;
    public Employee getEmployeeData() {
        String url = "http://dummy.restapiexample.com/api/v1/employees";
        ResponseEntity<Employee> data = restTemplate.getForEntity(url, Employee.class);
        System.out.println(data.getBody());
        return data.getBody();
    }

    public String getOwnServerData() {
        String url = "http://localhost:8080/BangloreDaysV2_war_exploded/xmlResponse";
        ResponseEntity<String> data = restTemplate.getForEntity(url, String.class);
        System.out.println("response : : "+data.getBody());
        return data.getBody();
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
