package FirstEclipse.example.FirstEclipse.resource;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FirstEclipse.example.FirstEclipse.model.states;
import FirstEclipse.example.FirstEclipse.service.serviceClass;


@RestController
@RequestMapping("/country")
public class resourceClass
{
	@Autowired
	private serviceClass service;
   @GetMapping("/states")
   public List<states> getAllStates()
   {
	   return service.showAll();
   }
   
   @GetMapping("/states/{id}")
   public List<states> getOneState(@PathVariable(value="id") int id)
   {
	   return service.showOne(id);
   }
   
   @PostMapping("/states")
   public int insertState(@RequestBody states s)
   {
	  return  service.insertAll(s);
   }
   
   @PutMapping("/states/{id}")
   public int updateState(@RequestBody states s, @PathVariable(value="id") int id)
   {
	   return service.updatedState(s,id);
   }
   
   @DeleteMapping("/states/{id}")
   public int deleteState(@PathVariable(value="id") int id)
   { 
	  return service.delete(id) ;
   }
}
