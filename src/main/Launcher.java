package main;

import java.util.ArrayList;

import exceptions.ParsingException;
import structure.Boots;
import structure.Item;
import structure.Machete;
import structure.Map;

public class Launcher
{
	
	
	
	public static void main(String[] args) throws ParsingException
	{
		ArrayList<Item> items = InitializeStructure.createItemsArrayList();
		System.out.println(items.get(0).getImgPath());
		
		ArrayList<Boots> boots = InitializeStructure.createBootsArrayList();
		System.out.println(boots.get(0).getImgPath());
		
		ArrayList<Machete> machetes = InitializeStructure.createMacheteArrayList();
		System.out.println(machetes.get(0).getImgPath());
		
		ArrayList<Map> maps = InitializeStructure.createMapsArrayList();
		System.out.println(maps.get(0).getName());
	}

}
