package main;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import exceptions.ParsingException;
import filemanager.JsonParser;
import structure.Boots;
import structure.Champion;
import structure.Item;
import structure.Machete;
import structure.Map;
import structure.RangeType;

public class InitializeStructure
{

	private static String DATA_PATH = System.getProperty("user.dir") + "\\data\\";
	
	public static ArrayList<Champion> createChampionsArrayList() throws ParsingException
	{
		List<Champion> champions = new ArrayList<>();
		RangeType range = null;
		
		TreeMap<String, String> championsHashMap = JsonParser.parseJSON(DATA_PATH + "champions.json");
		
		for(String name: championsHashMap.keySet())
		{
			if(championsHashMap.get(name).equals("Melee"))
			{
				range = RangeType.MELEE;
			}
			else if(championsHashMap.get(name).equals("Ranged"))
			{
				range = RangeType.RANGED;
			}
			else if(championsHashMap.get(name).equals("Mixed"))
			{
				range = RangeType.MIXED;
			}
			else
			{
				throw new ParsingException("Champion range type is invalid or undefined");
			}
			
			champions.add(new Champion(name, range));
		}
		
		return (ArrayList<Champion>) champions;
	}

	public static ArrayList<Map> createMapsArrayList()
	{
		return null;
	}

	public static ArrayList<Item> createItemsArrayList()
	{
		List<Item> items = 
		
		return null;
	}
	
	public static SortedSet<Boots> createBootsArrayList()
	{
		SortedSet<Boots> boots = new TreeSet<>();
		
		boots.add(new Boots("Berserker's Greaves"));
		boots.add(new Boots("Boots of Mobility"));
		boots.add(new Boots("Boots of Swiftness"));
		boots.add(new Boots("Ionian's Boots of Lucidity"));
		boots.add(new Boots("Mercury's Treads"));
		boots.add(new Boots("Ninja Tabi"));
		boots.add(new Boots("Sorcerer's Shoes"));
		
		return boots;
	}
	
	public static ArrayList<Machete> createMacheteArrayList()
	{
		return null;
	}
	
	

}
