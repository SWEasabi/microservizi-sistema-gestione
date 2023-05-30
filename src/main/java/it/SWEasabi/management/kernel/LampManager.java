package it.SWEasabi.management.kernel;

import it.SWEasabi.management.services.LampManagerService;

public class LampManager {

	private LampManagerService manager;
	
	public LampManager(LampManagerService Manager)
	{
		manager = Manager;
	}
	
	public String getLamp(int id)
	{
		return manager.getLamp(id);
	}
	
	public boolean insertLamp(int idArea, double lgt, double lat, int valore)
	{
		return manager.addLamp(idArea, lgt, lat, valore);
	}
}
