package it.SWEasabi.SWEasabiManagementAPI;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import it.SWEasabi.management.Context;

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
	  @GetMapping("/getLampsInArea/{idArea}")
	  String GetLampsInArea(@PathVariable int idArea) {
				
			return Context.getLampsInArea(idArea);
	  }  
	  
	  
	  @CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	  @PutMapping("/addLamp")
	  boolean AddLamp(@RequestBody String data) {
		  
		JsonObject rq = new Gson().fromJson(data, JsonObject.class);
		int idArea = Integer.parseInt(rq.get("idarea").toString());
    	double longitudine = Double.parseDouble(rq.get("latitudine").toString());
    	double latitudine = Double.parseDouble(rq.get("longitudine").toString());
    	int valore = Integer.parseInt(rq.get("valore").toString());
    	
		return Context.insertLamp(idArea,longitudine,latitudine,valore);
	  }  
	  
	  @CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	  @PutMapping("/deleteLamp/{id}")
	  boolean deleteLamp(@PathVariable int id) {
    	
		return Context.deleteLamp(id);
	  }  
	  
	  @CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	  @GetMapping("/getSensor/{id}")
	  String GetSensor(@PathVariable int id) {
				
			return Context.getSensor(id);
	  }  
	  
	  
	  @CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	  @PutMapping("/addSensor")
	  boolean AddSensor(@RequestBody String data) {
		  
		JsonObject rq = new Gson().fromJson(data, JsonObject.class);
		int idArea = Integer.parseInt(rq.get("idarea").toString());
    	double longitudine = Double.parseDouble(rq.get("latitudine").toString());
    	double latitudine = Double.parseDouble(rq.get("longitudine").toString());
    	int valore = Integer.parseInt(rq.get("valore").toString());
    	
		return Context.insertSensor(idArea,longitudine,latitudine,valore);
	  }  
	  
	  @CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	  @PutMapping("/deleteSensor/{id}")
	  boolean deleteSensor(@PathVariable int id) {
    	
		return Context.deleteSensor(id);
	  }  
	  
}
