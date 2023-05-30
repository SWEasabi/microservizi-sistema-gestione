package it.SWEasabi.management.services;

public class LocalSensorManagerService implements SensorManagerService
{
    public String getSensor(int IdSensore)
    {
        if(IdSensore == 1 )
        {
            return "{ \"Id\": 1, \"Tipo\": \"sensore\", \"IdArea\": 2, \"Latitudine\": 45.465454, \"Longitudine\": 9.186516, \"Raggio\": 8 }";
        }
        return "{ \"errore\": \"Si è verificato un'errore\"}";
    }
    public boolean addSensor(int IdArea, double Latitudine, double Longitudine, int Raggio)
    {
        return true;
    }
    public boolean deleteSensor(int IdSensore)
    {
        return true;
    }
    public boolean setRadius(int IdSensore, int Raggio)
    {
        return true;
    }
}