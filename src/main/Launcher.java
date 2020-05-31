package main;

import structure.Champions;
import structure.Items;
import structure.Maps;

public class Launcher
{
	
	static Champions[] champions = InitializeStructure.createChampionsArray();
	static Maps[] maps = InitializeStructure.createMapsArray();
	static Items[] items = InitializeStructure.createItemsArray();
	
	
	public static void main(String[] args)
	{
		for(Items item: items)
		System.out.println(item);
	}

}
