package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import structure.Boots;
import structure.Champion;
import structure.Item;
import structure.Items;
import structure.Machete;
import structure.Map;
import structure.Maps;
import structure.RangeType;

public class Build
{
	private List<?> build;
	private List<Item> items;
	private List<Boots> boots;
	private List<Machete> machete;
	private Champion champion;
	private Map map;

	public Build(Champion champion, Map map)
	{
		this.items = InitializeStructure.createItemsArrayList();
		removeItems();
		
		this.boots = Arrays.asList(InitializeStructure.createBootsArray());
		this.machete = Arrays.asList(InitializeStructure.createMacheteArray());
	
		this.champion = champion;
		this.map = map;
	}

	private void removeItems()
	{
		removeItemsFromChampionRangeType();
		removeItemsFromMap();
	}

	private void removeItemsFromChampionRangeType()
	{
		if (champion.getRangeType().equals(RangeType.MELEE))
		{
			items.remove();
			items.remove();
		}
		else
			if (champion.getRangeType().equals(RangeType.RANGED))
			{
				items.remove();
			}
	}

	private void removeItemsFromMap()
	{
		if (map.equals())
		{

		}
		else
			if (map.equals())
			{

			}
	}
	
	public List<?> generateBuild()
	{
		List<?> build = new ArrayList<>();
		
		if(champion.getHasBoots())
		{
			build.add(items.get(randIndex(0, items.size())));
		}
		
		
	}
	
	
	private int randIndex(int min, int max)
	{
		return (int) (Math.random() * (max - min) + 1) + min;
	}
}
