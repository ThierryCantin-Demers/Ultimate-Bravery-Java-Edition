package main;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import exceptions.ParsingException;
import filemanager.JsonParser;
import structure.Boots;
import structure.Champion;
import structure.Item;
import structure.Machete;
import structure.Map;
import structure.RangeType;
import structure.SummonerSpell;

public class InitializeStructure
{

	private static String DATA_PATH = System.getProperty("user.dir") + "\\data\\";
	
	public static ArrayList<Champion> createChampionsArrayList() throws ParsingException
	{
		List<Champion> champions = new ArrayList<>();
		RangeType range = null;
		
		TreeMap<String, String> championsTreeMap = JsonParser.parseJSON(DATA_PATH + "champions.json");
		
		for(String name: championsTreeMap.keySet())
		{
			if(championsTreeMap.get(name).equals("Melee"))
			{
				range = RangeType.MELEE;
			}
			else if(championsTreeMap.get(name).equals("Ranged"))
			{
				range = RangeType.RANGED;
			}
			else if(championsTreeMap.get(name).equals("Mixed"))
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
		TreeMap<String, String> mapsTreeMap = JsonParser.parseJSON(DATA_PATH + "maps.json"); 
		
		List<Map> maps = new ArrayList<>();
		
		for(String name: mapsTreeMap.keySet())
		{
			maps.add(new Map(name));
		}
		
		
		return (ArrayList<Map>) maps;
	}

	public static ArrayList<Item> createItemsArrayList()
	{
		TreeMap<String, String> itemsTreeMap = JsonParser.parseJSON(DATA_PATH + "items.json"); 
		
		List<Item> items = new ArrayList<>();
		
		for(String name: itemsTreeMap.keySet())
		{
			items.add(new Item(name));
		}
		
		
		return (ArrayList<Item>) items;
	}
	
	public static ArrayList<Boots> createBootsArrayList()
	{
		TreeMap<String, String> bootsTreeMap = JsonParser.parseJSON(DATA_PATH + "boots.json"); 
		
		List<Boots> boots = new ArrayList<>();
		
		for(String name: bootsTreeMap.keySet())
		{
			boots.add(new Boots(name));
		}
		
		
		return (ArrayList<Boots>) boots;
	}
	
	public static ArrayList<Machete> createMacheteArrayList()
	{
		TreeMap<String, String> macheteTreeMap = JsonParser.parseJSON(DATA_PATH + "machetes.json"); 
		
		List<Machete> machetes = new ArrayList<>();
		
		for(String name: macheteTreeMap.keySet())
		{
			machetes.add(new Machete(name));
		}
		
		
		return (ArrayList<Machete>) machetes;

	}
	
	public static ArrayList<SummonerSpell> createSummonerSpellArrayList()
	{
		TreeMap<String, String> summSpellsTreeMap = JsonParser.parseJSON(DATA_PATH + "summoner spells.json");
		
		List<SummonerSpell> summSpells = new ArrayList<>();
		
		for(String name: summSpellsTreeMap.keySet())
		{
			summSpells.add(new SummonerSpell(name));
		}
		
		return (ArrayList<SummonerSpell>) summSpells;
	}

}
