package it.SWEasabi.management.services;

public class LocalAreaManagerService implements AreaManagerService
{
    public String getArea(int IdArea)
    {
        if(IdArea == 0)
        {
            return "{ \"Id\": 0, \"Nome\": \"Parco Querini\", \"Auto\": true, \"LivelloInferiore\": 20, \"LivelloSuperiore\": 80 }";
        }
        return "{ \"errore\": \"Si è verificato un'errore\"}";
    }
    public boolean addArea(int IdArea, String Nome, boolean Auto, int LivelloInferiore, int LivelloSuperiore)
    {
        return true;
    }
    public boolean deleteArea(int IdArea)
    {
        return true;
    }
    public boolean setAuto(boolean Auto)
    {
        return true;
    }
    public boolean setBrightnessRange(int LivelloInferiore, int LivelloSuperiore)
    {
        return true;
    }
}