package it.SWEasabi.management.services;

public interface LampManagerService
{
    public String getLamp(int IdLampione);
    public boolean addLamp(int IdArea, double Latitudine, double Longitudine, int Luminosita);
    public boolean deleteLamp(int IdLampione);
    public boolean setBrightness(int IdLampione, int Luminosita);
}