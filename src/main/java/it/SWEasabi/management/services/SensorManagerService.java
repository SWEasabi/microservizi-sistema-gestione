package it.SWEasabi.management.services;

public interface SensorManagerService
{
    public String getSensor(int IdSensore);
    public boolean addSensor(int IdArea, double Latitudine, double Longitudine, int Raggio);
    public boolean deleteSensor(int IdSensore);
    public boolean setRadius(int IdSensore, int Raggio);
}