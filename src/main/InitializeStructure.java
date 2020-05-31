package main;

import structure.Champions;
import structure.Items;
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

}
