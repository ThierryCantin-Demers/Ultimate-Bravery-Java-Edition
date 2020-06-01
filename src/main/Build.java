package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import structure.Boots;
import structure.Champions;
import structure.Items;
import structure.Machete;
import structure.Maps;
import structure.RangeType;

public class Build
{
	private List<?> build;
	private List<Items> items;
	private List<Boots> boots;
	private List<Machete> machete;
	private Champions champion;
	private Maps map;

	public Build(Champions champion, Maps map)
	{
		this.items = Arrays.asList(InitializeStructure.createItemsArray());
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
			items.remove(Items.TITANIC_HYDRA);
			items.remove(Items.RAVENOUS_HYDRA);
		}
		else
			if (champion.getRangeType().equals(RangeType.RANGED))
			{
				items.remove(Items.RUNAAN_S_HURRICANE);
			}
	}

	private void removeItemsFromMap()
	{
		if (map.equals(Maps.SUMMONERS_RIFT))
		{

		}
		else
			if (map.equals(Maps.HOWLING_ABYSS))
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
