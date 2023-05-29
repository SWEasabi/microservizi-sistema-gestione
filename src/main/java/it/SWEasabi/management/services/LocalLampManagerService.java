package it.SWEasabi.management.services;

public class LocalLampManagerService implements LampManagerService
{
    public String getLamp(int IdLampione)
    {
        if(IdLampione == 0 )
        {
            return "{ \"Id\": 0, \"Tipo\": \"lampione\", \"IdArea\": 2, \"Latitudine\": 45.465454, \"Longitudine\": 9.186516, \"Luminosita\": 70 }";
        }
        return "{ \"errore\": \"Si è verificato un'errore\"}";
    }
    public boolean addLamp(int IdArea, double Latitudine, double Longitudine, int Luminosita)
    {
        return true;
    }
    public boolean deleteLamp(int IdLampione)
    {
        return true;
    }
    public boolean setBrightness(int IdLampione, int Luminosita)
    {
        return true;
    }
}