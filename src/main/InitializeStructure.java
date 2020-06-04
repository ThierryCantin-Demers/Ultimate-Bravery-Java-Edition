package main;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

import exceptions.ParsingException;
import filemanager.JsonParser;
import structure.Boots;
import structure.Champion;
import structure.Item;
import structure.Keystone;
import structure.Machete;
import structure.Map;
import structure.MinorRune;
import structure.RangeType;
import structure.RuneType;
import structure.StatRune;
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
	
	public static ArrayList<RuneType> createRuneTypeArrayList() throws ParsingException
	{
		TreeMap<String, TreeMap<String, String>> runeTypesTreeMap = JsonParser.parseRunesJSON(DATA_PATH + "runes.json");
		
		List<RuneType> runeTypes = new ArrayList<>();
		
		List<Keystone> keystones = new ArrayList<>();
		List<List<MinorRune>> minorRunes = new ArrayList<>();
		minorRunes.add(new ArrayList<>());
		minorRunes.add(new ArrayList<>());
		minorRunes.add(new ArrayList<>());
		
		
		for(String runeType : runeTypesTreeMap.keySet())
		{
			for(String runeName : runeTypesTreeMap.get(runeType).keySet())
			{
				if(runeTypesTreeMap.get(runeType).get(runeName).equals("keystone"))
				{
					keystones.add(new Keystone(runeName));
				}
				else if(runeTypesTreeMap.get(runeType).get(runeName).equals("minor1"))
				{
					minorRunes.get(0).add(new MinorRune(runeName));
				}
				else if(runeTypesTreeMap.get(runeType).get(runeName).equals("minor2"))
				{
					minorRunes.get(1).add(new MinorRune(runeName));
				}
				else if(runeTypesTreeMap.get(runeType).get(runeName).equals("minor3"))
				{
					minorRunes.get(2).add(new MinorRune(runeName));
				}
				else
				{
					throw new ParsingException("invalid rune");
				}
				
			}
			
			runeTypes.add(new RuneType(runeType, new ArrayList<>(keystones), new ArrayList<>(minorRunes.stream().map(x -> new ArrayList<>(x)).collect(Collectors.toList()))));
			
			keystones.clear();
			minorRunes.get(0).clear();
			minorRunes.get(1).clear();
			minorRunes.get(2).clear();
		}
		
		return (ArrayList<RuneType>) runeTypes;
	}
	
	public static ArrayList<ArrayList<StatRune>> createStatRune2DArrayList()
	{
		TreeMap<String, String> statRunesTreeMap = JsonParser.parseJSON(DATA_PATH + "stat runes.json");
		
		ArrayList<ArrayList<StatRune>> statRunes = new ArrayList<>();
		
		statRunes.add(new ArrayList<>());
		statRunes.add(new ArrayList<>());
		statRunes.add(new ArrayList<>());
		
		for(String category: statRunesTreeMap.keySet())
		{
			if(category.startsWith("Offense"))
			{
				statRunes.get(0).add(new StatRune(statRunesTreeMap.get(category)));
			}
			else if(category.startsWith("Flex"))
			{
				statRunes.get(1).add(new StatRune(statRunesTreeMap.get(category)));
			}
			else if(category.startsWith("Defense"))
			{
				statRunes.get(2).add(new StatRune(statRunesTreeMap.get(category)));
			}
		}
		
		
		return statRunes;
	}

}
