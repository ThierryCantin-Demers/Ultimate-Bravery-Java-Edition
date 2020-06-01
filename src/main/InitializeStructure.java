package main;

import structure.Boots;
import structure.Champions;
import structure.Items;
import structure.Machete;
import structure.Maps;

public class InitializeStructure
{

	public static Champions[] createChampionsArray()
	{
		return Champions.values();
	}

	public static Maps[] createMapsArray()
	{
		return Maps.values();
	}

	public static Items[] createItemsArray()
	{
		return Items.values();
	}
	
	public static Boots[] createBootsArray()
	{
		return Boots.values();
	}
	
	public static Machete[] createMacheteArray()
	{
		return Machete.values();
	}

}
