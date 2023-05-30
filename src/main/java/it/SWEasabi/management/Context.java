package it.SWEasabi.management;


import org.json.JSONObject;

import com.google.gson.JsonObject;

import it.SWEasabi.management.kernel.LampManager;
import it.SWEasabi.management.services.AccessKeyService;
import it.SWEasabi.management.services.DBLampManagerService;
import it.SWEasabi.management.services.DatabaseConnectionService;
import it.SWEasabi.management.services.LocalAccessKeyService;
import it.SWEasabi.management.services.LocalDatabaseConnectionService;

public class Context 
{
    static AccessKeyService keys = new LocalAccessKeyService();
    static LampManager manager = new LampManager(new DBLampManagerService(new LocalDatabaseConnectionService()));
    
    public static String listener(String json)
    {
        try
        {
            JSONObject jsonObject = new JSONObject(json);
            String function = jsonObject.getString("function");
            switch(function)
            {
                /*
                case "login":
                    return login(json);
                case "logout":
                    return logout(json);
                case "getNewAccess":
                    return refreshAccessJwt(json);
                case "getNewRefresh":
                    return refreshRefreshJwt(json);
                */
            }
        }
        catch (Exception e) {}
        // errore credenziali/json
        JSONObject obj = new JSONObject();
        obj.put("errore", "JSON non valido");
        return obj.toString();
    }
    
    public static String getLamp(int id)
    {
    	return manager.getLamp(id);
    }
    
    public static boolean insertLamp(JsonObject json)
    {
    	int idArea = Integer.parseInt(json.get("idarea").toString());
    	double longitudine = Double.parseDouble(json.get("latitudine").toString());
    	double latitudine = Double.parseDouble(json.get("longitudine").toString());
    	int valore = Integer.parseInt(json.get("valore").toString());
    	return manager.insertLamp(idArea, longitudine, latitudine, valore);
    }
    
}
