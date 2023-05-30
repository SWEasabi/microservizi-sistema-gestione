package it.SWEasabi.management.services;

public interface AreaManagerService
{
    public String getArea(int IdArea);
    public boolean addArea(int IdArea, String Nome, boolean Auto, int LivelloInferiore, int LivelloSuperiore);
    public boolean deleteArea(int IdArea);
    public boolean setAuto(boolean Auto);
    public boolean setBrightnessRange(int LivelloInferiore, int LivelloSuperiore);
}