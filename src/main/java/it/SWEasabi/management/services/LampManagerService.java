package it.SWEasabi.management.services;

import it.SWEasabi.management.DTO.Lamp;

public interface LampManagerService
{
    public Lamp getLamp(int IdLampione);
    public boolean addLamp(int IdArea, double Latitudine, double Longitudine, int Luminosita);
    public boolean deleteLamp(int IdLampione);
}