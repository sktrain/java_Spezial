package app;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import app.model.Employee;

public class Client{
	
	public static void main(String[] args) throws JsonProcessingException {
		
		RestTemplate template = new RestTemplate();
		
		Employee emp = template.getForObject("http://localhost:8080/employee/100", Employee.class);
		
		System.out.println(emp);
		
		List<Employee> emplist = template.getForObject("http://localhost:8080/employee", List.class);
		
		System.out.println(emplist.getClass());
		
		System.out.println(emplist == null);
		
		System.out.println(emplist.get(0));
		
		System.out.println(emplist.size());
		
		for (int i=0; i < 107; ++i) {
			System.out.println(emplist.get(i));
			//System.out.println(emplist.get(i).getClass());
			//Vorsicht: hier ist kein Employee eingepackt sondern eine LinkedHashMap
			//toString von der Hashmap sieht fast wie das Original von Employee aus!

		}

		//Von daher: die forEach-Schleife und die Lambda-Methodenreferenz funktioniert nicht
		//Jackson liefert ja auch eine Liste vom Inhaltstyp LinkedHashMap und nicht Employee zurück

//		for (Employee e : emplist) {
//			System.out.println(e);
//		}
//
//		emplist.forEach(System.out::println);

		//Korrektur: Liste soll Employee enthalten (siehe auch https://www.baeldung.com/jackson-collection-array)
//		String fooResourceUrl
//				= "http://localhost:8080/employee";
//		ResponseEntity<String> response
//				= template.getForEntity(fooResourceUrl , String.class);
//
//		String jsonstring  = response.getBody();
//		System.out.println(jsonstring);
//
//		ObjectMapper mapper = new ObjectMapper();
//
//		emplist =mapper.readValue(
//				jsonstring, new TypeReference<List<Employee>>() { });
//
//		//jetzt funktioniert das
//
//		for (Employee e : emplist) {
//			System.out.println(e);
//		}
//
//		emplist.forEach(System.out::println);
		
//		emp.setLastName("Karrer");
//
//		//template schickt das mit MediaType XML
//		template.put("http://localhost:8080/employee/100", emp);

		
		
	}
	
}