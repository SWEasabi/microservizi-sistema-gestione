package it.SWEasabi.management;

import java.util.List;

import com.google.gson.JsonObject;

import it.SWEasabi.management.DTO.Lamp;
import it.SWEasabi.management.DTO.Sensor;
import it.SWEasabi.management.kernel.LampManager;
import it.SWEasabi.management.kernel.SensorManager;
import it.SWEasabi.management.port.LocalDTOBuilderService;
import it.SWEasabi.management.services.AccessKeyService;
import it.SWEasabi.management.services.LocalAccessKeyService;
import it.SWEasabi.management.services.LocalDatabaseConnectionService;

public class Context 
{
    static AccessKeyService keys = new LocalAccessKeyService();
    static LampManager lampManager = new LampManager(new LocalDatabaseConnectionService(new LocalDTOBuilderService()));
    static SensorManager sensorManager = new SensorManager(new LocalDatabaseConnectionService(new LocalDTOBuilderService()));
    
    public static String listener(String json)
    {
    	return null;
    }
    
    public static String getLamp(int id)
    {
    	Lamp lampada = lampManager.getLamp(id);
    	
    	JsonObject res = new JsonObject();
    	res.addProperty("id", lampada.getId());
    	res.addProperty("idmisuratore", lampada.getMeasurerId());
    	res.addProperty("idarea", lampada.getAreaId());
    	res.addProperty("longitudine", lampada.getLongitude());
    	res.addProperty("latitudine", lampada.getLatitude());
    	res.addProperty("luminosita", lampada.getBrightness());
    	
    	return res.toString();
    }
    
    public static String getLampsInArea(int idArea)
    {
    	List<Lamp> lampade = lampManager.getLampsInArea(idArea);
    	String response = "";
    	
    	for(Lamp lampada : lampade)
    	{
    		JsonObject res = new JsonObject();
        	res.addProperty("id", lampada.getId());
        	res.addProperty("idmisuratore", lampada.getMeasurerId());
        	res.addProperty("idarea", lampada.getAreaId());
        	res.addProperty("longitudine", lampada.getLongitude());
        	res.addProperty("latitudine", lampada.getLatitude());
        	res.addProperty("luminosita", lampada.getBrightness());
        	response = response + res.toString();
    	}
    	
    	return response;
    }
    
    public static boolean insertLamp(int idArea, double longitudine, double latitudine, int valore)
    {
    	return lampManager.insertLamp(idArea, longitudine, latitudine, valore);
    }
    
    public static boolean deleteLamp(int id)
    {
    	return lampManager.deleteLamp(id);
    }
    
    public static String getSensor(int id)
    {
    	Sensor sensore = sensorManager.getSensor(id);
    	
    	JsonObject res = new JsonObject();
    	res.addProperty("id", sensore.getId());
    	res.addProperty("idmisuratore", sensore.getMeasurerId());
    	res.addProperty("idarea", sensore.getAreaId());
    	res.addProperty("longitudine", sensore.getLongitude());
    	res.addProperty("latitudine", sensore.getLatitude());
    	res.addProperty("luminosita", sensore.getRadius());
    	
    	return res.toString();
    }
    
    public static boolean insertSensor(int idArea, double longitudine, double latitudine, int valore)
    {
    	return sensorManager.insertSensor(idArea, longitudine, latitudine, valore);
    }
    
    public static boolean deleteSensor(int id)
    {
    	return sensorManager.deleteSensor(id);
    }
    
}
