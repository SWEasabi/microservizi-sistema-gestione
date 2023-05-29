package it.SWEasabi.management;


import org.json.JSONObject;

import it.SWEasabi.management.services.AccessKeyService;
import it.SWEasabi.management.services.LocalAccessKeyService;

public class Context 
{
    static AccessKeyService keys = new LocalAccessKeyService();
    
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
    /*
    private static String login(String json)
    {
        try
        {
            JSONObject jsonObject = new JSONObject(json);
            String username = jsonObject.getString("username");
            String password = jsonObject.getString("password");
            if(Authenticator.authenticate(userService, username, password))
            {
                String refreshJwt = issuer.issueRefreshToken(username);
                String accessJwt = issuer.issueAccessToken(refreshJwt);

                JSONObject obj = new JSONObject();
                obj.put("refresh", refreshJwt);
                obj.put("access", accessJwt);
                return obj.toString();
            }
        }
        catch (Exception e) {}
        // errore credenziali/json
        JSONObject obj = new JSONObject();
        obj.put("errore", "Credenziali errate o mancanti");
        return obj.toString();
    }
    */
}
