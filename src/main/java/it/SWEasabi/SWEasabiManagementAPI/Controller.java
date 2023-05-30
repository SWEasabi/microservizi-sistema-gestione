package it.SWEasabi.SWEasabiManagementAPI;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import it.SWEasabi.management.Context;
import it.SWEasabi.management.services.*;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

@RestController
public class Controller {

	  Controller() {
	  }
	  

	  @CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	  @GetMapping("/getLamp/{id}")
	  String GetLamp(@PathVariable int id) {
				
			return Context.getLamp(id);
	  }  
	  
	  
	  @CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	  @PutMapping("/addLamp")
	  boolean AddLamp(@RequestBody String data) {
		  
		JsonObject rq = new Gson().fromJson(data, JsonObject.class);
		return Context.insertLamp(rq);
	  }  
	  
}
